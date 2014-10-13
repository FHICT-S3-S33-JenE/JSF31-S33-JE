/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingballsfx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Eric
 */
public class RW {

    private int readersActive = 0;
    private int writersActive = 0;
    private int readersWaiting = 0;

    Lock monLock = new ReentrantLock();
    Condition okToRead = monLock.newCondition();
    Condition okToWrite = monLock.newCondition();

    public void enterReader() throws InterruptedException
    {
        monLock.lock();
        try
        {
            while (writersActive != 0)
            {
                readersWaiting++;
                okToRead.await();
                readersWaiting--;
                
            }
            readersActive++;
        }
        catch (InterruptedException ex)
        {
            ex.getMessage();
        } finally
        {
            monLock.unlock();
        }
    }

    public void exitReader()
    {
        monLock.lock();
        try{
            readersActive--;
            if(readersActive == 0)
            {
                okToWrite.signal();
            }
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
        finally
        {
            monLock.unlock();
        }
    }

    public void enterWriter()
    {
        monLock.lock();
        try
        {
            while(writersActive > 0 || readersActive > 0)
            {
                okToWrite.await();
                //writersActive++;
            }
            writersActive++;
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
        finally
        {
            monLock.unlock();
        }
    }

    public void exitWriter()
    {
        monLock.lock();
        try
        {
            writersActive--;
            if(readersWaiting > 0)
            {
                okToRead.signal();
            }
            else
            {
                okToWrite.signal();
            }
        }
        finally
        {
            monLock.unlock();
        }
    }
}

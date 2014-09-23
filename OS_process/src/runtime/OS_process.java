/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsf3
 */
public class OS_process {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeStamp ts = new TimeStamp();
        ts.setBegin("Begin van de meting");
        if (args.length % 2 == 1) {
            System.out.print("oneven aantal args");
        } else {
            for (int i = 0; i < args.length; i = i + 2) {
                String[] arg = {args[i], args[i+1]};
                Thread t = new Thread(new ProcessNew(arg));
                t.start();
            }
        }

        ts.setEnd("eind");
        System.out.print(ts.toString());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted: " + ex.toString());
        }
    }
}

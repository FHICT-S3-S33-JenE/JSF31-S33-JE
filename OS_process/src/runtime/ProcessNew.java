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
import java.util.ArrayList;

/**
 *
 * @author jsf3
 */
public class ProcessNew implements Runnable {

    private final String[] args;

    public ProcessNew(String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        int i = 0;
        ProcessBuilder pb;
        String eerste = args[i];
        i++;
        String tweede = args[i];
        if (!tweede.equalsIgnoreCase(" ")) {
            pb = new ProcessBuilder(eerste);
        } else {
            pb = new ProcessBuilder(eerste + " " + tweede);
        }
        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            Thread.sleep(2000);
            p.destroy();
        } catch (IOException ex) {
            System.out.println("Error executing command");
        } catch (InterruptedException ex) {
            System.out.println("Error executing command");
        }
        System.out.println("Thread is finished");
    }
}

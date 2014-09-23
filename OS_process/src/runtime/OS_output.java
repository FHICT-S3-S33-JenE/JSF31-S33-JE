/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsf3
 */
public class OS_output {

    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD
    public static void main(String[] args)
    {
        // schrijft de output van het commando ls naar de output.
        try
        {
            ProcessBuilder pb = new ProcessBuilder("ls");
=======
    public static void main(String[] args) {

        //schrijft de output van het command ls naar het output scherms
        try {
            ProcessBuilder pb = new ProcessBuilder("lss");
>>>>>>> FETCH_HEAD
            Process proc;
            proc = pb.start();
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr))
            {
                String line;
                while ((line = br.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("Error");
        }

    }

}

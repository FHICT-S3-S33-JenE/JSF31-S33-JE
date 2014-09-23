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

    public static void main(String[] args)
    {

        try
        {
            ProcessBuilder pb = new ProcessBuilder("ls");
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

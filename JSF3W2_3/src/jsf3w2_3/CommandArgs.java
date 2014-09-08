/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf3w2_3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author jsf3
 */
public class CommandArgs {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties applicationProps = new Properties();
        FileOutputStream out = new FileOutputStream("appProperties");

        if (args.length < 2) {
            System.out.println("Not enough arguments.");
        } else if (args.length % 2 == 1) {
            System.out.println("For every property, please enter a value.");
        } else {
            for (int i = 0; i < args.length; i = i + 2) {
                applicationProps.setProperty(args[i], args[i + 1]);

            }
            applicationProps.store(out, "---CommandArgs---");
        }
    }

}

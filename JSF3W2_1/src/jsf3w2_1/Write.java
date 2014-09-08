/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf3w2_1;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author jsf3
 */
public class Write {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties applicationProps = new Properties();
        FileOutputStream out = new FileOutputStream("appProperties");
        String value = System.getenv("TestEnviron");
        if (value != null) {
            applicationProps.setProperty("TestEnviron", value);
            applicationProps.store(out, "---TestEnviron---");
        }
        System.out.println("TestEnviron = " + value);
    }
}

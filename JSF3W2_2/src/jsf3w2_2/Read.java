/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf3w2_2;

import java.io.*;
import java.util.*;

/**
 *
 * @author jsf3
 */
public class Read {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties applicationProps = new Properties();
        try (FileInputStream in = new FileInputStream("appProperties")) {
            applicationProps.load(in);
        }
        
        Set<Object> keys = applicationProps.keySet();
        List<String> categoryList = new ArrayList<>();
        for(Object key : keys)
        {
            categoryList.add((String)key + " = " + applicationProps.getProperty((String)key));
        }
        System.out.println(categoryList);
    }

}

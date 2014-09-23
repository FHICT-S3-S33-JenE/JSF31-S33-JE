/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

/**
 *
 * @author jsf3
 */
public class OS_runtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creeert 100.000 strings met hello.
        long start = printRuntime();

        System.out.println("Using string...");

        String s = "";
        for (int i = 0; i < 100000; i++) {
            s = s.concat("Hello" + i);
        }
        long string = printRuntime();

        // garbage collection
        System.gc();
        System.out.println("Using stringbuilder...");

        //100.000 string worden dmv de stringbuilder 
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            b = b.append("Hello").append(i);
        }

        long stringbuilder = printRuntime();
        System.out.println("Amount of memory used by string = " + (string - start));
        System.out.println("Amount of memory used by stringbuilder = " + (stringbuilder - start));

        System.gc();
        printRuntime();
    }

    private static long printRuntime() {
        //schrijft informatie naar het output scherm, deze informatie is onderandere: aantal processors, memory etc.
        // deze methode return deze informatie.
        Runtime currentRun = Runtime.getRuntime();
        System.out.println("Available processors = " + currentRun.availableProcessors());
        long totalmemory = currentRun.totalMemory();
        long freememory = currentRun.freeMemory();
        long usedmemory = totalmemory - freememory;
        System.out.println("Total available memory = " + totalmemory);
        System.out.println("Max available memory = " + currentRun.maxMemory());
        System.out.println("Free memory = " + freememory);
        System.out.println("Used memory = " + usedmemory);
        return usedmemory;
    }
}

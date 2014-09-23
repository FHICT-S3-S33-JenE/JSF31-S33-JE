/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.IOException;

/**
 *
 * @author jsf3
 */
public class OS_process {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("gnome-calculator");
        try {
            Process p = pb.start();
            Thread.sleep(5000);
            p.destroy();
        } catch (IOException ex) {
            System.out.println("Error when opening 'gnome-calculator'");
        } catch (InterruptedException ex) {
            System.out.println("Error when making thread sleep");
        }

        try {
            Process p = Runtime.getRuntime().exec("gnome-calculator");
            Thread.sleep(5000);
            p.destroy();
        } catch (IOException ex) {
            System.out.println("Error when opening 'gnome-calculator'");
        } catch (InterruptedException ex) {
            System.out.println("Error when making thread sleep");
        }
    }

}

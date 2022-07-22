/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barreraciclica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 06224681
 */
public class BarreraCiclica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ferry ferry = new Ferry();
        for (int i = 1; i <= 50; i++) {

            Coche coche=new Coche(ferry, i);
            coche.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarreraCiclica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

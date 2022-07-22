package pkg03_pastelero;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Semaphore bombones;
    Semaphore reponer;
       bombones= new Semaphore(0);
       reponer= new Semaphore(1);
        
       Pastelero pastelero= new Pastelero(reponer, bombones);
       pastelero.start();
               
       for( int i=1; i<=15;i++){
           
           (new Niño(reponer,bombones, i)).start();
           
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    
}

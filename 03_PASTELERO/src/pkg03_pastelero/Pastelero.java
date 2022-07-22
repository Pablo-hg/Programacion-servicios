package pkg03_pastelero;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pastelero extends Thread{
    Semaphore reponer;
    Semaphore bombones;

    public Pastelero(Semaphore reponer, Semaphore bombones) {
        this.reponer = reponer;
        this.bombones = bombones;
    }
    
   
    
    public void run(){
        for (int i = 1; i <=5; i++) {
            try {
                reponer.acquire();
                System.out.println("Pastelero repone ");
                bombones.release(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pastelero.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}

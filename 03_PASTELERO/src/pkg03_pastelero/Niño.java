package pkg03_pastelero;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Niño extends Thread {
      Semaphore reponer;
    Semaphore bombones;
    int i;

    public Niño(Semaphore reponer, Semaphore bombones, int i) {
        this.reponer = reponer;
        this.bombones = bombones;
        this.i=i;
    }
    
    
    
    
    public void run(){
    if (bombones.availablePermits()>1){
        try {
            bombones.acquire(2);
            System.out.println("Soy el niño "+i+" Cojo 2 bombones");
        } catch (InterruptedException ex) {
            Logger.getLogger(Niño.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else
    {  
        try {
        bombones.acquire();
        System.out.println("Soy el niño "+i+" Cojo 1 bombon");
        reponer.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Niño.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
}

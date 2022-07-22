
package examen_1ºeva_pablohorcajadagonzález;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bandeja {
    
    //repartidor espera mientras  no haya pizzas
    //cocinero espera mientras la bandeja está llena
    int maxbandeja = (int) ((Math.random()*5)+10);
    //boolean bandeja = false; //para saber si la bandeja está llea o no(false es que si)
    int pizza;
    ArrayList<Integer> bandeja = new ArrayList();
    
    public synchronized void  QuitardeBandeja(){
        try {
            while(bandeja.isEmpty()){
                System.out.println("La bandeja está vacia");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bandeja.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.pizza = bandeja.size();
            for(int i = 0; i < pizza;i++){
                bandeja.remove(0);
            }
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bandeja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public synchronized void PonerenBandeja(int pizza){
        
        while(bandeja.size()==maxbandeja){
            try {
                System.out.println("La bandeja está llena con " + maxbandeja + " pizzas");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bandeja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.pizza=pizza;
        bandeja.add(pizza);
        notifyAll();
    }
    
    
    
    
    
    
}

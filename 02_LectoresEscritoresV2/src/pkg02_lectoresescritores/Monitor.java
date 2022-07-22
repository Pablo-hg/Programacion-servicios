
package pkg02_lectoresescritores;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Monitor {
    
    int valor;
    boolean disponible = false;                                    

    //Hacer métodos "syncronized" hace que el resto "sybcronized" se paren hasta que el 1º acabe
    public synchronized int getValor() {
        
        while(!disponible){
            try {
                wait();//Bloquear mientras while sea true
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        disponible = false;
        notifyAll();//Desbloquea el/los métodos y vuelve a bloquear
        return valor;
    }

    public synchronized void setValor(int valor) {
        
        while(disponible){
            try {
                wait();//Bloquea el método hasta que me desbloqeen
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.valor=valor;
        
        notifyAll();//Desbloquea el/los métodos y vuelve a bloquear
        disponible=true;
    }
}


package pkg02_gráficos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloIzquierda extends Thread{
    
    MiCanvas canvas;

    public HiloIzquierda(MiCanvas canvas) {
        this.canvas = canvas;
    }
    
    public void run(){
        while(true){
            canvas.moverIzquierda();
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloDerecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


package pkg02_gráficos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloDerecha extends Thread{
    
    MiCanvas canvas;

    public HiloDerecha(MiCanvas canvas) {
        this.canvas = canvas;
    }
    
    public void run(){
        while(true){
            canvas.moverDerecha();
            try {
                sleep(70);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloDerecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

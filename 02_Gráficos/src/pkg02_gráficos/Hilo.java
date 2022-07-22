 
package pkg02_gráficos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    
    MiCanvas canvas;

    public Hilo(MiCanvas canvas) {
        this.canvas = canvas;
    }
    
    public void run(){
        while(true){
            canvas.mover();
            try {
                sleep(100);//cada 0.1 segundo duermes y vuelves a ejecutar
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

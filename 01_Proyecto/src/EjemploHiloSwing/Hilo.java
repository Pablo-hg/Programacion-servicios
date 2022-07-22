
package EjemploHiloSwing;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class Hilo extends Thread{
    
    JLabel etiquetaContador;
    
    int ini,fin;
    
    Hilo(JLabel etiquetaContador, int ini, int fin){
        this.etiquetaContador=etiquetaContador;
        this.ini=ini;
        this.fin=fin;
    }   
    
    public void run(){
        
        for (int i = ini; i <= fin ; i++){
            etiquetaContador.setText(String.valueOf(i));
            try {
                sleep(100);//al estar dentro del "Thread" no me hace falta llamarlo
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
}

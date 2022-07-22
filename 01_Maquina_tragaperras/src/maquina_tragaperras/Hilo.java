
package maquina_tragaperras;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Hilo extends Thread {
    JButton rueda;
    
   
    Hilo(JButton rueda){
        this.rueda = rueda;

    }
   
    public void run(){
       int i = 9;
        while( true) {
            String numero = "num"+i+".png";
            ImageIcon icono = new ImageIcon(".\\imagenes\\"+numero);
            ImageIcon iconoEscalado = new ImageIcon (icono.getImage().getScaledInstance(this.rueda.getWidth(), this.rueda.getHeight(), 0));
            this.rueda.setIcon(iconoEscalado);
            if(i==9){
                i=0;
            }
            i++;
        }
    }
}
    
    

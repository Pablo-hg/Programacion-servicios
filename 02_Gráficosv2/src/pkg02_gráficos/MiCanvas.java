
package pkg02_gráficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiCanvas extends Canvas{

    int verde = -11; //posicion circulo verde
    int azul = 400; //posicion circulo azul
    boolean zonaV = false;
    boolean zonaA = false;
    
    public MiCanvas() {
        //Punto de partida es el 22,22 y el ancho y alto 400,400
        this.setBounds(22,22,400,400);
        this.setBackground(Color.gray);
    }
    
    @Override
    public void paint (Graphics g){
        
      //Creamos un objeto Graphics2D para pintar   
      Graphics2D gráfico = (Graphics2D) g;
      
      //Pintamos el rectángulo en la zona central
      gráfico.setColor(Color.darkGray);
      gráfico.fillRect(100, 0, 200, 400);
      
      //Pintamos circulo x en el lienzo
      gráfico.setColor(Color.green);
      gráfico.fillOval(verde,180,10,10);
      
      //Pintamos circulo y en el lienzo
      gráfico.setColor(Color.blue);
      gráfico.fillOval(azul,240,10,10);
      repaint();
    }
    
    //Método que mueve de izquierda a derecha el circulo verde
    public synchronized void moverDerecha(){
        //Mientras zonaA sea true y verde sea 90 , bloqueamos moverDerecha()
        while (zonaA && verde == 90){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MiCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        verde++;
        if (verde == 400){
            verde = -11;
        }
        //Si verde está en la zona gris
        if (verde < 300 && verde > 100){
            zonaV = true;
        } else {
            zonaV = false;
            notifyAll();
        }
    }
    
    //Método que mueve de derecha izquierda el circulo azul
    public synchronized void moverIzquierda(){
        //Mientras zonaV sea true y azul sea 300, bloqueamos moverIzquierda()
        while (zonaV && azul == 300){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MiCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        azul--;
        if (azul == -11){
            azul = 400;
        }
        //Si azul está en la zona gris
        if (azul < 300 && azul > 100){
            zonaA = true;
        } else {
            zonaA = false;
            notifyAll();
        }
        
    }
}

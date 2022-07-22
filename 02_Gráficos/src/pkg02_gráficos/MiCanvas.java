
package pkg02_gráficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MiCanvas extends Canvas{

    int x = -39;//Posicion del Circulo rojo
    int y = 400;//posicion del circulo verde
    
    public MiCanvas() {
        this.setBounds(22,22,400,400);//Punto de partida es el 22,22 y el ancho y alto 400,400
        this.setBackground(Color.white);
    }
    
    @Override
    public void paint (Graphics g){
        
      Graphics2D gráfico = (Graphics2D) g;
      
      //Hay que hacer que la x se cambie todo el rato
      gráfico.setColor(Color.red);
      gráfico.fillOval(x,180,40,40);
      
      gráfico.setColor(Color.green);
      gráfico.fillOval(y,240,40,40);
     
    }
    
    public void mover(){
        x++;
        y--;
        repaint();//Actualiza el dibujo llamando al método paint otra vez
        if (x == 400){
            x = -31;
        }
        if (y == -31){
            y = 400;
        }
    }
    
}

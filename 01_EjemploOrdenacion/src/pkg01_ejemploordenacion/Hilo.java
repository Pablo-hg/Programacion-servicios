
package pkg01_ejemploordenacion;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Hilo extends Thread {
    
    
    Ventana ventana = new Ventana();
    int[] array;
    JButton boton1;
    JPanel panel;
    
     

    Hilo(int[] array, JPanel panel) {
        this.array = array;
        this.panel = panel;
    }
    
    
    @Override
    public void run(){
        //Método de la burbuja (ordenar de menor a mayor y cambiar de color cuando los numeros se fijan)
        for(int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                        int aux = array[j + 1];
                        array[j + 1] = array[j];
                        ((JButton)panel.getComponent(j+1)).setText(String.valueOf(array[j + 1]));
                        array[j] = aux;
                        ((JButton)panel.getComponent(j)).setText(String.valueOf(aux));
                    try {
                        sleep(100);//Dormir 0.1 segundos 
                    } catch (InterruptedException ex) {
                        }
                }
            }
            panel.getComponent(array.length-1-i).setBackground(Color.red); 
        }
        for (int i = 0; i < array.length ; i++){
            System.out.println(array[i]);
        }
        //Metodo de Seleccion 
        /*int i, j, menor, pos, tmp;
            for (i = 0; i < array.length - 1; i++) {
                menor = array[i];                       
                pos = i;                            
                for (j = i + 1; j < array.length; j++){ 
                    if (array[j] < menor){           
                        menor = array[j];             
                        pos = j;
                        ((JButton)panel.getComponent(j+1)).setText(String.valueOf(array[j]));
                        panel.getComponent(j).setBackground(Color.blue); 
                    }
                }
                if (pos != i){                                           
                    tmp = array[i];
                    array[i] = array[pos];
                    array[pos] = tmp;
                    ((JButton)panel.getComponent(j)).setText(String.valueOf(pos));
                    panel.getComponent(j).setBackground(Color.blue); 
                }
            }*/
    }    
}

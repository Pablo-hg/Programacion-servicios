

package pkg02_productorconsumidor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Monitor {
    
    ArrayList<Integer> productos = new ArrayList();
    int numero;

    public synchronized int getProductos() {
        
        //Mientras productos está vacio esperamos
        while(productos.isEmpty()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        //Guardamos en numero el 1º numero en el array
        this.numero = productos.get(0);
        //eliminamos el numero en la primiera posicion
        productos.remove(0);
        //Devolvemos el numero (que contiene el numero que estaba en la 1º posicion
        
        return numero;
        
    }

    public synchronized void setProductos(int numero) {

        //Mientras productosa tenga mas de 20 productos esperamos
        while(productos.size()>19){
            try {
                wait();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Añadimos a productos el un producto
        productos.add(numero);
        //Guardamos en el numero el nº del producto
        this.numero = numero;
        notifyAll();
    }
}

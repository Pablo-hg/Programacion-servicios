
package pilasincronizada;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Escribe una clase Observador que cada 10 milisegundos emita un mensaje en consola que indique
-	El valor del primer NODO de la PILA
-	El número de elementos de la PILA*/

public class Observador extends Thread{
    
    Pila pila;
    
    public Observador(Pila pila){
        this.pila = pila;
    }
    
    @Override 
    public void run(){
        while(true){//Ejecuatmos que me observe siempre
            int numero = pila.siguienteEnPila();//el numero que hay en raiz
            System.out.println("Primer nodo : " + numero);
            System.out.println("Total elementos pila : " + pila.pilaCount());
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Observador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

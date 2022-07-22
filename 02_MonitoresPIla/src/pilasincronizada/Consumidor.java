

package pilasincronizada;

/*Escribe una clase Consumidor que retire elementos de la PILA
El consumidor emitirá un mensaje en consola con el valor del NODO desapilado.*/

public class Consumidor extends Thread{
    
    Pila pila;
    
    public Consumidor(Pila pila){
        this.pila = pila;
    }
    
    @Override
    public void run(){
        while (true){//mientras pila no esté vacia
            //pila.pop() --> eliminanos el elemento en la cabeza de la pila
            System.out.println("Nodo " + pila.pop() + " consumido");
        }
    }
}

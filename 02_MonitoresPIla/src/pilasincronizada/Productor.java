
package pilasincronizada;

/*Escribe una clase Productor que apile 10 elementos aleatorios en la PILA y 
que en cada iteración vaya incrementando en 10 unidades el valor límite del aleatorio.
El Productor emitirá un mensaje en consola indicando el valor que quiere apilar.*/

public class Productor extends Thread{
    
    Pila pila;
    
    public Productor(Pila pila){
        this.pila = pila;
    }
    
    @Override
    public void run(){
        int i = 0;
        int limite = 10;
        while (i < 10){
            int numero = (int) (Math.random()*limite);
            pila.push(numero);//añadimos el numero aleatorio a la pila
            System.out.println(numero + " añadido a la pila");
            i++;
            limite = limite + 20;
        }
    }
}

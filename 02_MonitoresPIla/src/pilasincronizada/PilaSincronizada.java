
package pilasincronizada;

public class PilaSincronizada extends Thread{

   
    public static void main(String[] args) {
        
        Pila pila = new Pila();
        
        Productor productor1 = new Productor(pila);
        Productor productor2 = new Productor(pila);
        Observador observador = new Observador(pila);
        Consumidor consumidor = new Consumidor(pila);
        
        
        productor1.start();
        productor2.start();
        consumidor.start();
        observador.start();
    }
    
}

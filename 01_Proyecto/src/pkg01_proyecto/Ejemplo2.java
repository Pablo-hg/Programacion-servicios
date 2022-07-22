
package pkg01_proyecto;

import java.util.logging.Level;
import java.util.logging.Logger;

class Ejemplo2 {
    
    static int array1[] = new int[10];
    static int array2[] = new int[10];
    
    public static void main(String args[]) {
        try {
            long tiempoInicial;
            for (int i = 0; i < array1.length; i++) {
                array1[i] = (int) (Math.random() * 10000);
            }
            for (int i = 0; i < array2.length; i++) {
                array2[i] = (int) (Math.random() * 10000);
            }
            tiempoInicial = System.currentTimeMillis();
            Hebra h1 = new Hebra(array1, "A");
            Hebra h2 = new Hebra(array2, "B");
            
            h1.start();//invoca directamente al metodo run(lo arranco)
            h2.start();
            
            //hay que hacer un try cath de join
            h1.join();//el .join hace que dicho metodo muera despues de terminar.
            h2.join();
            
            System.out.println("Tiempo de ejecución: " + (System.currentTimeMillis() - tiempoInicial) + " ms");
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejemplo2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



package pkg02_productorconsumidor;

/*Aplicación que utilice la técnica de MONITORES para sincronizar a varios productores
y consumidores de datos que utilizan una estructura de datos del tipo ArrayList con los siguientes requisitos:
    - Un productor no puede producir si el ArrayList tiene un tamaño de 20 elementos.
    - Un consumidor no puede consumir si no hay elementos en el ArrayList
    - El productor produce un total de 50 y el productor xosnume de 20 en 20.
    - (Se producen 20, se consuemn 20)*2 , se producen 10, se leen 10  */
public class Main {

    public static void main(String[] args) {
        
        Monitor monitor = new Monitor();
        
        Productor productor = new Productor(monitor);
        Consumidor consumidor = new Consumidor(monitor);
        
        productor.start();
        consumidor.start();
    }
    
}

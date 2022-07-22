

package pkg02_productorconsumidor;


public class Productor extends Thread{
    
    Monitor monitor;

    public Productor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run(){
        
        for (int i = 0; i < 50; i++){
            int numero = (int) (Math.random()*20)+1;
            monitor.setProductos(numero);
            System.out.println("Producto " + numero + " añadido");
        }
    }
}

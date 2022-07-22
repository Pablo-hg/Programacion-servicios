
package pkg02_productorconsumidor;



public class Consumidor extends Thread{
    
    Monitor monitor;

    public Consumidor(Monitor monitor) {
        this.monitor = monitor;
    } 
    
    @Override
    public void run(){
        
        for (int i = 0; i < 20;i++){
            System.out.println("Producto " + monitor.getProductos() + " consumido");
        }
        
    }
}

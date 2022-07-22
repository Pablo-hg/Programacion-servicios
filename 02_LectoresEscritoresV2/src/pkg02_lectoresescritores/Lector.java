

package pkg02_lectoresescritores;


public class Lector extends Thread{
    
    Monitor monitor;

    public Lector(Monitor monitor) {
        this.monitor = monitor;
    }
    
    public void run(){
        for (int i = 0; i <= 20; i++) {
            
            System.out.println("Valor leido: " + monitor.getValor());
        }
    }
    
}

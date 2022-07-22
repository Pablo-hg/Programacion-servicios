
package pkg02_lectoresescritores;

public class Escritor extends Thread{
    
    Monitor monitor;

    public Escritor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    public void run(){
        for (int i = 1; i <= 20; i++) {
            monitor.setValor(i);
        }
    }
}

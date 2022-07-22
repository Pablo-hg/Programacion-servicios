
package pkg02_lectoresescritores;

public class Main {

    
    public static void main(String[] args) {
        
        Monitor monitor = new Monitor();
        Escritor escritor = new Escritor(monitor);
        Lector lector = new Lector(monitor);
        
        escritor.start();
        lector.start();
        
    }
    
}

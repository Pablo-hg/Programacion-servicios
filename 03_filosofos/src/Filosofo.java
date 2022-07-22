
import java.awt.Color;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Filosofo extends Thread {

    Semaphore pIzq, pDer;
    JButton boton;

    public Filosofo(Semaphore pIzq, Semaphore pDer, JButton boton) {
        this.pIzq = pIzq;
        this.pDer = pDer;
        this.boton = boton;
    }

    public void run() {

        boton.setBackground(Color.white);

        while (true) {

            try {
                pIzq.acquire();
                pDer.acquire();
                boton.setBackground(Color.red);
                sleep(300);
                boton.setBackground(Color.white);
                pIzq.release();
                pDer.release();
                sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

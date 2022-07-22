package barreraciclica;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ferry {

Semaphore contador= new Semaphore(0);    
    
public void esperar()
{
    if (contador.getQueueLength()==9){
        contador.release(9);
        System.out.println("10 Coches han salido");
    }
    else
    try {
        contador.acquire();
    } catch (InterruptedException ex) {
        Logger.getLogger(Ferry.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
    
}

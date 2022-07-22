package barreraciclica;

import java.util.Date;

public class Coche extends Thread{
    
    Ferry ferry;
    int numeroCoche;
    public Coche(Ferry ferry, int numeroCoche) {
        this.ferry = ferry;
        this.numeroCoche=numeroCoche;
    }
    
    public void run(){
        System.out.println("Coche nº "+numeroCoche+" llega a: "+ new Date());
        ferry.esperar();
        System.out.println(" -------- Coche nº "+numeroCoche+" sale a: "+ new Date());
    }
}

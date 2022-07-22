

package examen_1ºeva_pablohorcajadagonzález;


public class Repartidor extends Thread{
    
    Bandeja bandeja;
    

    public Repartidor(Bandeja bandeja) {
        this.bandeja = bandeja;
    }
    
    @Override
    public void run(){
        while(true){
            bandeja.QuitardeBandeja();
            System.out.println("Un repartidor coge una pizza de la bandeja");
        }
        
    }
}

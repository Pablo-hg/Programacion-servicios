

package examen_1ºeva_pablohorcajadagonzález;


public class Cocinero extends Thread{
    
    Bandeja bandeja;
    

    public Cocinero(Bandeja bandeja) {
        this.bandeja = bandeja;
    }
    
    @Override
    public void run(){
        while(true){
            Examen_1ºEva_PabloHorcajadaGonzález.pizza++;
            bandeja.PonerenBandeja(Examen_1ºEva_PabloHorcajadaGonzález.pizza);
            System.out.println("Un cocinero pone una pizza en la bandeja");
        }
        
    }
    
}

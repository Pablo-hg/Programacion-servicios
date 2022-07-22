
package examen_1ºeva_pablohorcajadagonzález;

public class Examen_1ºEva_PabloHorcajadaGonzález {

    public static int pizza = 0;
    //cocinero hace pizza ( si bandeja llena, espera)
    //pizza terminada --> badeja reparto
    //repartidor espera mientras no haya pizzas  en la bandeja--> retira y se la lleva
    //repartidor vueleve y espera
    //La pizzeria solo admite una pizza
    //La badeja tiene un maximo (aleatorio entre 10 y 15)
    public static void main(String[] args) {
        
        
        
        Bandeja bandeja = new Bandeja();
        //3 cocineros
        for(int i = 1; i <= 3; i++){
            Cocinero cocinero = new Cocinero(bandeja);
            cocinero.start();
        }
        //5 repartidores
        for (int i = 1 ; i <=5;i++){
            Repartidor repartidor = new Repartidor(bandeja);
            repartidor.start();
        } 
    }
    
}

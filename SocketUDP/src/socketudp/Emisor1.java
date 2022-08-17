
package socketudp;

import udp.EnviaUDP;
import udp.RecibeUDP;

public class Emisor1 {
    
static int puertoAlQueEnvia = 5000;
   static int puertoPorElQueRecibe= 6500;
   
    public static void main(String[] args) {
        
        //localhost siginifica que lo envio a la misma tarjeta de red a la que sale
        EnviaUDP.Envia("Hola desde el emisor1", "localhost", puertoAlQueEnvia);
        
        System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
        
        EnviaUDP.Envia("2º mensaje desde el emisor1", "localhost", puertoAlQueEnvia);
        
        System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
        
    }
}


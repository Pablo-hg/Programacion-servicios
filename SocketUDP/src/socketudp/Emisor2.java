
package socketudp;

import udp.EnviaUDP;
import udp.RecibeUDP;

public class Emisor2 {

   static int puertoAlQueEnvia=6500;
   static int puertoPorElQueRecibe= 5000;
   
    public static void main(String[] args) {
        
        System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
        
        EnviaUDP.Envia("Mensaje desde el emisor2", "localhost", puertoAlQueEnvia);
        
        System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
        
        EnviaUDP.Envia("Otro mensaje desde el emisor2", "localhost", puertoAlQueEnvia);
    }
}


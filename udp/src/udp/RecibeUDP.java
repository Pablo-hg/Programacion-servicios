
package udp;

import java.io.IOException;
import java.net.*;

public class RecibeUDP {
    
    public static String recibe(int puerto) {
        DatagramSocket socket; //datagramsocket --> empaquetamos el mensaje(socket) que queremos enviar
        DatagramPacket paquete = null; //inicializmos el datagrama
        byte paraRecibir[] = new byte[1024]; //1024 es la cantidad mazxima para un datagrama
        String IPRemota = "";
        int puertoRemoto;
        try {
            paquete = new DatagramPacket(paraRecibir, paraRecibir.length);//preparamos un paquete vacio
            socket = new DatagramSocket(puerto); //abrimos la tarjeta de red en el puerto especificado
            
            //Con el .recesive , bloqueamos lo que esté haciendo el proceso y hasta que no llegue un paquete al puerto
            //ese proceso se queda paralizado, por lo que se ejecuta en 2º plano
            //para no bloquear todo el sistema
            socket.receive(paquete); 
            
            IPRemota = paquete.getAddress().getHostName();//obtenemos el nombre del equipo que envio el paquete
            puertoRemoto = paquete.getPort();//obtenemos el puerto por el que llega el paquete
            System.out.println("El paquete llega de la IP " + paquete.getSocketAddress().toString());
            System.out.println("El paquete llega de " + IPRemota + " por el puerto " + puertoRemoto);
            socket.close();
        } catch (SocketException ex) {
            System.out.println("Error al asignar el socket");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error en la recepción del paquete");
            ex.printStackTrace();
        }
        //si no se ha producido nigún problema, devolvemos el array de bytes del datagrama,
        //que con el .receive, obtenemos el string
        return new String(paquete.getData()).trim();
    }
}


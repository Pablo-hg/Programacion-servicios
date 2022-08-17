
package udp;

import java.io.IOException;
import java.net.*;

public class EnviaUDP {
    public static void Envia(String texto, String hostdestino, int puerto) {
        DatagramSocket socket; //empaquetamos el mensaje 
        DatagramPacket paquete; //creamos el datagrama
        byte paraEnviar[];
        try {
            paraEnviar = texto.getBytes(); //cojemos el string de bytes y lo convertirmos en un array de bytes
            
            //preparamos el datagrama con el array de bytes +  el nombre del equipo (o ip)
            //dónde lo enviamos + el puerto por el que llega 
            paquete = new DatagramPacket(paraEnviar, paraEnviar.length,InetAddress.getByName(hostdestino), puerto);
            //buscamos un puerto libre de salida
            socket = new DatagramSocket();
            //enviamos el datagrama por ese puerto
            socket.send(paquete);
            //cerramos el datagrama
            socket.close();
        } catch (SocketException ex) {
            System.out.println("Error al asignar el socket");
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            System.out.println("Error al crear el paquete");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error en el envío del paquete");
            ex.printStackTrace();
        }
    }
}


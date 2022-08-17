/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class EnviaObjetos {
    
public static void Envia(Object objeto, String hostdestino, int puerto) {
    
        try {
            DatagramSocket socket;
            DatagramPacket paquete;
            byte bytesEnviar[];

            bytesEnviar = serializar(objeto);
            socket = new DatagramSocket();
            paquete = new DatagramPacket(bytesEnviar, bytesEnviar.length, InetAddress.getByName(hostdestino), puerto);
            socket.send(paquete);
            socket.close();
            
        } catch (SocketException ex) {
            System.out.println("Error al asignar el socket");
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            System.out.println("Error al crear el paquete");
        } catch (IOException ex) {
            System.out.println("Error en el envio del paquete");
        }
    }

    static byte[] serializar(Object objeto) {      
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (
            ObjectOutputStream os = new ObjectOutputStream(bytes)) {
            os.writeObject(objeto);
        } catch (IOException ex) {
            System.out.println("Error al crear el array de bytes");
        }
        return bytes.toByteArray();
    }
}


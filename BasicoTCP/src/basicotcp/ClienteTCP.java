package basicotcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClienteTCP {
    
    private DataOutputStream flujoDeSalida;
    private DataInputStream flujoDeEntrada;
    private Socket socketCliente;

    public ClienteTCP ( String Host, int Puerto){
        try {
            socketCliente = new Socket (Host, Puerto);
            //Con el método writeBytes estamos escribiendo un texto en un objeto del tipo
            //DataOutputStream, que a su vez se sustenta en un objeto del tipo OutputStream, 
            //que se encuentra asociado a un SOCKET
             
            flujoDeSalida= new DataOutputStream(socketCliente.getOutputStream());
            flujoDeSalida.writeUTF("Hola soy el cliente");
            
            String texto;
            
            do{
                flujoDeEntrada= new DataInputStream(socketCliente.getInputStream());
                texto=flujoDeEntrada.readUTF();
                System.out.println("Recibido del servidor: "+ texto);
            } while (!"Fin".equals(texto));
             
            flujoDeSalida.writeUTF("Corto");
            flujoDeEntrada.close();
            flujoDeSalida.close();
            socketCliente.close();
        } catch (UnknownHostException ex) {
            System.out.println("Error host desconocido");
        } catch (IOException ex) {
             System.out.println("Error de conexión");
        }
    }
    
    public static void main(String[] args) {
        
        new ClienteTCP("localhost", 5000);
    }
}



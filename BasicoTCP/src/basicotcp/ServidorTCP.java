
package basicotcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Para el protocolo TCP , necesitams que un programa se ejecute en modm servidor
public class ServidorTCP {
    
    private DataInputStream flujoDeEntrada;
    private DataOutputStream flujoDeSalida;
    private String cadenaRecibe=null;
    
    public ServidorTCP (int Puerto){
            
        try {        
             
            //Declaramos el serverSocket para indicar que es el servidor
            // y lo inizialiamos en un puerto
            ServerSocket socketServidor = new ServerSocket (Puerto);
            
            System.out.println("Servidor conectado esperando clientes...");
            
            //Una vez que está inizialiado en un puerto,( a taravés de ese puesto)
            //se queda en el modo de recepcion de clientes (creando un socket y usando el .accept().
            //SE QUEDA EN MODO ESPERA
            //AL crear el socketcliente , se crea un buffer de comunicacion entre ambos
            Socket socketCliente = socketServidor.accept();
            
            //Creamos los flijos de entrada y salida
            flujoDeEntrada = new DataInputStream(socketCliente.getInputStream());
            flujoDeSalida= new DataOutputStream(socketCliente.getOutputStream());
            
            System.out.println("Comunicación establecida");
            
            //guardamos en una variable, la info que entra por el Input
            cadenaRecibe= flujoDeEntrada.readUTF();
            System.out.println("Recibido del cliente: "+cadenaRecibe);
            
            flujoDeSalida.writeUTF("Saludo1 desde el servidor");
            flujoDeSalida.writeUTF("Saludo2 desde el servidor");
            flujoDeSalida.writeUTF("Saludo3 desde el servidor");
            flujoDeSalida.writeUTF("Fin");
            
            
            cadenaRecibe= flujoDeEntrada.readUTF();
            System.out.println("Recibido del cliente: "+cadenaRecibe);
            
            //Cerramos los flujos
            socketCliente.close();
            flujoDeSalida.close();
            flujoDeEntrada.close();
            socketServidor.close();
            
        } catch (IOException  ex) {
            System.out.println("Error de conexión");
        }
    }
    
    public static void main(String[] args) {
        
        new ServidorTCP(5000);
    }
}

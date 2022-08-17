
package Cliente;

import Servidor.EstructuraArchivosIO;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import Cliente.RecibeObjetos;
import Servidor.EnviaObjetos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ClienteHilo extends Thread{
    
    EstructuraArchivosIO estructuraArchivos;
    JTree tree;
    int PuertoCliente;
    int PuertoServidor = 12346;     
    DescargarArchivo descargar;
    byte[] bufferArchivo;

    public ClienteHilo(EstructuraArchivosIO estructuraArchivos,int PuertoCliente, JTree tree) {
        this.estructuraArchivos = estructuraArchivos;
        this.tree = tree;
        this.PuertoCliente = PuertoCliente;
    }

    
    public void run() {
        String saludo = "hola";
        //Enviamos algo al servidor
        EnviaObjetos.Envia(saludo,"localhost", PuertoServidor);
        while(true){
            estructuraArchivos = (EstructuraArchivosIO) RecibeObjetos.recibe(PuertoCliente);
            tree.removeAll();
            tree.setModel(estructuraArchivos.getModel());
        }
    }
}

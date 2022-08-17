
package Servidor;

import Cliente.RecibeObjetos;
import Cliente.SubirArchivo;
import Cliente.DescargarArchivo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.shape.Path;
import javax.swing.JOptionPane;

public class ServidorHilo extends Thread{
    
    int PuertoServidor;
    int PuertoCliente;
    EstructuraArchivosIO estructuraArchivos;
    SubirArchivo subir;
    DescargarArchivo descargar;
    byte[] bufferArchivo;
    Object objeto;

    public ServidorHilo(int PuertoServidor, int PuertoCliente, EstructuraArchivosIO estructuraArchivos) {
        this.PuertoServidor = PuertoServidor;
        this.PuertoCliente = PuertoCliente;
        this.estructuraArchivos = estructuraArchivos;
    }

    
    public void run(){
        
        while (true){
            objeto = RecibeObjetos.recibe(PuertoServidor);
            //Si recibimos un hola, enviamos la estructura
            if(objeto.toString().equals("hola")){
            EnviaObjetos.Envia(estructuraArchivos, "localhost", PuertoCliente);
            }
            //Guardamos en "subir" el objeto de la clase SubirArchivo que hemos recibido
            //Si lo que me ha recibido es un objeto de la clase SubirArchivos
            if(objeto instanceof SubirArchivo){
                subir = (SubirArchivo) objeto;
                //Escribimos/creamos el archivo teniendo ya todos los datos deseados(getters..)
                try {
                    Files.write(Paths.get(subir.getRuta(), subir.getNombre()), subir.getBufferArchivo());
                    JOptionPane.showMessageDialog(null, "Archivo/s subido/s");
                } catch (IOException ex) {
                    System.out.println("Error al crear un archivo basado en buffer");
                }
                //Volvemos a enviar la estructura del archivos para que el 
                //cliente pueda ver el archivo que acaba de subir
                EnviaObjetos.Envia(estructuraArchivos, "localhost", PuertoCliente);
            }
        }
    }
}

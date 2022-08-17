
package Servidor;

import java.io.File;
import javax.swing.*;
import Servidor.EstructuraArchivosIO;
import java.io.Serializable;
import Servidor.EnviaObjetos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Cliente.RecibeObjetos;
import Servidor.EnviaObjetos;

public class ServidorMain implements Serializable{
    
    public static void main(String args[]) {
        
        int PuertoServidor = 12346;
        int PuertoCliente = 12356;
        
        //CHOOSER
        JFileChooser jfc = new JFileChooser();
        EstructuraArchivosIO estructuraArchivos;
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setCurrentDirectory(new File("c:\\"));
        jfc.setDialogTitle("Selecciona el directorio que vas a compartir");
        //Si le damos a cancelar, mostramos que no ha arracancado
        if ((jfc.showDialog(jfc, "Seleccionar") == JFileChooser.CANCEL_OPTION)) {
            JOptionPane.showMessageDialog(null, "El servidor de archivos no ha arrancado");
        } else {
            //Si hemos seleccionado algo, creamos un "File" con al carpeta seleccionada.
            File archivo = jfc.getSelectedFile();
            //Guardamos la ruta absoluta de "File" seleccionado.
            String rutaInicial = archivo.getAbsolutePath();
            //Construimos la estructura pasandole la ruta del archivo
            estructuraArchivos = new EstructuraArchivosIO(rutaInicial);
            //SERIALIZAMOS LA ESTRUCTURA
            EnviaObjetos.serializar(estructuraArchivos);
            //estructuraArchivos.getModel();
            JOptionPane.showMessageDialog(null,"El servidor de archivos ha arrancado" );
            //Constructor del la clade del hilo ,pasandole los atributos
            ServidorHilo hilo = new ServidorHilo(PuertoServidor,PuertoCliente,estructuraArchivos);
            //ejecutamso el hilo
            hilo.start();
        }
    }  
}

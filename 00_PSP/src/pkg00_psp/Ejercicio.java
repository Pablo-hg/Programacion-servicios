
package pkg00_psp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio {
    
    /*Ejercicio:
    Escribe un programa en Java que muestre en pantalla todo el contenido de la última carpeta que encuentre en el disco C:/
        Formato de comandos necesarios:
            "cmd /c dir c:\\*. /b "
                // “/b” lista en formato simple
            "cmd /c dir c:\\"+carpeta+"\\ "*/
    
    public static int existePrograma(String programa) throws Exception {
        
        Process p = Runtime.getRuntime().exec("cmd /c dir c:\\*. /b");
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        
        //ejecutar el proceso;guardar las lineas en una lista;guardar la ultima linea en una variable;hacer un dir de esa variable
        
        String contenido;
        while ((contenido = br.readLine()) != null) {
            if (contenido.contains(programa)) {
                return 5;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        
        
        Process p;
        
    }
    

}

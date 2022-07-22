
package pkg00_psp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Ejemplo3 {

    public static int existePrograma(String programa) throws Exception {
        Process p = Runtime.getRuntime().exec("cmd /c dir c:\\*. /b");
        //  "/c" ejecuta cmd y termina,  "/nh" elimina las cabeceras
               
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        /*Explicación:
        InputStream is = p.getInputStream(); //Captura sólo bytes
        InputStreamReader isr = new InputStreamReader(is); // Se pasan los bytes convertidos a char
        BufferedReader br = new BufferedReader(isr);//Los char convertidos a cadenas
        //Realizamos toda esta conversión para poder leer el listado cómodamente con readline();
        */
        
        String tareaR;
        while ((tareaR = br.readLine()) != null) {
            System.out.println(tareaR);
            if (tareaR.contains(programa)) {
                return 5;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        Process p;
        
        int Pid = existePrograma("notepad.exe");

        if (Pid == 5) {
            p = Runtime.getRuntime().exec("cmd /c  taskkill /im  notepad.exe");
            //   “/im” cierra forzosamente procesos .exe
            JOptionPane.showMessageDialog(null, "notepad.exe eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "notepad.exe no se estaba ejecutando");
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg00_psp;

import java.io.IOException;

/**
 *
 * @author pablo
 */
public class Ejemplo1 {
    
        public static void main(String[] args) throws IOException, InterruptedException {

        Runtime entorno = Runtime.getRuntime();//Runtine es una interfaz

        Process proceso1, proceso2 = null;// es un objeto tipo proceso
        proceso1 = entorno.exec("C:\\Windows\\notepad.exe");
        proceso2 = entorno.exec("cmd /c  start"); //es necesario poner el start para que una vez abierto el programa se mentega abierto
        //Desde la ventana de DOS arrancamos otra DOS
        
        //Si no ponemos las líneas sig., main acaba y los procesos quedan arrancados
        
        //Con esta línea, main no finaliza hasta que se cierre notepad.exe
        proceso1.waitFor(); //
        System.out.println(proceso1.exitValue());
    }
}

    


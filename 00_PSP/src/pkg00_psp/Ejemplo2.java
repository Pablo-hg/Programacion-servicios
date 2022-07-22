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
public class Ejemplo2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        ProcessBuilder pb = new ProcessBuilder("c:\\windows\\notepad.exe");
        Process proceso = null;
        proceso = pb.start();

        retorno = proceso.waitFor();
        System.out.println("Aquí se llega cuando la ejecución del proceso finaliza");
        System.out.println("La ejecución devuelve: " + retorno);
    }
    static int retorno = -2; //Si no hay errores, el programa retornará un 0
}


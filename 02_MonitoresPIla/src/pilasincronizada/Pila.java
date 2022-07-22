
package pilasincronizada;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Pila {
    Nodo raiz;

    public Pila() {
        //creamos la variable raiz que apunta a la nada
        raiz = null;
    }
    //Método que apila 
    synchronized void push(int valor){
        if(raiz!=null){//si raiz es igual a null
            while(valor<this.siguienteEnPila()){//mientras valor sea <= a raiz bloqueamos
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //creamos un nodo
        Nodo nodo = new Nodo();
        nodo.info = valor;//guardamos el valor pasado como parametro
        nodo.sig = raiz;//guardamos dicho numero en raiz
        raiz = nodo;//raiz es igual al 1º elemento
        notifyAll();
    }
    
    //Método que extrae el elemento de la cabeza de la pila
    synchronized int pop(){
        while (this.pilaVacia()==true){//mientras pilaVacia sea true bloquamos
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int valor = raiz.info;//guardamos en una varible el valor de raiz   
        raiz=raiz.sig;//guardamos en raiz el siguiente valor en memoria
        notifyAll();
        return valor; //devolvemos el valor del 1º nodo de la estructura
    }
   
    //Método que imprime el valor de cada nodo 
    synchronized void recorrido(){
        Nodo reco = raiz;//creamos un nodo que valga la 1º posicion(raiz)
        while(reco!=null){//mientras nodo no valga null
            System.out.print("\t"+raiz.info);//imprimimos el valor de reco
            reco=reco.sig;//guardamos en reco el siguiente valor 
        }
    }
    
    //Método que devuelve true si la PILA está vacía y false en el caso contrario
    synchronized boolean pilaVacia(){
        if (raiz == null){
            return true;
        } else
            return false;
    }
    
    //Método que devuelve el numero de nodos que tiene la pila
    synchronized int pilaCount(){
        while (this.pilaVacia()==true){//mientras pila esté vacia bloqeuamos
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Nodo contar = raiz;
        int total = 0;
        while(contar!=null){
            total++;
            contar = contar.sig;
        }
        return total;
    }
    
    //Método que devuelva el valor del primer nodo de la pila sin quitarlo
    synchronized int siguienteEnPila(){
        if(raiz == null){
            return Integer.MAX_VALUE;
        }
        else{
            return raiz.info;
        }
        
    }
}

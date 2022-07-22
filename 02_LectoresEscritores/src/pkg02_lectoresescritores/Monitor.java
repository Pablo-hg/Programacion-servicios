
package pkg02_lectoresescritores;


public class Monitor {
    
    int valor;
    boolean disponible = false;                                    

    //Hacer métodos "syncronized" hace que el resto "sybcronized" se paren hasta que el 1º acabe
    public synchronized int getValor() {
        
        if (disponible){
            disponible =  false;
            return valor;
        }
        return 0;
    }

    public synchronized void setValor(int valor) {
        
        if (!disponible){
            this.valor = valor;
            disponible = true;
        }
    }
    
}

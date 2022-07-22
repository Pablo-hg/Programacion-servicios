
package pkg01_proyecto;

class Hebra extends Thread {
    int array[];
    String letra;
    
    //Constructor
    Hebra(int array[], String letra) {
        this.array = array;
        this.letra = letra;
    }
    
    public  void burbuja(int[] array) {
        int i, j, aux;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }
        }
        for (int valor : array) {
            System.out.print(valor + "-" + letra + "\t");
        }
        System.out.println("");
        System.out.println("");
    }
    
    //todas las operaciones que se hagan en el metodo run, se haran en paralelo
    public void run() {
        burbuja(array);
    }
}


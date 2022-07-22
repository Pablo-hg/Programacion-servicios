
package pkg01_proyecto;

//Ordenar 2 arrays de menor a mayor de 10000 aleatorios
public class Ejemplo1 {
    public static void burbuja(int[] array) {
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
            System.out.print(valor + "\t");
        }
        System.out.println("");
        System.out.println("");
    }

    public static void main(String args[]) {

        int array1[] = new int[10000];
        int array2[] = new int[10000];
        long tiempoInicial;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 10000);
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) (Math.random() * 10000);
        }

        tiempoInicial = System.currentTimeMillis();
        burbuja(array1);
        burbuja(array2);
        System.out.println("Tiempo de ejecución: " + (System.currentTimeMillis() - tiempoInicial) + " ms");
    }
}

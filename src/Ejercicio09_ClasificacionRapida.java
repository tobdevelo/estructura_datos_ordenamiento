import java.util.Arrays;
import java.util.Random;

public class Ejercicio09_ClasificacionRapida {

    // Contador de llamadas recursivas exigido por la guía
    static int llamadasRecursivas = 0;

    // Método público para iniciar Quick Sort
    public static void quickSort(int[] arr) {
        llamadasRecursivas = 0;
        if (arr == null || arr.length < 2) return;
        quickSortRecursivo(arr, 0, arr.length - 1);
    }

    // Implementación recursiva mostrando pivotes y particiones
    private static void quickSortRecursivo(int[] arr, int inicio, int fin) {
        llamadasRecursivas++;

        int i = inicio;
        int j = fin;
        // Seleccionamos el elemento central como pivote
        int pivote = arr[(inicio + fin) / 2];

        System.out.println("-> Subarreglo [" + inicio + " a " + fin + "] | Pivote seleccionado: " + pivote);

        // Partición de elementos alrededor del pivote
        while (i <= j) {
            while (arr[i] < pivote) i++;
            while (arr[j] > pivote) j--;

            if (i <= j) {
                // Intercambio
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // Mostrar estado tras la partición actual
        System.out.println("   Particion resultante: " + Arrays.toString(Arrays.copyOfRange(arr, inicio, fin + 1)));

        // Llamadas recursivas para los subarreglos izquierdo y derecho
        if (inicio < j) {
            quickSortRecursivo(arr, inicio, j);
        }
        if (i < fin) {
            quickSortRecursivo(arr, i, fin);
        }
    }

    // Función auxiliar para comprobar si quedó ordenado correctamente de menor a mayor
    public static boolean verificarOrden(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            if (arr[k - 1] > arr[k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Generar 10 números enteros aleatorios entre 1 y 100
        Random rd = new Random();
        int[] datos = new int[10];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = rd.nextInt(100) + 1;
        }

        System.out.println("=== ARREGLO ORIGINAL ===");
        System.out.println(Arrays.toString(datos) + "\n");

        System.out.println("=== TRAZA DE PIVOTES Y PARTICIONES ===");
        quickSort(datos);

        System.out.println("\n=== ARREGLO ORDENADO (ASCENDENTE) ===");
        System.out.println(Arrays.toString(datos));

        System.out.println("\nTotal de llamadas recursivas realizadas: " + llamadasRecursivas);
        System.out.println("¿Esta correctamente ordenado?: " + verificarOrden(datos));
    }
}
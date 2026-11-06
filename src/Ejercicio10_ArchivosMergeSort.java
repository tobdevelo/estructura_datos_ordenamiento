import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio10_ArchivosMergeSort {

    // Método principal de Merge Sort
    public static void mergeSort(int[] a) {
        if (a == null || a.length < 2) return;
        int[] buffer = new int[a.length];
        mergeSortRecursivo(a, buffer, 0, a.length);
    }

    // División recursiva paso a paso
    private static void mergeSortRecursivo(int[] a, int[] buffer, int inicio, int fin) {
        if (fin - inicio < 2) return; // Caso base: subarreglo de 1 elemento

        int medio = (inicio + fin) / 2;

        System.out.println("-> Dividiendo rango [" + inicio + " a " + (fin - 1) + "]: "
                + "mitad izquierda [" + inicio + ".." + (medio - 1) + "] y mitad derecha [" + medio + ".." + (fin - 1) + "]");

        mergeSortRecursivo(a, buffer, inicio, medio);
        mergeSortRecursivo(a, buffer, medio, fin);

        // Operación de mezcla
        mezclar(a, buffer, inicio, medio, fin);
    }

    // Fusión de dos subarreglos ordenados en el buffer y copia al original
    private static void mezclar(int[] a, int[] buffer, int inicio, int medio, int fin) {
        int i = inicio;
        int j = medio;
        int k = inicio;

        while (i < medio && j < fin) {
            if (a[i] <= a[j]) {
                buffer[k++] = a[i++];
            } else {
                buffer[k++] = a[j++];
            }
        }

        while (i < medio) buffer[k++] = a[i++];
        while (j < fin) buffer[k++] = a[j++];

        // Copiar los elementos mezclados de vuelta al arreglo original
        System.arraycopy(buffer, inicio, a, inicio, fin - inicio);

        System.out.println("   Mezcla completada [" + inicio + " a " + (fin - 1) + "]: "
                + Arrays.toString(Arrays.copyOfRange(a, inicio, fin)));
    }

    // Utilidad: crear archivo de entrada si no existe
    public static void crearArchivoEntrada(String ruta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            writer.println("45");
            writer.println("12");
            writer.println("89");
            writer.println("34");
            writer.println("23");
            writer.println("9");
            writer.println("77");
            writer.println("60");
        } catch (IOException e) {
            System.err.println("Error creando archivo de prueba: " + e.getMessage());
        }
    }

    // Utilidad: leer enteros desde un archivo de texto
    public static int[] leerDesdeArchivo(String ruta) {
        List<Integer> lista = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(ruta))) {
            while (sc.hasNextInt()) {
                lista.add(sc.nextInt());
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
        int[] datos = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i);
        }
        return datos;
    }

    // Utilidad: escribir el arreglo ordenado en el archivo de salida
    public static void guardarEnArchivo(String ruta, int[] datos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            for (int valor : datos) {
                writer.println(valor);
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String archivoEntrada = "numeros_entrada.txt";
        String archivoSalida = "numeros_ordenados.txt";

        // 1. Preparar archivo de prueba
        crearArchivoEntrada(archivoEntrada);

        // 2. Leer números desde el archivo
        int[] datos = leerDesdeArchivo(archivoEntrada);
        System.out.println("=== NUMEROS LEIDOS DEL ARCHIVO ===");
        System.out.println(Arrays.toString(datos) + "\n");

        // 3. Proceso de Merge Sort con división y mezcla visibles
        System.out.println("=== PROCESO DE DIVISION Y MEZCLA ===");
        mergeSort(datos);

        // 4. Guardar resultados en el segundo archivo
        guardarEnArchivo(archivoSalida, datos);
        System.out.println("\n=== RESULTADO FINAL GUARDADO EN " + archivoSalida + " ===");
        System.out.println(Arrays.toString(datos));

        // Justificación teórica exigida por la guía
        System.out.println("\n--- JUSTIFICACION: MEMORIA AUXILIAR ---");
        System.out.println("Merge Sort requiere un arreglo auxiliar (buffer) de tamaño O(n) porque al mezclar");
        System.out.println("dos mitades ordenadas, sobrescribir directamente el arreglo original sin espacio");
        System.out.println("temporal causaría la pérdida irreversible de elementos pendientes de comparar.");
    }
}
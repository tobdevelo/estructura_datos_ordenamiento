import java.util.Arrays;
import java.util.Random;

public class Ejercicio12_FrecuenciaDados {

    // Counting Sort adaptado al rango fijo del dado (1 al 6)
    public static void countingSortDados(int[] lanzamientos) {
        if (lanzamientos == null || lanzamientos.length == 0) return;

        // Arreglo de conteo de tamaño 7 (para usar los índices del 1 al 6 directamente)
        int[] frecuencias = new int[7];

        // 1. Contar cuántas veces cayó cada cara
        for (int cara : lanzamientos) {
            frecuencias[cara]++;
        }

        // 2. Mostrar la frecuencia de cada cara y determinar la más frecuente
        System.out.println("--- FRECUENCIA POR CARA ---");
        int caraMasFrecuente = 1;
        int maxApariciones = frecuencias[1];

        for (int cara = 1; cara <= 6; cara++) {
            System.out.println("Cara " + cara + ": " + frecuencias[cara] + " veces");
            if (frecuencias[cara] > maxApariciones) {
                maxApariciones = frecuencias[cara];
                caraMasFrecuente = cara;
            }
        }

        System.out.println("\nResultado mas frecuente: Cara " + caraMasFrecuente + " (" + maxApariciones + " lanzamientos)");

        // 3. Reconstruir el arreglo original en orden ascendente
        int idx = 0;
        for (int cara = 1; cara <= 6; cara++) {
            int cantidad = frecuencias[cara];
            while (cantidad > 0) {
                lanzamientos[idx++] = cara;
                cantidad--;
            }
        }
    }

    public static void main(String[] args) {
        // Cantidad de lanzamientos configurable
        int cantidadLanzamientos = 20;
        int[] lanzamientos = new int[cantidadLanzamientos];
        Random rand = new Random();

        // Generar lanzamientos aleatorios entre 1 y 6
        for (int i = 0; i < cantidadLanzamientos; i++) {
            lanzamientos[i] = rand.nextInt(6) + 1;
        }

        System.out.println("=== LANZAMIENTOS ORIGINALES ===");
        System.out.println(Arrays.toString(lanzamientos) + "\n");

        countingSortDados(lanzamientos);

        System.out.println("\n=== LANZAMIENTOS ORDENADOS (ASCENDENTE) ===");
        System.out.println(Arrays.toString(lanzamientos));

        // Justificación analítica requerida por la guía
        System.out.println("\n--- ANALISIS DE EFICIENCIA ---");
        System.out.println("Counting Sort es optimo aqui porque el rango de valores (k = 6) es constante,");
        System.out.println("minusculo y conocido a priori. Opera en tiempo puramente lineal O(n + k), sin realizar");
        System.out.println("comparaciones entre elementos y consumiendo una cantidad infima de memoria auxiliar.");
    }
}
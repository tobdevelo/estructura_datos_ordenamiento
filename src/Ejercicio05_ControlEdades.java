import java.util.Arrays;

public class Ejercicio05_ControlEdades {

    public static void countingSortEdades(int[] edades) {
        if (edades == null || edades.length == 0) return;

        // 1. Determinar el valor maximo del arreglo
        int max = edades[0];
        for (int edad : edades) {
            if (edad > max) {
                max = edad;
            }
        }
        System.out.println("Edad maxima encontrada: " + max);

        // 2. Crear el arreglo de frecuencias (tamano max + 1 para incluir el indice max)
        int[] frecuencias = new int[max + 1];

        // Contar cuantas veces se repite cada edad
        for (int edad : edades) {
            frecuencias[edad]++;
        }

        // 3. Mostrar las frecuencias encontradas (unicamente las que se repiten al menos 1 vez)
        System.out.println("\n--- Conteo de frecuencias por edad ---");
        for (int i = 0; i <= max; i++) {
            if (frecuencias[i] > 0) {
                System.out.println("Edad " + i + ": " + frecuencias[i] + " persona(s)");
            }
        }

        // 4. Reconstruir el arreglo ordenado a partir de las frecuencias
        int indice = 0;
        for (int edad = 0; edad <= max; edad++) {
            int cantidad = frecuencias[edad];
            while (cantidad > 0) {
                edades[indice] = edad;
                indice++;
                cantidad--;
            }
        }
    }

    public static void main(String[] args) {
        // Arreglo de edades con varios valores repetidos
        int[] edades = {18, 25, 14, 18, 30, 22, 14, 18, 45, 22, 19, 30};

        System.out.println("=== EDADES ORIGINALES ===");
        System.out.println(Arrays.toString(edades));

        // Ordenamiento con Counting Sort
        countingSortEdades(edades);

        System.out.println("\n=== EDADES ORDENADAS (ASCENDENTE) ===");
        System.out.println(Arrays.toString(edades));

        // Justificacion teorica solicitada por la guia
        System.out.println("\n--- JUSTIFICACION ---");
        System.out.println("Counting Sort es optimo aqui porque las edades humanas pertenecen a un rango");
        System.out.println("entero positivo pequeno y conocido (tipicamente 0 a 100), logrando un ordenamiento");
        System.out.println("lineal de complejidad O(n + k) sin necesidad de realizar comparaciones directas.");
    }
}
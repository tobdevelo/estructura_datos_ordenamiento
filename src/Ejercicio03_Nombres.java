import java.util.Arrays;

public class Ejercicio03_Nombres {

    // 1. Insertion Sort A - Z (Ascendente) ignorando mayúsculas y minúsculas
    public static void insertionSortAZ(String[] nombres) {
        System.out.println("\n--- Proceso de inserción paso a paso (A-Z) ---");
        for (int i = 1; i < nombres.length; i++) {
            String clave = nombres[i];
            int j = i - 1;

            // Desplazar a la derecha si el elemento anterior es mayor alfabéticamente
            while (j >= 0 && nombres[j].compareToIgnoreCase(clave) > 0) {
                nombres[j + 1] = nombres[j];
                j--;
            }
            // Insertar la clave en la posición correcta encontrada
            nombres[j + 1] = clave;

            // Mostrar el estado del arreglo tras cada inserción
            System.out.println("Paso " + i + " (insertando '" + clave + "'): " + Arrays.toString(nombres));
        }
    }

    // 2. Insertion Sort Z - A (Descendente)
    public static void insertionSortZA(String[] nombres) {
        for (int i = 1; i < nombres.length; i++) {
            String clave = nombres[i];
            int j = i - 1;

            // Invertimos la condición: desplazar si el anterior es menor
            while (j >= 0 && nombres[j].compareToIgnoreCase(clave) < 0) {
                nombres[j + 1] = nombres[j];
                j--;
            }
            nombres[j + 1] = clave;
        }
    }

    public static void main(String[] args) {
        // Datos de prueba combinando mayúsculas y minúsculas
        String[] lista = {"carlos", "Ana", "beatriz", "David", "andres", "Beto"};

        System.out.println("=== ARREGLO ORIGINAL ===");
        System.out.println(Arrays.toString(lista));

        // Ordenar A - Z
        String[] ordenAZ = lista.clone();
        insertionSortAZ(ordenAZ);
        System.out.println("\nResultado final A-Z: " + Arrays.toString(ordenAZ));

        // Ordenar Z - A
        String[] ordenZA = lista.clone();
        insertionSortZA(ordenZA);
        System.out.println("\nResultado final Z-A: " + Arrays.toString(ordenZA));

        // Explicación teórica solicitada por la guía
        System.out.println("\n--- COMPORTAMIENTO CON ARREGLOS CASI ORDENADOS ---");
        System.out.println("Insertion Sort tiene un caso óptimo de O(n) cuando los datos están casi ordenados,");
        System.out.println("ya que la condición del ciclo while se evalúa falsa de inmediato en la mayoría de pasos,");
        System.out.println("evitando desplazamientos innecesarios y convirtiéndolo en un algoritmo muy veloz en ese escenario.");
    }
}
import java.util.Arrays;

public class Ejercicio04_TiemposDeportivos {

    // 1. Bubble Sort Ascendente con métricas
    public static void bubbleSort(double[] a) {
        int comparaciones = 0;
        int intercambios = 0;
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                if (a[j] > a[j + 1]) {
                    double tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    intercambios++;
                }
            }
        }

        System.out.println("Bubble Sort    -> Resultado: " + Arrays.toString(a));
        System.out.println("                 Comparaciones: " + comparaciones + " | Intercambios: " + intercambios);
    }

    // 2. Selection Sort Ascendente con métricas
    public static void selectionSort(double[] a) {
        int comparaciones = 0;
        int intercambios = 0;
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                double tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                intercambios++;
            }
        }

        System.out.println("Selection Sort -> Resultado: " + Arrays.toString(a));
        System.out.println("                 Comparaciones: " + comparaciones + " | Intercambios: " + intercambios);
    }

    public static void main(String[] args) {
        // Tiempos en segundos registrados por los atletas
        double[] tiempos = {12.45, 10.12, 15.30, 11.05, 10.90, 14.20, 10.50};

        System.out.println("=== TIEMPOS ORIGINALES ===");
        System.out.println(Arrays.toString(tiempos) + "\n");

        // Evaluamos ambos algoritmos sobre copias exactas
        double[] copiaBubble = tiempos.clone();
        double[] copiaSelection = tiempos.clone();

        bubbleSort(copiaBubble);
        selectionSort(copiaSelection);

        // Conclusión técnica requerida por la guía
        System.out.println("\n--- CONCLUSION ---");
        System.out.println("Selection Sort realiza significativamente menos intercambios (maximo n-1 movimientos)");
        System.out.println("en comparacion con Bubble Sort, que intercambia elementos adyacentes de forma repetitiva.");
    }
}

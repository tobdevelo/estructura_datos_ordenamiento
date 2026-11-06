import java.util.Arrays;
import java.util.Random;

public class Ejercicio01_Ranking {

    // Contadores para cumplir con el análisis del ejercicio
    static int comparaciones = 0;
    static int intercambios = 0;

    // 1. Bubble Sort de menor a mayor (ascendente)
    public static void bubbleSortAsc(double[] a) {
        comparaciones = 0;
        intercambios = 0;
        int n = a.length;
        boolean huboCambio;

        for (int i = 0; i < n - 1; i++) {
            huboCambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                if (a[j] > a[j + 1]) {
                    // Intercambio de posiciones
                    double temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    intercambios++;
                    huboCambio = true;
                }
            }
            // Si en una pasada no hubo cambios, el arreglo ya está ordenado
            if (!huboCambio) break;
        }
    }

    // 2. Bubble Sort de mayor a menor (descendente)
    public static void bubbleSortDesc(double[] a) {
        comparaciones = 0;
        intercambios = 0;
        int n = a.length;
        boolean huboCambio;

        for (int i = 0; i < n - 1; i++) {
            huboCambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                // Cambiamos el signo '>' por '<' para que los mayores queden primero
                if (a[j] < a[j + 1]) {
                    double temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    intercambios++;
                    huboCambio = true;
                }
            }
            if (!huboCambio) break;
        }
    }

    // Muestra las cinco notas más altas del arreglo ya ordenado de mayor a menor
    public static void mostrarTop5(double[] notasOrdenadasDesc) {
        System.out.print("Top 5 mejores calificaciones: ");
        int limite = Math.min(5, notasOrdenadasDesc.length);
        for (int i = 0; i < limite; i++) {
            System.out.print(notasOrdenadasDesc[i] + (i < limite - 1 ? " | " : "\n"));
        }
    }

    public static void main(String[] args) {
        // CASO A: Arreglo aleatorio (10 notas entre 0.0 y 5.0)
        Random rd = new Random();
        double[] notasAleatorias = new double[10];
        for (int i = 0; i < notasAleatorias.length; i++) {
            notasAleatorias[i] = Math.round((rd.nextDouble() * 5.0) * 10.0) / 10.0;
        }

        System.out.println("=== PRUEBA 1: ARREGLO ALEATORIO ===");
        System.out.println("Original   : " + Arrays.toString(notasAleatorias));

        // Orden ascendente
        double[] copiaAsc = notasAleatorias.clone();
        bubbleSortAsc(copiaAsc);
        System.out.println("Ascendente : " + Arrays.toString(copiaAsc));
        System.out.println("Comparaciones: " + comparaciones + " | Intercambios: " + intercambios);

        // Orden descendente y top 5
        double[] copiaDesc = notasAleatorias.clone();
        bubbleSortDesc(copiaDesc);
        System.out.println("Descendente: " + Arrays.toString(copiaDesc));
        System.out.println("Comparaciones: " + comparaciones + " | Intercambios: " + intercambios);
        mostrarTop5(copiaDesc);

        // CASO B: Arreglo casi ordenado
        double[] casiOrdenado = {2.0, 2.5, 3.0, 3.8, 3.5, 4.2, 4.8, 5.0};
        System.out.println("\n=== PRUEBA 2: ARREGLO CASI ORDENADO ===");
        System.out.println("Original   : " + Arrays.toString(casiOrdenado));
        bubbleSortAsc(casiOrdenado);
        System.out.println("Ordenado   : " + Arrays.toString(casiOrdenado));
        System.out.println("Comparaciones: " + comparaciones + " | Intercambios: " + intercambios);
    }
}

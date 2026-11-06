import java.util.Arrays;

public class Ejercicio08_HistorialTemperaturas {

    // 1. Selection Sort Ascendente (menor a mayor)
    public static int selectionSortAsc(double[] arr) {
        int comparaciones = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                double temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
        return comparaciones;
    }

    // 2. Selection Sort Descendente (mayor a menor)
    public static int selectionSortDesc(double[] arr) {
        int comparaciones = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                double temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
        return comparaciones;
    }

    // Mostrar las 5 temperaturas más bajas (primeras del arreglo ascendente)
    public static void mostrarTop5Minimas(double[] asc) {
        System.out.print("5 temperaturas menores: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(asc[i] + (i < 4 ? "°C, " : "°C\n"));
        }
    }

    // Mostrar las 5 temperaturas más altas (primeras del arreglo descendente)
    public static void mostrarTop5Maximas(double[] desc) {
        System.out.print("5 temperaturas mayores: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(desc[i] + (i < 4 ? "°C, " : "°C\n"));
        }
    }

    public static void main(String[] args) {
        // Registro de 30 días de temperatura en Cartagena (°C)
        double[] tempsMes = {
                31.2, 32.5, 30.0, 29.8, 33.1, 32.0, 31.5, 30.8, 32.9, 34.0,
                29.5, 30.2, 31.8, 32.1, 33.5, 30.7, 31.0, 29.9, 32.4, 33.0,
                31.9, 30.5, 32.8, 33.2, 30.1, 29.7, 31.4, 32.6, 33.8, 30.4
        };

        System.out.println("=== TEMPERATURAS ORIGINALES DEL MES ===");
        System.out.println(Arrays.toString(tempsMes));

        // Ordenamiento ascendente y 5 mínimas
        double[] copiaAsc = tempsMes.clone();
        int compsAsc = selectionSortAsc(copiaAsc);
        System.out.println("\nOrdenado Ascendente: " + Arrays.toString(copiaAsc));
        mostrarTop5Minimas(copiaAsc);

        // Ordenamiento descendente y 5 máximas
        double[] copiaDesc = tempsMes.clone();
        int compsDesc = selectionSortDesc(copiaDesc);
        System.out.println("\nOrdenado Descendente: " + Arrays.toString(copiaDesc));
        mostrarTop5Maximas(copiaDesc);

        // Comparación de casos: Ordenado, Invertido y Desordenado
        System.out.println("\n=== COMPARATIVA DE COMPARACIONES EN SELECTION SORT (N=30) ===");
        double[] ordenado = copiaAsc.clone();
        double[] invertido = copiaDesc.clone();
        double[] desordenado = tempsMes.clone();

        int c1 = selectionSortAsc(ordenado);
        int c2 = selectionSortAsc(invertido);
        int c3 = selectionSortAsc(desordenado);

        System.out.println("Arreglo ya ordenado    : " + c1 + " comparaciones");
        System.out.println("Arreglo invertido      : " + c2 + " comparaciones");
        System.out.println("Arreglo desordenado    : " + c3 + " comparaciones");

        System.out.println("\n--- CONCLUSION ---");
        System.out.println("Selection Sort siempre realiza exactamente n*(n-1)/2 comparaciones (435 en este caso),");
        System.out.println("sin importar si el arreglo esta ordenado, invertido o desordenado, debido a sus dos bucles fijos.");
    }
}

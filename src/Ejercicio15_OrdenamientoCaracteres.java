import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio15_OrdenamientoCaracteres {

    // Insertion Sort alfabético insensible a mayúsculas/minúsculas
    public static void insertionSortChars(char[] a) {
        System.out.println("\n--- Proceso de desplazamiento e inserción ---");

        for (int i = 1; i < a.length; i++) {
            char clave = a[i];
            int j = i - 1;

            // Comparar ignorando diferencias de mayúsculas y minúsculas
            while (j >= 0 && Character.toLowerCase(a[j]) > Character.toLowerCase(clave)) {
                a[j + 1] = a[j]; // Desplazamiento a la derecha
                j--;
            }
            // Inserción en la posición correcta (mantiene repetidos de forma estable)
            a[j + 1] = clave;

            System.out.println("Paso " + i + " (insertando '" + clave + "'): " + Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Permite ingresar una palabra o usar una por defecto si se presiona Enter
        System.out.print("Ingrese una palabra o texto a ordenar (o presione Enter para 'Estructura'): ");
        String entrada = sc.nextLine().trim();

        if (entrada.isEmpty()) {
            entrada = "Estructura";
        }

        // Convertir la cadena a un arreglo de caracteres primitivos
        char[] letras = entrada.toCharArray();

        System.out.println("\n=== ARREGLO ORIGINAL ===");
        System.out.println(Arrays.toString(letras));

        // Ordenamiento con trazabilidad
        insertionSortChars(letras);

        System.out.println("\n=== ARREGLO FINAL ORDENADO (A-Z) ===");
        System.out.println(Arrays.toString(letras));
        System.out.println("Cadena resultante: " + new String(letras));

        sc.close();
    }
}

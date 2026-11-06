import java.util.Arrays;
import java.util.Comparator;

// Clase modelo para representar a cada contacto
class Contacto {
    private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre + " | Tel: " + telefono + " | Correo: " + correo;
    }
}

public class Ejercicio13_AgendaTelefonica {

    // 1. Ordenamiento manual (Insertion Sort) con criterio multinivel
    public static void ordenarManual(Contacto[] lista) {
        for (int i = 1; i < lista.length; i++) {
            Contacto clave = lista[i];
            int j = i - 1;

            // Desplaza a la derecha si el contacto actual debe ir antes que el evaluado
            while (j >= 0 && debeIrAntes(clave, lista[j])) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = clave;
        }
    }

    // Regla de desempate manual: nombre A-Z y luego teléfono ascendente
    private static boolean debeIrAntes(Contacto a, Contacto b) {
        int compNombre = a.getNombre().compareToIgnoreCase(b.getNombre());
        if (compNombre != 0) {
            return compNombre < 0; // Nombre menor alfabéticamente va primero
        }
        // Si tienen el mismo nombre, desempata por teléfono
        return a.getTelefono().compareTo(b.getTelefono()) < 0;
    }

    // 2. Ordenamiento equivalente con herramientas nativas de Java (Comparator)
    public static void ordenarNativo(Contacto[] lista) {
        Arrays.sort(lista, Comparator
                .comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getTelefono));
    }

    public static void imprimirAgenda(Contacto[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ". " + lista[i]);
        }
    }

    public static void main(String[] args) {
        // Dataset de prueba con contactos de nombres duplicados
        Contacto[] agenda = {
                new Contacto("Carlos Perez", "3001234567", "carlos.perez@email.com"),
                new Contacto("Ana Gomez", "3109876543", "ana.g@email.com"),
                new Contacto("Carlos Perez", "3007654321", "carlos.otro@email.com"), // Mismo nombre, teléfono mayor
                new Contacto("Beatriz Diaz", "3154567890", "beatriz@email.com"),
                new Contacto("Ana Gomez", "3101112233", "ana.primera@email.com")     // Mismo nombre, teléfono menor
        };

        System.out.println("=== AGENDA ORIGINAL ===");
        imprimirAgenda(agenda);

        // Prueba ordenamiento manual
        Contacto[] copiaManual = agenda.clone();
        ordenarManual(copiaManual);
        System.out.println("\n=== AGENDA ORDENADA (ALGORITMO MANUAL) ===");
        imprimirAgenda(copiaManual);

        // Prueba ordenamiento nativo
        Contacto[] copiaNativa = agenda.clone();
        ordenarNativo(copiaNativa);
        System.out.println("\n=== AGENDA ORDENADA (HERRAMIENTA NATIVA / COMPARATOR) ===");
        imprimirAgenda(copiaNativa);

        // Comparativa técnica exigida por la guía
        System.out.println("\n--- COMPARATIVA TECNICA ---");
        System.out.println("1. Manual: Permite comprender el funcionamiento interno del algoritmo y no depende");
        System.out.println("   de librerias externas, pero requiere mas lineas y validacion de casos borde.");
        System.out.println("2. Nativo: Arrays.sort() utiliza Dual-Pivot Quicksort o TimSort, es altamente legible,");
        System.out.println("   optimizado a nivel de maquina virtual y reduce errores en criterios multinivel.");
    }
}

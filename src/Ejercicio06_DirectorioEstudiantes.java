import java.util.Arrays;
import java.util.Comparator;

// Clase modelo para representar al estudiante
class Estudiante {
    private String codigo;
    private String nombre;
    private int semestre;
    private double promedio;

    public Estudiante(String codigo, String nombre, int semestre, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre = semestre;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " | Sem: " + semestre + " | Prom: " + promedio;
    }
}

public class Ejercicio06_DirectorioEstudiantes {

    // 1. Ordenamiento manual (Insertion Sort) con doble criterio:
    // Criterio 1: Promedio descendente (mayor a menor).
    // Criterio 2: En caso de empate, Nombre ascendente (A a Z).
    public static void ordenarManual(Estudiante[] lista) {
        for (int i = 1; i < lista.length; i++) {
            Estudiante clave = lista[i];
            int j = i - 1;

            while (j >= 0 && debeIrAntes(clave, lista[j])) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = clave;
        }
    }

    // Regla de comparación manual de los dos criterios
    private static boolean debeIrAntes(Estudiante a, Estudiante b) {
        // Si el promedio de 'a' es mayor al de 'b', va antes
        if (a.getPromedio() > b.getPromedio()) {
            return true;
        }
        // Si tienen el mismo promedio, desempatar alfabéticamente por nombre
        if (a.getPromedio() == b.getPromedio()) {
            return a.getNombre().compareToIgnoreCase(b.getNombre()) < 0;
        }
        return false;
    }

    // 2. Ordenamiento equivalente utilizando la API moderna de Comparator
    public static void ordenarConComparator(Estudiante[] lista) {
        Arrays.sort(lista, Comparator
                .comparingDouble(Estudiante::getPromedio).reversed() // Promedio descendente
                .thenComparing(Estudiante::getNombre, String.CASE_INSENSITIVE_ORDER)); // Nombre ascendente
    }

    // Imprimir el listado con formato de ranking numérico
    public static void imprimirRanking(Estudiante[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ". " + lista[i]);
        }
    }

    public static void main(String[] args) {
        // Dataset de prueba con empates exactos en el promedio
        Estudiante[] estudiantes = {
                new Estudiante("E01", "Carlos Mendoza", 4, 3.8),
                new Estudiante("E02", "Ana Ramirez", 3, 4.5),
                new Estudiante("E03", "Beatriz Lopez", 5, 4.2),
                new Estudiante("E04", "Daniel Castro", 2, 4.5), // Empate en 4.5 con Ana (debe ir Ana primero por orden A-Z)
                new Estudiante("E05", "Andres Silva", 4, 3.8)   // Empate en 3.8 con Carlos (debe ir Andres primero)
        };

        System.out.println("=== LISTADO ORIGINAL ===");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }

        // Prueba 1: Ordenamiento manual
        Estudiante[] copiaManual = estudiantes.clone();
        ordenarManual(copiaManual);
        System.out.println("\n=== RANKING CON ORDENAMIENTO MANUAL ===");
        imprimirRanking(copiaManual);

        // Prueba 2: Ordenamiento con Comparator
        Estudiante[] copiaComparator = estudiantes.clone();
        ordenarConComparator(copiaComparator);
        System.out.println("\n=== RANKING CON COMPARATOR NATIVO ===");
        imprimirRanking(copiaComparator);
    }
}
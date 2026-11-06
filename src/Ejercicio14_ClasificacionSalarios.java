import java.util.Arrays;

// Clase modelo para representar a los trabajadores
class Empleado {
    private String id;
    private String nombre;
    private String cargo;
    private double salario;

    public Empleado(String id, String nombre, String cargo, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " (" + cargo + ") -> $" + String.format("%.2f", salario);
    }
}

public class Ejercicio14_ClasificacionSalarios {

    // Método principal de Merge Sort
    public static void mergeSortEmpleados(Empleado[] a) {
        if (a == null || a.length < 2) return;
        Empleado[] buffer = new Empleado[a.length];
        mergeSortRecursivo(a, buffer, 0, a.length);
    }

    // División recursiva
    private static void mergeSortRecursivo(Empleado[] a, Empleado[] buffer, int lo, int hi) {
        if (hi - lo < 2) return;

        int mid = (lo + hi) / 2;
        mergeSortRecursivo(a, buffer, lo, mid);
        mergeSortRecursivo(a, buffer, mid, hi);

        mezclar(a, buffer, lo, mid, hi);
    }

    // Fusión de subarreglos preservando la relación del objeto completo
    private static void mezclar(Empleado[] a, Empleado[] buffer, int lo, int mid, int hi) {
        int i = lo;
        int j = mid;
        int k = lo;

        while (i < mid && j < hi) {
            // Debe ir antes según salario descendente o nombre ascendente
            if (debeIrAntes(a[i], a[j])) {
                buffer[k++] = a[i++];
            } else {
                buffer[k++] = a[j++];
            }
        }

        while (i < mid) buffer[k++] = a[i++];
        while (j < hi) buffer[k++] = a[j++];

        System.arraycopy(buffer, lo, a, lo, hi - lo);
    }

    // Criterio multinivel: Salario DESC, en empate Nombre ASC (A-Z)
    private static boolean debeIrAntes(Empleado a, Empleado b) {
        if (a.getSalario() != b.getSalario()) {
            return a.getSalario() > b.getSalario();
        }
        return a.getNombre().compareToIgnoreCase(b.getNombre()) < 0;
    }

    public static void main(String[] args) {
        Empleado[] planilla = {
                new Empleado("EMP01", "Roberto Perez", "Desarrollador Backend", 4500000.0),
                new Empleado("EMP02", "Camila Torres", "Lider Tecnico", 7800000.0),
                new Empleado("EMP03", "Andres Silva", "Analista QA", 3200000.0),
                new Empleado("EMP04", "Beatriz Mendoza", "Desarrolladora Frontend", 4500000.0), // Mismo salario que Roberto
                new Empleado("EMP05", "David Castro", "Disenador UX/UI", 3200000.0)             // Mismo salario que Andres
        };

        System.out.println("=== PLANILLA ORIGINAL ===");
        for (Empleado e : planilla) System.out.println(e);

        mergeSortEmpleados(planilla);

        System.out.println("\n=== PLANILLA ORDENADA (SALARIO DESCENDENTE) ===");
        for (int i = 0; i < planilla.length; i++) {
            System.out.println((i + 1) + ". " + planilla[i]);
        }

        System.out.println("\n--- VERIFICACION DE INTEGRIDAD REFERENCIAL ---");
        System.out.println("Cada empleado se movio como una instancia completa en memoria;");
        System.out.println("los cargos, nombres e IDs permanecen exactamente vinculados a su salario.");
    }
}
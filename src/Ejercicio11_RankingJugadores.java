import java.util.Arrays;

// Clase modelo para representar a cada participante
class Jugador {
    private String nombre;
    private int partidasJugadas;
    private int victorias;
    private int puntos;

    public Jugador(String nombre, int partidasJugadas, int victorias, int puntos) {
        this.nombre = nombre;
        this.partidasJugadas = partidasJugadas;
        this.victorias = victorias;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return nombre + " | Puntos: " + puntos + " | Victorias: " + victorias + " | PJ: " + partidasJugadas;
    }
}

public class Ejercicio11_RankingJugadores {

    // Método público para iniciar Quick Sort
    public static void quickSort(Jugador[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSortRecursivo(arr, 0, arr.length - 1);
    }

    // Algoritmo recursivo de Quick Sort
    private static void quickSortRecursivo(Jugador[] arr, int lo, int hi) {
        int i = lo;
        int j = hi;
        Jugador pivote = arr[(lo + hi) / 2];

        while (i <= j) {
            // Avanza i mientras el jugador deba ir antes que el pivote
            while (debeIrAntes(arr[i], pivote)) {
                i++;
            }
            // Retrocede j mientras el pivote deba ir antes que el jugador
            while (debeIrAntes(pivote, arr[j])) {
                j--;
            }

            if (i <= j) {
                Jugador temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (lo < j) quickSortRecursivo(arr, lo, j);
        if (i < hi) quickSortRecursivo(arr, i, hi);
    }

    // Regla de comparación multinivel requerida:
    // 1. Puntos descendente (mayor puntaje primero)
    // 2. En empate, Victorias descendente (más victorias primero)
    // 3. En empate, Nombre ascendente (A a Z)
    private static boolean debeIrAntes(Jugador a, Jugador b) {
        if (a.getPuntos() != b.getPuntos()) {
            return a.getPuntos() > b.getPuntos();
        }
        if (a.getVictorias() != b.getVictorias()) {
            return a.getVictorias() > b.getVictorias();
        }
        return a.getNombre().compareToIgnoreCase(b.getNombre()) < 0;
    }

    public static void main(String[] args) {
        // Datos de prueba con empates de puntos y victorias
        Jugador[] jugadores = {
                new Jugador("Mateo", 20, 10, 1500),
                new Jugador("Laura", 22, 14, 1800),
                new Jugador("Camilo", 18, 12, 1500), // Mismos puntos que Mateo, pero más victorias
                new Jugador("Andres", 20, 10, 1500), // Mismos puntos y victorias que Mateo, desempata por nombre
                new Jugador("Sofia", 25, 18, 2100)
        };

        System.out.println("=== LISTADO ORIGINAL DE JUGADORES ===");
        for (Jugador j : jugadores) {
            System.out.println(j);
        }

        quickSort(jugadores);

        System.out.println("\n=== CLASIFICACION FINAL (RANKING) ===");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println((i + 1) + ". " + jugadores[i]);
        }
    }
}

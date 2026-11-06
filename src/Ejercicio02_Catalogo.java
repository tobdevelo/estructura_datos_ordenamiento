import java.util.Arrays;

// Clase Producto para modelar los artículos del catálogo
class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidadDisponible;

    public Producto(String codigo, String nombre, double precio, int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "[" + codigo + " | " + nombre + " | $" + precio + " | Stock: " + cantidadDisponible + "]";
    }
}

public class Ejercicio02_Catalogo {

    // 1. Selection Sort Manual - Ascendente (menor a mayor precio)
    public static void selectionSortAsc(Producto[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            // Buscar el índice del producto con menor precio en el resto del arreglo
            for (int j = i + 1; j < n; j++) {
                if (lista[j].getPrecio() < lista[minIdx].getPrecio()) {
                    minIdx = j;
                }
            }
            // Intercambiar los objetos completos para no desasociar atributos
            if (minIdx != i) {
                Producto temp = lista[i];
                lista[i] = lista[minIdx];
                lista[minIdx] = temp;
            }
        }
    }

    // 2. Selection Sort Manual - Descendente (mayor a menor precio)
    public static void selectionSortDesc(Producto[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            // Buscar el índice del producto con mayor precio
            for (int j = i + 1; j < n; j++) {
                if (lista[j].getPrecio() > lista[maxIdx].getPrecio()) {
                    maxIdx = j;
                }
            }
            // Intercambiar objetos
            if (maxIdx != i) {
                Producto temp = lista[i];
                lista[i] = lista[maxIdx];
                lista[maxIdx] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Arreglo inicial de objetos Producto
        Producto[] productos = {
                new Producto("P001", "Teclado Mecanico", 120000.0, 15),
                new Producto("P002", "Mouse Optico", 35000.0, 30),
                new Producto("P003", "Monitor 24 pulg", 540000.0, 8),
                new Producto("P004", "Memoria USB 64GB", 25000.0, 50),
                new Producto("P005", "Diadema Gamer", 95000.0, 20)
        };

        System.out.println("=== ARREGLO ORIGINAL ===");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // Ordenamiento ascendente
        selectionSortAsc(productos);
        System.out.println("\n=== PRODUCTOS POR PRECIO ASCENDENTE (SELECTION SORT) ===");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // Producto más económico y más costoso con el arreglo ascendente
        System.out.println("\nProducto mas economico: " + productos[0]);
        System.out.println("Producto mas costoso: " + productos[productos.length - 1]);

        // Ordenamiento descendente
        selectionSortDesc(productos);
        System.out.println("\n=== PRODUCTOS POR PRECIO DESCENDENTE ===");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // Justificación teórica solicitada por la guía
        System.out.println("\n--- JUSTIFICACION ---");
        System.out.println("Se intercambia el objeto Producto completo para garantizar la integridad referencial.");
        System.out.println("Si solo se ordenaran los precios de forma aislada, el precio de un articulo quedaria");
        System.out.println("asignado al codigo y nombre de otro, corrompiendo los datos del inventario.");
    }
}
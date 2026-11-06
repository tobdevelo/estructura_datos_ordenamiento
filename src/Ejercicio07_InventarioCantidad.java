import java.util.Arrays;

// Clase para representar artículos de bodega
class ProductoInventario {
    private String nombre;
    private int cantidad;

    public ProductoInventario(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (Stock: " + cantidad + ")";
    }
}

public class Ejercicio07_InventarioCantidad {

    // Insertion Sort para ordenar por stock ascendente y contar desplazamientos
    public static int insertionSortPorCantidad(ProductoInventario[] items) {
        int desplazamientos = 0;

        for (int i = 1; i < items.length; i++) {
            ProductoInventario clave = items[i];
            int j = i - 1;

            // Desplazar elementos hacia la derecha si tienen mayor cantidad
            while (j >= 0 && items[j].getCantidad() > clave.getCantidad()) {
                items[j + 1] = items[j];
                desplazamientos++;
                j--;
            }
            items[j + 1] = clave;
        }
        return desplazamientos;
    }

    // Identificar e imprimir productos con stock en 0
    public static void reportarAgotados(ProductoInventario[] items) {
        System.out.println("\n--- Alerta de productos agotados ---");
        boolean hayAgotados = false;
        for (ProductoInventario p : items) {
            if (p.getCantidad() == 0) {
                System.out.println("ALERTA: " + p.getNombre() + " esta completamente agotado.");
                hayAgotados = true;
            }
        }
        if (!hayAgotados) {
            System.out.println("No hay productos agotados actualmente.");
        }
    }

    public static void main(String[] args) {
        // 1. Inventario desordenado de prueba
        ProductoInventario[] stock = {
                new ProductoInventario("Impresora Láser", 12),
                new ProductoInventario("Cable HDMI", 0),       // Agotado
                new ProductoInventario("Adaptador USB-C", 4),
                new ProductoInventario("Toner Negro", 0),       // Agotado
                new ProductoInventario("Resma de Papel", 25)
        };

        System.out.println("=== INVENTARIO ORIGINAL ===");
        for (ProductoInventario p : stock) System.out.println(p);

        int movs1 = insertionSortPorCantidad(stock);

        System.out.println("\n=== ORDENADO POR MENOR EXISTENCIA (ASCENDENTE) ===");
        for (ProductoInventario p : stock) System.out.println(p);
        System.out.println("Desplazamientos realizados: " + movs1);

        reportarAgotados(stock);

        // 2. Prueba con inventario casi ordenado
        ProductoInventario[] casiOrdenado = {
                new ProductoInventario("Item A", 2),
                new ProductoInventario("Item B", 5),
                new ProductoInventario("Item C", 4), // Leve alteración
                new ProductoInventario("Item D", 10),
                new ProductoInventario("Item E", 15)
        };

        System.out.println("\n=== PRUEBA CON INVENTARIO CASI ORDENADO ===");
        int movs2 = insertionSortPorCantidad(casiOrdenado);
        for (ProductoInventario p : casiOrdenado) System.out.println(p);
        System.out.println("Desplazamientos con arreglo casi ordenado: " + movs2);
    }
}
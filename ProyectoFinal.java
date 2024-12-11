package lucyferstarlight.proyectofinal;

/**
 *
 * @author Harold Adir Maldonado Saavedra
 */
import java.util.Scanner;

public class ProyectoFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;

        do {
            System.out.println("\n=== Menú de Inventario ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.next();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    inventario.agregarProducto(nombre, cantidad, precio);
                    System.out.println("Producto agregado con éxito.");
                    break;
                case 2:
                    System.out.println("=== Lista de Productos ===");
                    inventario.mostrarProductos();
                    break;
                case 3:
                    System.out.print("Nombre del producto a buscar: ");
                    nombre = scanner.next();
                    Producto producto = inventario.buscarProducto(nombre);
                    if (producto != null) {
                        System.out.println("Producto encontrado: " + producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre del producto a modificar: ");
                    nombre = scanner.next();
                    System.out.print("Nueva cantidad: ");
                    cantidad = scanner.nextInt();
                    System.out.print("Nuevo precio: ");
                    precio = scanner.nextDouble();
                    if (inventario.modificarProducto(nombre, cantidad, precio)) {
                        System.out.println("Producto modificado con éxito.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre del producto a eliminar: ");
                    nombre = scanner.next();
                    if (inventario.eliminarProducto(nombre)) {
                        System.out.println("Producto eliminado con éxito.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
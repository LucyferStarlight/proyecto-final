package lucyferstarlight.proyectofinal;

import java.util.Scanner;

public class ProyectoFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = -1;

        // Bucle principal del programa
        do {
            mostrarMenu();

            // Validar entrada para que solo acepte números enteros
            opcion = leerEntero(scanner, "Seleccione una opción válida: ");

            // Selección de funcionalidad basada en la opción ingresada
            switch (opcion) {
                case 1:
                    inventario.agregarProducto(scanner);
                    break;
                case 2:
                    inventario.mostrarInventario();
                    break;
                case 3:
                    inventario.buscarProducto(scanner);
                    break;
                case 4:
                    inventario.editarProducto(scanner);
                    break;
                case 5:
                    inventario.eliminarProducto(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    // Método para mostrar el menú principal
    public static void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Inventarios ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Buscar producto por nombre");
        System.out.println("4. Editar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método para leer y validar números enteros
    public static int leerEntero(Scanner scanner, String mensajeError) {
        while (!scanner.hasNextInt()) { // Verificar si la entrada es un entero
            System.out.println("Error: Debe ingresar un número entero.");
            System.out.print(mensajeError);
            scanner.next(); // Consumir la entrada no válida
        }
        return scanner.nextInt(); // Devolver el entero válido
    }
}
package lucyferstarlight.proyectofinal;

import java.util.Scanner;

public class Inventario {
    private String[] nombres = new String[10];
    private int[] cantidades = new int[10];
    private double[] precios = new double[10];
    private int tamanioActual = 0;
    public double precio=0;
    public String nombre="NULL";
    public int cantidad=0;

    public void agregarProducto(Scanner scanner) {
        if (tamanioActual >= nombres.length) {
            System.out.println("El inventario está lleno. No se pueden agregar más productos.");
            return;
        }
    
        // Solicitar el nombre
        System.out.println("Ingrese el nombre del producto: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        
    
        // Validación para la cantidad (solo enteros positivos)
        int cantidad = -1;
        while (cantidad <= 0) {
            System.out.println("Ingrese la cantidad (debe ser un número entero positivo): ");
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                if (cantidad <= 0) {
                    System.out.println("Error: La cantidad debe ser un número entero positivo.");
                }
            } else {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next(); // Limpiar el buffer
            }
        }
    
        // Validación para el precio (solo números decimales positivos)
        double precio = -1;
        while (precio <= 0) {
            System.out.println("Ingrese el precio (debe ser un número positivo): ");
            if (scanner.hasNextDouble()) {
                precio = scanner.nextDouble();
                if (precio <= 0) {
                    System.out.println("Error: El precio debe ser un número positivo.");
                }
            } else {
                System.out.println("Error: Ingrese un número válido para el precio.");
                scanner.next(); // Limpiar el buffer
            }
        }
    
        scanner.nextLine(); // Consumir la nueva línea restante
    
        // Agregar el producto
        nombres[tamanioActual] = nombre;
        cantidades[tamanioActual] = cantidad;
        precios[tamanioActual] = precio;
        tamanioActual++;
        System.out.println("\nProducto agregado correctamente.");
    }
    
    public void mostrarInventario() {
        if (tamanioActual == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("\n--- Inventario ---");
        for (int i = 0; i < tamanioActual; i++) {
            System.out.printf("%d. %s - Cantidad: %d - Precio: $%.2f\n", i + 1, nombres[i], cantidades[i], precios[i]);
        }
    }

    public void buscarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        scanner.nextLine();
        String nombreBuscado = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < tamanioActual; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.printf("Producto encontrado: %s - Cantidad: %d - Precio: $%.2f\n", nombres[i], cantidades[i], precios[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public void editarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a editar: ");
        scanner.nextLine(); // Limpiar el buffer
        String nombreEditar = scanner.nextLine();
        boolean encontrado = false;
    
        for (int i = 0; i < tamanioActual; i++) {
            if (nombres[i].equalsIgnoreCase(nombreEditar)) {
                // Editar el nombre
                System.out.print("Ingrese el nuevo nombre (o presione Enter para no cambiarlo): ");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    nombres[i] = nuevoNombre;
                }
    
                // Ciclo para cantidad (validación de números enteros positivos o -1)
                int nuevaCantidad = -1;
                while (true) {
                    System.out.print("Ingrese la nueva cantidad (o -1 para no cambiarla): ");
                    if (scanner.hasNextInt()) {
                        nuevaCantidad = scanner.nextInt();
                        if (nuevaCantidad >= 0 || nuevaCantidad == -1) {
                            if (nuevaCantidad != -1) {
                                cantidades[i] = nuevaCantidad;
                            }
                            break;
                        } else {
                            System.out.println("Error: Ingrese un número entero positivo o -1.");
                        }
                    } else {
                        System.out.println("Error: Ingrese un número entero válido.");
                        scanner.next(); // Limpiar el buffer
                    }
                }
    
                // Ciclo para precio (validación de números decimales positivos o -1)
                double nuevoPrecio = -1;
                while (true) {
                    System.out.print("Ingrese el nuevo precio (o -1 para no cambiarlo): ");
                    if (scanner.hasNextDouble()) {
                        nuevoPrecio = scanner.nextDouble();
                        if (nuevoPrecio >= 0 || nuevoPrecio == -1) {
                            if (nuevoPrecio != -1) {
                                precios[i] = nuevoPrecio;
                            }
                            break;
                        } else {
                            System.out.println("Error: Ingrese un número positivo o -1.");
                        }
                    } else {
                        System.out.println("Error: Ingrese un número válido.");
                        scanner.next(); // Limpiar el buffer
                    }
                }
    
                System.out.println("Producto editado correctamente.");
                encontrado = true;
                break;
            }
        }
    
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
    
    
    public void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        scanner.nextLine();
        String nombreEliminar = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < tamanioActual; i++) {
            if (nombres[i].equalsIgnoreCase(nombreEliminar)) {
                for (int j = i; j < tamanioActual - 1; j++) {
                    nombres[j] = nombres[j + 1];
                    cantidades[j] = cantidades[j + 1];
                    precios[j] = precios[j + 1];
                }
                tamanioActual--;
                System.out.println("Producto eliminado correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
}
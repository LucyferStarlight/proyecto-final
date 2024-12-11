package lucyferstarlight.proyectofinal;

/**
 *
 * @author Harold Adir Maldonado Saavedra
 */
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Agregar producto
    public void agregarProducto(String nombre, int cantidad, double precio) {
        productos.add(new Producto(nombre, cantidad, precio));
    }

    // Mostrar todos los productos
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    // Buscar un producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // No encontrado
    }

    // Eliminar producto
    public boolean eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            productos.remove(producto);
            return true;
        }
        return false;
    }

    // Modificar producto
    public boolean modificarProducto(String nombre, int nuevaCantidad, double nuevoPrecio) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            producto.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }
}
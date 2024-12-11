# Sistema de Gestión de Inventarios

Este proyecto es un sistema básico para gestionar un inventario de productos, desarrollado en **Java**. Permite realizar las siguientes operaciones:

1. Agregar nuevos productos.
2. Mostrar el inventario actual.
3. Buscar productos por su nombre.

## **Requisitos**
- **Java Development Kit (JDK)** 8 o superior.
- Editor de texto o IDE (como IntelliJ IDEA, Eclipse, o VS Code con extensiones de Java).

## **Estructura del Proyecto**
- **Paquete:** `lucyferstarlight.proyectofinal`
- **Archivo principal:** `InventarioIncompleto.java`

El sistema utiliza:
- **Arreglos:** Para almacenar los datos de los productos (nombres, cantidades, precios).
- **Ciclos y condicionales:** Para recorrer los datos y realizar búsquedas.
- **Módulos (funciones):** Para organizar el código y facilitar su comprensión.

## **Cómo Ejecutar el Proyecto**
1. **Compilar el archivo Java:**
   Navega a la carpeta del proyecto y compila el archivo principal con:
   ```bash
   javac -d . InventarioIncompleto.java

   Funciones Disponibles

    Agregar Producto:
        Solicita el nombre, la cantidad, y el precio del producto.
        Almacena los datos en arreglos.

    Mostrar Inventario:
        Lista todos los productos disponibles con su cantidad y precio.

    Buscar Producto:
        Permite buscar un producto por su nombre (no distingue entre mayúsculas y minúsculas).

Funcionalidades Pendientes

    Eliminar productos del inventario.
    Validar datos ingresados: Ejemplo, evitar precios negativos o cantidades inválidas.
    Optimizar la búsqueda: Actualmente, utiliza búsqueda secuencial.

Contribución

Si deseas colaborar, puedes:

    Realizar un fork del repositorio.
    Subir tus cambios mediante un Pull Request.
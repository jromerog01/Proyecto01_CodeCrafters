package productos.departamentos;

import productos.Producto;

public interface ProductoFactory {
    Producto crearProducto(String tipo);
    }

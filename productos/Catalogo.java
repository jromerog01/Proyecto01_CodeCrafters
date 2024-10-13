package productos;

import productos.departamentos.alimentos.ChipsFuegoFlaminHot;
import productos.departamentos.alimentos.JackDanielsApple;
import productos.departamentos.alimentos.JugoManzanaOrganico;
import productos.departamentos.electrodomesticos.ExtractorJugos;
import productos.departamentos.electrodomesticos.LicuadoraNinja;
import productos.departamentos.electrodomesticos.MolinilloEspecias;
import productos.departamentos.electrodomesticos.Waflera;
import productos.departamentos.electronica.CamaraDigital;
import productos.departamentos.electronica.HomeTheater;
import productos.departamentos.electronica.IPhone18ProPlusMax;
import productos.departamentos.electronica.SmartTV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogo {

    private ArrayList<Producto> productos;

    public Catalogo() {
        productos = new ArrayList<>();
    }

    public void crearCatalogo(){
        Carrito carrito = new Carrito();
        productos.add(new ChipsFuegoFlaminHot(carrito));
        productos.add(new JackDanielsApple(carrito));
        productos.add(new JugoManzanaOrganico(carrito));
        productos.add(new LicuadoraNinja(carrito));
        productos.add(new ExtractorJugos(carrito));
        productos.add(new LicuadoraNinja(carrito));
        productos.add(new MolinilloEspecias(carrito));
        productos.add(new Waflera(carrito));
        productos.add(new CamaraDigital(carrito));
        productos.add(new HomeTheater(carrito));
        productos.add(new IPhone18ProPlusMax(carrito));
        productos.add(new SmartTV(carrito));

    }

    // Método para agrupar productos por departamento y luego imprimirlos
    public void imprimirCatalogo() {
        // Crear un Map para agrupar los productos por departamento
        Map<String, List<Producto>> productosPorDepartamento = new HashMap<>();

        // Agrupar los productos por su departamento
        for (Producto producto : productos) {
            String departamento = producto.getDepartamento();
            productosPorDepartamento
                    .computeIfAbsent(departamento, k -> new ArrayList<>())
                    .add(producto);
        }

        // Imprimir los productos agrupados por departamento
        for (String departamento : productosPorDepartamento.keySet()) {
            System.out.println(departamento); // Imprimir el nombre del departamento
            for (Producto producto : productosPorDepartamento.get(departamento)) {
                System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
            }
            System.out.println();  // Línea en blanco entre departamentos
        }
    }

    public void aplicarDescuento(){
        Producto carrito = new Carrito();
        carrito = new JackDanielsApple(carrito);
        

    }
}

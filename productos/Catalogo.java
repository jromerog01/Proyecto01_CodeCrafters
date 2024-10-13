package productos;

import productos.departamentos.alimentos.*;
import productos.departamentos.electrodomesticos.*;
import productos.departamentos.electronica.*;
import productos.departamentos.DescuentoDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogo {

    public ArrayList<Producto> productos;

    public Catalogo() {
        productos = new ArrayList<>();
    }

    public void crearCatalogo(String paisCliente){
        Carrito carrito = new Carrito();

        Producto chipsFuego = new ChipsFuegoFlaminHot(carrito);
        Producto jackDaniels = new JackDanielsApple(carrito);
        Producto jugoManzana = new JugoManzanaOrganico(carrito);
        Producto lifeSavers = new LifeSaversGummies(carrito);

        Producto extractorJugos = new ExtractorJugos(carrito);
        Producto licuadoraNinja = new LicuadoraNinja(carrito);
        Producto molinillo = new MolinilloEspecias(carrito);
        Producto waflera = new Waflera(carrito);

        Producto camaraDigital = new CamaraDigital(carrito);
        Producto homeTheater = new HomeTheater(carrito);
        Producto iPhone18ProPlusMax = new IPhone18ProPlusMax(carrito);
        Producto smartTV = new SmartTV(carrito);

        // Aplicar descuentos utilizando el Decorator
        switch (paisCliente) {
            case "USA" -> {
                camaraDigital = new DescuentoDecorator(camaraDigital, 20); // Descuento del 20% en electrónicos
                homeTheater = new DescuentoDecorator(homeTheater, 20);
                iPhone18ProPlusMax = new DescuentoDecorator(iPhone18ProPlusMax, 20);
                smartTV = new DescuentoDecorator(smartTV, 20);
            }
            case "Mexico" -> {
                extractorJugos = new DescuentoDecorator(extractorJugos, 15); // Descuento del 15% en electrodomésticos
                licuadoraNinja = new DescuentoDecorator(licuadoraNinja, 15);
                molinillo = new DescuentoDecorator(molinillo, 15);
                waflera = new DescuentoDecorator(waflera, 15);
            }
            case "Brasil" -> {
                chipsFuego = new DescuentoDecorator(chipsFuego, 10); // Descuento del 10% en alimentos
                jackDaniels = new DescuentoDecorator(jackDaniels, 10);
                jugoManzana = new DescuentoDecorator(jugoManzana, 10);
                lifeSavers = new DescuentoDecorator(lifeSavers, 10);
            }
        }

        productos.add(chipsFuego);
        productos.add(jackDaniels);
        productos.add(jugoManzana);
        productos.add(lifeSavers);
        productos.add(extractorJugos);
        productos.add(licuadoraNinja);
        productos.add(molinillo);
        productos.add(waflera);
        productos.add(camaraDigital);
        productos.add(homeTheater);
        productos.add(iPhone18ProPlusMax);
        productos.add(smartTV);
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
}

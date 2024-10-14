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

    /**
     * Metodo constructor de catalogo
     */
    public Catalogo() {
        productos = new ArrayList<>();
    }

    /**
     * Metodo que crea un catalogo mostrando los precios segun la region
     * @param paisCliente El pais del cliente que desea recibir
     */
    public void crearCatalogo(String paisCliente){
        
        Producto chipsFuego = new ChipsFuegoFlaminHot();
        Producto jackDaniels = new JackDanielsApple();
        Producto jugoManzana = new JugoManzanaOrganico();
        Producto lifeSavers = new LifeSaversGummies();

        Producto extractorJugos = new ExtractorJugos();
        Producto licuadoraNinja = new LicuadoraNinja();
        Producto molinillo = new MolinilloEspecias();
        Producto waflera = new Waflera();

        Producto camaraDigital = new CamaraDigital();
        Producto homeTheater = new HomeTheater();
        Producto iPhone18ProPlusMax = new IPhone18ProPlusMax();
        Producto smartTV = new SmartTV();

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

        productos.add(chipsFuego); //0
        productos.add(jackDaniels); //1
        productos.add(jugoManzana); //2
        productos.add(lifeSavers); //3
        productos.add(extractorJugos); //4
        productos.add(licuadoraNinja); //5
        productos.add(molinillo); //6
        productos.add(waflera); //7
        productos.add(camaraDigital); //8
        productos.add(homeTheater); //9
        productos.add(iPhone18ProPlusMax);//10
        productos.add(smartTV); //11
    }

    /**
     * Método para agrupar productos por departamento y luego imprimirlos
     */
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
                System.out.println("ID: " + producto.getCodigoBarras() + " |  " + producto.getNombre() + " - $" + producto.getPrecio());
            }
            System.out.println();  // Línea en blanco entre departamentos
        }
    }

    /**
     * Método para buscar un producto por su código de barras
     * @param codigoBarras El codigo de barras del producto que se desea buscar
     */
    public Producto buscarProductoPorCodigo(int codigoBarras) {
        for (Producto producto : productos) {
            if (producto.getCodigoBarras() == codigoBarras) {
                return producto;
            }
        }
        return null;
    }
}

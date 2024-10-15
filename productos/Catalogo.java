package productos;

import productos.departamentos.alimentos.*;
import productos.departamentos.electrodomesticos.DeptoElectrodomesticos;
import productos.departamentos.electronica.*;
import productos.departamentos.DescuentoDecorator;
import productos.departamentos.ProductoFactory;
import productos.departamentos.electrodomesticos.*;

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
        productos.clear();
        
        // Crear fábricas para cada tipo de producto
        ProductoFactory fabricaElectronica = new DeptoElectronica();
        ProductoFactory fabricaAlimentos = new DeptoAlimentos();
        ProductoFactory fabricaElectrodomesticos = new DeptoElectrodomesticos();

        // Crear productos usando las fábricas
        Producto camaraDigital = fabricaElectronica.crearProducto("CamaraDigital");
        Producto homeTheater = fabricaElectronica.crearProducto("HomeTheater");
        Producto iPhone18ProPlusMax = fabricaElectronica.crearProducto("IPhone18ProPlusMax");
        Producto smartTV = fabricaElectronica.crearProducto("SmartTV");

        Producto extractorJugos = fabricaElectrodomesticos.crearProducto("ExtractorJugos");
        Producto licuadoraNinja = fabricaElectrodomesticos.crearProducto("LicuadoraNinja");
        Producto molinillo = fabricaElectrodomesticos.crearProducto("MolinilloEspecias");
        Producto waflera = fabricaElectrodomesticos.crearProducto("Waflera");
        
        Producto chipsFuego = fabricaAlimentos.crearProducto("ChipsFuegoFlaminHot");
        Producto jackDaniels = fabricaAlimentos.crearProducto("JackDanielsApple");
        Producto jugoManzana = fabricaAlimentos.crearProducto("JugoManzanaOrganico");
        Producto lifeSavers = fabricaAlimentos.crearProducto("LifeSaversGummies");


        // Aplicar descuentos utilizando el Decorator
        if(paisCliente != null){
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
    public String getCatalogo() {
        StringBuilder sb = new StringBuilder();

        // Crear un Map para agrupar los productos por departamento
        Map<String, List<Producto>> productosPorDepartamento = new HashMap<>();

        // Agrupar los productos por su departamento
        for (Producto producto : productos) {
            String departamento = producto.getDepartamento();
            productosPorDepartamento
                    .computeIfAbsent(departamento, k -> new ArrayList<>())
                    .add(producto);
        }

        // Construir el string de los productos agrupados por departamento
        for (String departamento : productosPorDepartamento.keySet()) {
            sb.append(departamento).append("\n"); // Añadir el nombre del departamento
            for (Producto producto : productosPorDepartamento.get(departamento)) {
                sb.append("ID: ").append(producto.getCodigoBarras())
                  .append(" | ").append(producto.getNombre())
                  .append(" - $").append(producto.getPrecio()).append("\n");
            }
            sb.append("\n");  // Línea en blanco entre departamentos
        }

        return sb.toString();
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

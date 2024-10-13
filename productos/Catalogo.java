package productos;

import productos.departamentos.alimentos.ChipsFuegoFlaminHot;
import productos.departamentos.alimentos.JackDanielsApple;
import productos.departamentos.alimentos.JugoManzanaOrganico;
import productos.departamentos.alimentos.LifeSaversGummies;
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


        // Aplicar descuentos según el país del cliente
        switch (paisCliente) {
            case "USA" -> {
                camaraDigital.aplicarDescuento(20); // Descuento del 20% en productos electrónicos
                homeTheater.aplicarDescuento(20);
                iPhone18ProPlusMax.aplicarDescuento(20);
                smartTV.aplicarDescuento(20);
            }
            case "Mexico" -> {
                extractorJugos.aplicarDescuento(15); // Descuento del 15% en electrodomésticos
                licuadoraNinja.aplicarDescuento(15);
                molinillo.aplicarDescuento(15);
                waflera.aplicarDescuento(15);
            }
            case "Brasil" -> {
                chipsFuego.aplicarDescuento(10); // Descuento del 10% en productos alimenticios
                jackDaniels.aplicarDescuento(10);
                jugoManzana.aplicarDescuento(10);
                lifeSavers.aplicarDescuento(10);
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

// package idiomas;

// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;


// public class Ingles extends IdiomaCheemsMart {

//     @Override
//     public String saludo() {
//         return "Welcome to Cheems Mart";
//     }

//     @Override
//     public String despedida() {
//         return "See you later...";
//     }

//     @Override 
//     public String agradecimiento(){
//         return "Thank you for visiting Cheems Mart \nPlease come back soon...";
//     }

//     @Override
//     public String fechaEntrega(){
//         LocalDate semanaSiguiente = LocalDate.now().plusDays(7);
//         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//         String fechaEntrega = semanaSiguiente.format(formato);
//         return "The delivery date is scheduled for the day " + fechaEntrega;
//     }

//     @Override
//     public String menuInicio(){
//         return"Main Menu \n" +
//                 "1. View catalog \n" +
//                 "2. Add products to cart \n" +
//                 "3. View cart \n" +
//                 "4. Complete Purchase \n" +
//                 "5. Exit";
//     }

//     @Override
//     public String mensajeCompra() {
//         return "Enter the barcode of the product you want to add (or enter 0 to return to the menu):";
//     }

//     @Override
//     public String mensajeCarrito(String producto){
//         return "Product added to cart" + producto;
//     }

//     @Override
//     public String mensajeError(){
//         return "Product not found. Please try again.";
//     }

//     @Override
//     public String mensajeFinalizarCompra(double total, Carrito carrito){
//         System.out.println("Finalizing purchase...");
//         carrito.imprimirCarrito();
//         return "Total: $" + String.valueOf(total) +
//                 "Thank you for shopping at Cheems Mart";
//     }

//     @Override
//     peublic String mensajeInvalido(){
//         return "Invalid option. Please try again.";
//     }
// }

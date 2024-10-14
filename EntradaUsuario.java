import java.rmi.Naming;
import java.util.Scanner;


public class EntradaUsuario  {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ---------------- Bienvenido a CheemsMart Online ---------------- ");
        System.out.println("Ingresa Usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingresa contraseña: ");
        String password = scanner.nextLine();
        acceder(username, password);

        miniMenu();
        int opcion = Integer.parseInt(scanner.nextLine()); 
        inputMiniMenu(opcion);
       
    }


    public static void acceder(String usuario, String contrasena){
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String acceder = cheems.acceder(usuario, contrasena);
            System.out.println(acceder);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void miniMenu(){
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String miniMenu = cheems.miniMenu();
            System.out.println(miniMenu);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void inputMiniMenu(int opcion){
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String miniMenu = cheems.inputMiniMenu(opcion);
            System.out.println(miniMenu);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
       
}

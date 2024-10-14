import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import productos.*;

import usuario.ListaUsuarios;
import usuario.Usuario;

public class ServidorCheemsMart extends UnicastRemoteObject implements CheemsMartRemote {

    private static final long serialVersionUID = 1L;
    Usuario usuario;
    String paisDescuento, paisUsuario;
    ListaUsuarios lista;
    Catalogo catalogo; 

    public ServidorCheemsMart() throws RemoteException{
        this.paisDescuento = crearDescuento();
        this.paisUsuario = null;
        this.catalogo = new Catalogo();
        this.lista = new ListaUsuarios();
        lista.registrar(new Usuario("paco", "1234", "Francisco", "1234567890", "Tapo", 123, "Mexico", 1));
        lista.registrar(new Usuario("jguns", "1234", "Jose", "1234567890", "Tapo", 123, "USA", 1));
    }


    public String hola(){
        return "Hola mundo";
    }

    public String acceder(String usuario, String contrasena){
        for (Usuario u : lista.listaUsuarios) {
            if(u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)){
                this.usuario = u;
                if(this.usuario.getPais().equals(this.paisDescuento)){
                    this.paisUsuario = this.usuario.getPais();
                }
                return "\nBienvenido " + this.usuario.getNombre() + "\n" + this.usuario.recibirNotificacion(lista.crearNotificacion(this.paisUsuario));
            }
        }
        return "Usuario y/o Contrasena incorrecto";
    }

    private String crearDescuento(){
        int r = (int) (Math.random()*3+1);
        System.out.println(r);
        switch (r) {
            case 1:
                return "Mexico";
            case 2:
                return "USA";
            case 3:
                return "Brasil";
            default:
                return "";
        }

        
    }   

    public String miniMenu(){
        return "Menú de CheemsMart: \n" +
                "1. Ver catálogo \n" + 
                "2. Realizar una compra \n" +
                "3. Salir";
    }

    public String inputMiniMenu(int opcion){
        switch (opcion) {
            case 1:
                this.catalogo.crearCatalogo(this.paisUsuario);
                return catalogo.getCatalogo();
            default:
                break;
        }
        return "";
    }

    





    public static void main(String[] args) {
        
        try {
            // Crear una instancia del servidor e iniciar el registro RMI
            CheemsMartRemote servidor = new ServidorCheemsMart();
            Naming.rebind("CheemsMartServidor", (ServidorCheemsMart) servidor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CheemsMartRemote extends Remote{
    
    String acceder(String usuario, String contrasena) throws RemoteException;

    String miniMenu() throws RemoteException;

    String verCatalogo() throws RemoteException;
    
    String agregarCarrito(int codigoBarras) throws RemoteException;

    String mensajeCarrito1() throws RemoteException;

    String verCarrito() throws RemoteException;

    boolean autentificacion(int nCuenta) throws RemoteException;

    String realizarCobro() throws RemoteException;

    String menuMensajes(int m) throws RemoteException;
}

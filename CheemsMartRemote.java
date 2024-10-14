import usuario.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CheemsMartRemote extends Remote{

    String hola() throws RemoteException ;
    
    String acceder(String usuario, String contrasena) throws RemoteException;

    String miniMenu() throws RemoteException;

    String inputMiniMenu(int opcion) throws RemoteException;
    
}

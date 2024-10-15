package usuario;

import java.util.ArrayList;
import java.util.Iterator;
public class ListaUsuarios implements GestionUsuarios{
    
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    /**
     * Metodo que reistra usuarios.
     * @param u Usuario por registrar.
     */
    public void registrar(Usuario u){
        listaUsuarios.add(u);
    }

    /**
     * Metodo que crear la notificacion del descuento.
     * @param pais Pais que recibira el descuento.
     * @return La notificacion que recibira el usuario.
     */
    public String crearNotificacion(String pais){
        if(pais == null){
            return "";
        }
        switch (pais) {
            case "Mexico":
                return "Por ser usuario de Mexico tienes descuento en electrodomesticos";
        
            case "Brasil":
                return "Por ser um usuário do Brasil, você tem desconto em alimentação";    
            
            case "USA":
                return "Because you are a user from the United States, you have a discount on electronics";
            
                default:
                return "";
        }
        
    }

    /**
     * Metodo que devuelve el iterador para recorrer la lista
     * @return Iterador para recorrer la lista de usuarios
     */
    public Iterator<Usuario> iterator(){
        return listaUsuarios.iterator();
    }
}

package usuario;

public interface GestionUsuarios {
    
    /**
     * Metodo que reistra usuarios.
     * @param u Usuario por registrar.
     */
    public void registrar(Usuario u);

    /**
     * Metodo que crear la notificacion del descuento.
     * @param pais Pais que recibira el descuento.
     * @return La notificacion que recibira el usuario.
     */
    public String crearNotificacion(String pais);
}

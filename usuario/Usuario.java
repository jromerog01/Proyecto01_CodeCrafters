package usuario;

public class Usuario implements Notificacion{

    private String usuario;
    private String contrasena;
    private String nombre;
    private String telefono;
    private String direccion;
    private int cuentaBancaria;
    private String pais;
    private int id;
    private double dinero;

    /**
     * Metodo constructor.
     * @param usuario Nombre de usuario.
     * @param contrasena Contrasena del usuario.
     * @param nombre Nombre del usuario.
     * @param telefono Telefono del usuario.
     * @param direccion Direccion de usuario.
     * @param cuentaBancaria Cuenta bancaria del usuario.
     * @param pais Pais del usuario.
     * @param id Identificador del usuario.
     */
    public Usuario(String usuario, String contrasena, String nombre, String telefono, String direccion,
                    int cuentaBancaria, String pais, int id){

        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        this.pais =pais;
        this.id = id;
        this.dinero = 30000;
    }

    /**
     * Metodo que devuelve el usuario.
     * @return Usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que devuelve la contrasena.
     * @return Contrasena.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo que devuelve la cuenta bancaria.
     * @return Cuenta Bancaria.
     */
    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Metodo que devuelve la direccion.
     * @return Direccion.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo que devuelve el ID.
     * @return ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que devuelve el nombre.
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devuelve el pais.
     * @return Pais.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Metodo que devuelve el numero de telefono.
     * @return Numero de telefono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que recibe notificacion.
     * @param notificacion
     */
    
    public String recibirNotificacion(String notificacion) {
        return notificacion;
    }

    /**
     * Metodo que devuelve el dinero del usuario
     */
    public double getDinero(){
        return dinero;
    }

    /**
     * Metodo que realiza el cobro de compra
     * @param gasto El total que va a gastar el usuario.
     */
    public void cobrar(double gasto){
        dinero = dinero - gasto;
    }
}

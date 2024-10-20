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
     * @param usuario Nombre de src.usuario.
     * @param contrasena Contrasena del src.usuario.
     * @param nombre Nombre del src.usuario.
     * @param telefono Telefono del src.usuario.
     * @param direccion Direccion de src.usuario.
     * @param cuentaBancaria Cuenta bancaria del src.usuario.
     * @param pais Pais del src.usuario.
     * @param id Identificador del src.usuario.
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
     * Metodo que devuelve el src.usuario.
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
     * Metodo que devuelve el dinero del src.usuario
     */
    public double getDinero(){
        return dinero;
    }

    /**
     * Metodo que realiza el cobro de compra
     * @param gasto El total que va a gastar el src.usuario.
     */
    public void cobrar(double gasto){
        dinero = dinero - gasto;
    }
}

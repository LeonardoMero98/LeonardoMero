public class Animales
{

    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------

    /**
     * Enumeradores para la categor�a del juego.
     */
    public enum Categoria
    {
        /**
         * Representa la categor�a rompecabezas.
         */
        Aves,

        /**
         * Representa la categor�a deportes.
         */
        Reptiles,

        /**
         * Representa la categor�a acci�n.
         */
        Mamiferos
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del juego.
     */
    private String nombre;

    /**
     * Categor�a del juego.
     */
    private Categoria categoria;

    /**
     * Precio del juego.
     */
    private int precio;

    /**
     * Tama�o en KB del juego.
     */
    private int vidapromedio;

    /**
     * Cantidad de licencias del juego que se tienen.
     */
    private int cantidaddisponible;

    /**
     * Cantidad de licencias que se han vendido.
     */
    private int cantidadVendidas;



    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo juego con los valores dados por par�metro. <br>
     * <b>post: </b> El nombre, la categor�a, el precio, el tama�o, la cantidad de licencias y la ruta de la imagen fueron inicializados <br>
     * con los valores dados por par�metro. La cantidad de licencias vendidas fue inicializada en 0.
     * @param pNombre Nombre del juego. pNombre != null && pNombre != "".
     * @param pCategoria Categor�a del juego. pCategoria == ROMPECABEZAS || pCategoria == DEPORTE || pCategoria == ACCION.
     * @param pPrecio Precio que tiene el juego. pPrecio > 0.


     */
    public Animales( String pNombre, Categoria pCategoria, int pPrecio, int pvidapromedio, int pCantidaddisponible)
    {
        nombre = pNombre;
        categoria = pCategoria;
        precio = pPrecio;
        vidapromedio = vidapromedio;
        cantidaddisponible = pCantidaddisponible;
        cantidadVendidas = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del juego.
     * @return Nombre del juego
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categor�a del juego.
     * @return Categor�a del juego.
     */
    public Categoria darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna el precio del juego.
     * @return Precio del juego.
     */
    public int darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el tama�o en KB del Juego.
     * @return Tama�o en KB del Juego.
     */
    public int darTamanio( )
    {
        return vidapromedio;
    }

    /**
     * Retorna la cantidad de licencias del juego.
     * @return Cantidad de licencias del juego.
     */
    public int darCantidadLicencias( )
    {
        return cantidaddisponible;
    }

    /**
     * Retorna la cantidad de licencias vendidas.
     * @return Cantidad de licencias vendidas.
     */
    public int darCantidadVendidas( )
    {
        return cantidadVendidas;
    }



    /**
     * Compra una cantidad dada de licencias. <br>
     * <b>post: </b> Se aument� la cantidad actual de licencias del juego en la cantidad dada.
     * @param pCantidad Cantidad de licencias que se quieren comprar. pCantidad > 0.
     */
    public void comprarLicencias( int pCantidad )
    {
        cantidaddisponible += pCantidad;
    }

    /**
     * Vende una cantidad dada de licencias, si cuenta con la cantidad suficiente. <br>
     * <b>post: </b> Disminuy� la cantidad actual de licencias del juego. <br>
     * Aument� la cantidad de licencias vendidas.
     * @param pCantidad Cantidad de licencias que se quieren vender. pCantidad > 0.
     * @return Retorna true si logra realizar la venta, false de lo contrario.
     */
    public boolean venderLicencias( int pCantidad )
    {
        boolean respuesta = false;
        if( cantidaddisponible >= pCantidad )
        {
            cantidaddisponible -= pCantidad;
            cantidadVendidas += pCantidad;
            respuesta = true;
        }
        return respuesta;
    }
}
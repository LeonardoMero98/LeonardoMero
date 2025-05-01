/**
 * Tienda virtual de juegos.
 */
public class Tienda
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa la cantidad mнnima de licencias de juegos de rompecabezas para la primera opciуn de descuento.
     */
    public final static int CANT_MIN_Aves = 25;

    /**
     * Representa la cantidad mнnima de licencias de juegos de deporte para la segunda opciуn de descuento.
     */
    public final static int CANT_MIN_Reptiles = 20;

    /**
     * Representa la cantidad mнnima de licencias de juegos de acciуn para la segunda opciуn de descuento.
     */
    public final static int CANT_MIN_Mamiferos = 12;

    /**
     * Representa el valor del primer descuento.
     */
    public final static double DESCUENTO_1 = 0.20;

    /**
     * Representa el valor del segundo descuento.
     */
    public final static double DESCUENTO_2 = 0.15;

    public final static double PORCENTAJE_MINIMO = 0.25;
    public final static int CANT_MIN_Reptiles_AVENTURA = 10;
    public final static int CANT_MIN_Mamiferos_VELOCIDAD = 15;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Juego 1 de la AppStore.
     */
    private Animales animal1;

    /**
     * Juego 2 de la AppStore.
     */
    private Animales animal2;

    /**
     * Juego 3 de la AppStore.
     */
    private Animales animal3;

    /**
     * Juego 4 de la AppStore.
     */
    private Animales animal4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la AppStore con sus 4 juegos. <br>
     * <b>post: </b> Los juegos fueron inicializados con los siguientes valores: <br>
     * Juego1 - Nombre: Candy Crush, Categorнa: Rompecabezas, Precio: 3000, Tamaсo (en KB): 300, Cantidad de licencias: 50. <br>
     * Juego2 - Nombre: Flow, Categorнa: Rompecabezas, Precio: 5500, Tamaсo (en KB): 250, Cantidad de licencias: 15 <br>
     * Juego3 - Nombre: FIFA, Categorнa: Deporte, Precio: 7500, Tamaсo (en KB): 850, Cantidad de licencias: 80 <br>
     * Juego4 - Nombre: Clash of Clans, Categorнa: Acciуn, Precio: 2000, Tamaсo (en KB): 1000, Cantidad de licencias: 36 <br>
     */
    public AppStore()
    {
        animal1 = new Animales("Cacatua Blanca", Animales.Categoria.Aves, 15, 300, 50);
        animal2 = new Animales("Boa Constrictor", Animales.Categoria.Reptiles, 10, 250, 15);
        animal3 = new Animales("Titi Dorado", Animales.Categoria.Mamiferos, 40, 850, 80);
        animal4 = new Animales("Guacamaya Roja", Animales.Categoria.Aves, 30, 1000, 36);
    }

    // -----------------------------------------------------------------
    // Mйtodos
    // -----------------------------------------------------------------

    /**
     * Retorna el juego 1.
     * @return Juego 1.
     */
    public Animales daranimal1()
    {
        return animal1;
    }

    /**
     * Retorna el juego 2.
     * @return Juego 2.
     */
    public Animales darJuego2()
    {
        return animal2;
    }

    /**
     * Retorna el juego 2.
     * @return Juego 3.
     */
    public Animales darJuego3()
    {
        return animal3;
    }

    /**
     * Retorna el juego 4.
     * @return Juego 4.
     */
    public Animales darJuego4()
    {
        return animal4;
    }

    /**
     * Busca un juego dado su nombre.
     * @param pNombreJuego Nombre del juego. pNombreJuego != null && pNombreJuego != "".
     * @return Juego con el nombre dado, null en caso de no encontrarlo.
     */
    public Animales buscarAnimales(String pNombreJuego)
    {
        Animales buscado = null;
        if(pNombreJuego.equals(animal1.darNombre()))
        {
            buscado = animal1;
        }
        else if(pNombreJuego.equals(animal2.darNombre()))
        {
            buscado = animal2;
        }
        else if(pNombreJuego.equals(animal3.darNombre()))
        {
            buscado = animal3;
        }
        else if(pNombreJuego.equals(animal4.darNombre()))
        {
            buscado = animal4;
        }

        return buscado;
    }

    /**
     * Registra la venta de licencias de un juego dado su nombre. <br>
     * <b>post: </b> Aumentу la cantidad de licencias vendidas del juego. <br>
     * Si la cantidad de juegos a vender era mayor que la cantidad de existencias del juego, la venta no se realizу.
     * @param pNombreJuego Nombre del juego a vender. pNombreJuego != null && pNombreJuego != "".
     * @param pCantidad Cantidad de licencias que se van a vender. pCantidad > 0.
     * @return Retorna true si logrу realizar la venta, false de lo contrario.
     */
    public boolean venderLicenciasJuego(String pNombreJuego, int pCantidad)
    {
        boolean respuesta = false;
        if(buscarAnimales(pNombreJuego) != null)
        {
            respuesta = buscarAnimales(pNombreJuego).venderLicencias(pCantidad);
        }
        return respuesta;
    }

    /**
     * Registra la compra de licencias de un juego dado su nombre. <br>
     * <b>post: </b> Aumentу la cantidad de licencias del juego.
     * @param pNombreJuego Nombre del juego a comprar. pNombreJuego != null && pNombreJuego != "".
     * @param pCantidad Cantidad de licencias que se van a comprar. pCantidad > 0.
     */
    public void comprarLicenciasJuego(String pNombreJuego, int pCantidad)
    {
        if(buscarAnimales(pNombreJuego) != null)
        {
            buscarJuego(pNombreJuego).comprarLicencias(pCantidad);
        }
    }

    /**
     * Retorna el nombre del juego con mбs unidades vendidas. <br>
     * En caso de que se haya vendido la misma cantidad de licencias para varios juegos y esta sea la mayor cantidad, se retorna el nombre del primero <br>
     * de los juegos que cumpla con la condiciуn.
     * @return Nombre del juego que ha vendido una mayor cantidad de licencias o "Ninguno" en caso en el que ningъn juego haya vendido licencias.
     */
    public String darJuegoMasVendido()
    {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;
        if(juego1.darCantidadVendidas() > cantidadMasVendida)
        {
            masVendido = juego1.darNombre();
            cantidadMasVendida = juego1.darCantidadVendidas();
        }
        if(juego2.darCantidadVendidas() > cantidadMasVendida)
        {
            masVendido = juego2.darNombre();
            cantidadMasVendida = juego2.darCantidadVendidas();
        }
        if(juego3.darCantidadVendidas() > cantidadMasVendida)
        {
            masVendido = juego3.darNombre();
            cantidadMasVendida = juego3.darCantidadVendidas();
        }
        if(juego4.darCantidadVendidas() > cantidadMasVendida)
        {
            masVendido = juego4.darNombre();
            cantidadMasVendida = juego4.darCantidadVendidas();
        }

        return masVendido;
    }

    /**
     * Retorna una cadena de texto con el descuento por ventas de juegos en volumen teniendo en cuenta las siguientes reglas: <br>
     * - Si se quieren comprar mнnimo 25 licencias de juegos de rompecabezas se darб un descuento del 20% sobre el valor total. <br>
     * - Si se quieren comprar al menos 20 licencias de juegos de deportes y 12 licencias de juegos de acciуn se darб un descuento del 15% sobre el valor total. <br>
     * Cuando en una venta se cumplen las dos condiciones anteriores, sуlo se aplica el primer descuento.
     * @param pCantidadLicenciasJuego1 Cantidad de licencias que se pretenden vender del juego1.
     * @param pCantidadLicenciasJuego2 Cantidad de licencias que se pretenden vender del juego2.
     * @param pCantidadLicenciasJuego3 Cantidad de licencias que se pretenden vender del juego3.
     * @param pCantidadLicenciasJuego4 Cantidad de licencias que se pretenden vender del juego4.
     * @return Cadena de texto que informa el precio total de las licencias de juego a vender antes del descuento, el valor del descuento y el precio final con el descuento.
     */
    public String calcularVentaPorVolumen(int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4)
    {
        int cantRompecab = 0;
        int cantDeporte = 0;
        int cantAccion = 0;

        switch(juego1.darCategoria())
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego1;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego1;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego1;
                break;
            }
        }
        switch(juego2.darCategoria())
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego2;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego2;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego2;
                break;
            }
        }
        switch(juego3.darCategoria())
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego3;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego3;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego3;
                break;
            }
        }
        switch(juego4.darCategoria())
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego4;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego4;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego4;
                break;
            }
        }

        double totalVenta = (juego1.darPrecio() * pCantidadLicenciasJuego1) + (juego2.darPrecio() * pCantidadLicenciasJuego2) + (juego3.darPrecio() * pCantidadLicenciasJuego3) + (juego4.darPrecio() * pCantidadLicenciasJuego4);
        double descuento = 0;

        if(cantRompecab >= CANT_MIN_ROMPECABEZAS)
        {
            descuento = totalVenta * DESCUENTO_1;
        }
        else if(cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION)
        {
            descuento = totalVenta * DESCUENTO_2;
        }
        else
        {
            descuento = 0;
        }

        double totalConDescuento = totalVenta - descuento;

        String mensaje = "El precio total de la venta serнa: $" + totalVenta + ".\n" + "El descuento serнa de: $" + descuento + "\n" + "El precio con descuento serнa: $" + totalConDescuento + ".";

        return mensaje;
    }

    public String darJuegoMenosVendido()
    {
        int cantidadMenosVendida = Integer.MAX_VALUE;
        String menosVendido = "NINGUNO";

        if (juego1.darCantidadVendidas() < cantidadMenosVendida)
        {
            cantidadMenosVendida = juego1.darCantidadVendidas();
            menosVendido = juego1.darNombre();
        }

        if (juego2.darCantidadVendidas() < cantidadMenosVendida)
        {
            cantidadMenosVendida = juego2.darCantidadVendidas();
            menosVendido = juego2.darNombre();
        }

        if (juego3.darCantidadVendidas() < cantidadMenosVendida)
        {
            cantidadMenosVendida = juego3.darCantidadVendidas();
            menosVendido = juego3.darNombre();
        }

        if (juego4.darCantidadVendidas() < cantidadMenosVendida)
        {
            cantidadMenosVendida = juego4.darCantidadVendidas();
            menosVendido = juego4.darNombre();
        }

        if (juego1.darCantidadVendidas() == juego2.darCantidadVendidas() &&
                juego2.darCantidadVendidas() == juego3.darCantidadVendidas() &&
                juego3.darCantidadVendidas() == juego4.darCantidadVendidas())
        {
            menosVendido = "NINGUNO";
        }

        return menosVendido;
    }

    public String darComprasPorPorentaje()
    {
        String juegoMenosVendido = darJuegoMenosVendido();
        String juegosAComprar = "";
        boolean hayJuegosAComprar = false;

        if (juegoMenosVendido.equals("NINGUNO"))
        {
            return "NINGUNO";
        }

        Juego juegoMenos = buscarJuego(juegoMenosVendido);
        int cantidadLimite = (int)(juegoMenos.darCantidadVendidas() * PORCENTAJE_MINIMO);

        if (juego1.darCantidadLicencias() < cantidadLimite)
        {
            juegosAComprar += juego1.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (juego2.darCantidadLicencias() < cantidadLimite)
        {
            juegosAComprar += juego2.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (juego3.darCantidadLicencias() < cantidadLimite)
        {
            juegosAComprar += juego3.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (juego4.darCantidadLicencias() < cantidadLimite)
        {
            juegosAComprar += juego4.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (!hayJuegosAComprar)
        {
            return "NINGUNO";
        }

        return juegosAComprar.trim();
    }

    public boolean seDebeComprarPorCategoria(String pNombreJuego)
    {
        Juego juego = buscarJuego(pNombreJuego);

        if (juego == null)
        {
            return false;
        }

        if (juego.darCategoria() == Juego.Categoria.DEPORTE &&
                juego.darCantidadLicencias() < CANT_MIN_DEPORTE_AVENTURA)
        {
            return true;
        }

        if (juego.darCategoria() == Juego.Categoria.ACCION &&
                juego.darCantidadLicencias() < CANT_MIN_ACCION_VELOCIDAD)
        {
            return true;
        }

        return false;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensiуn
    // -----------------------------------------------------------------

    /**
     * Mйtodo para la extensiуn 1.
     * @return Respuesta 1.
     */
    public String metodo1()
    {
        String juegosAComprar = darComprasPorPorentaje();

        if (juegosAComprar.equals("NINGUNO"))
        {
            return "No hay juegos para comprar según política porcentaje";
        }
        else
        {
            return "Juegos a comprar según política porcentaje: " + juegosAComprar;
        }
    }

    /**
     * Mйtodo para la extensiуn 2.
     * @return Respuesta 2.
     */
    public String metodo2()
    {
        String juegosAComprar = "";
        boolean hayJuegosAComprar = false;

        if (seDebeComprarPorCategoria(juego1.darNombre()))
        {
            juegosAComprar += juego1.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (seDebeComprarPorCategoria(juego2.darNombre()))
        {
            juegosAComprar += juego2.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (seDebeComprarPorCategoria(juego3.darNombre()))
        {
            juegosAComprar += juego3.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (seDebeComprarPorCategoria(juego4.darNombre()))
        {
            juegosAComprar += juego4.darNombre() + " ";
            hayJuegosAComprar = true;
        }

        if (!hayJuegosAComprar)
        {
            return "NINGUNO";
        }

        return juegosAComprar.trim();
    }
}
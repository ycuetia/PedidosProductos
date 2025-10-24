import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Pedido {
    private Cliente cliente;
    private Date fecha;
    private int numeroTarjetaCredito;
    private ArrayList<Producto> productos;
    private RegistrarPrototype registro;

    public Pedido(Cliente cliente, Date fecha, int numeroTarjetaCredito, RegistrarPrototype registro) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.registro = registro;
        this.productos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumeroTarjetaCredito(int numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    /**
     * Crea un producto a partir del registro y lo devuelve sin agregar al pedido.
     * Permite al cliente personalizar el producto antes de agregarlo.
     *
     * @param prototypeKey clave del prototipo registrado
     * @return Producto clonado o null si no existe el prototipo
     */
    public Producto crearProductoPrototype(int prototypeKey) {
        return registro.crear(prototypeKey);
    }

    /**
     * Crea un producto desde el registro y lo agrega a la lista de productos del pedido.
     *
     * @param prototypeKey clave del prototipo registrado
     * @return Producto clonado agregado al pedido o null si no existe
     */
    public Producto agregarProductoPrototype(int prototypeKey) {
        Producto p = crearProductoPrototype(prototypeKey);
        if (p != null) {
            productos.add(p);
        }
        return p;
    }

    /**
     * Devuelve la lista de productos del pedido.
     *
     * @return lista de productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

}

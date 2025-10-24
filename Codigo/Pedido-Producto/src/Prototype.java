


/**
 * Interfaz Prototype que declara el contrato de clonación.
 * Las implementaciones devuelven una copia independiente del producto.
 */
public interface Prototype {

    /**
     * Crea y devuelve una copia independiente del objeto.
     *
     * @return copia del prototipo como Producto
     */
    Producto clonePrototype();

}

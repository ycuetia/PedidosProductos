
/**
 * Producto es la clase base abstracta que actúa como prototipo.
 * Declara atributos comunes y obliga a implementar clonePrototype().
 */

public abstract class Producto implements Prototype {

    protected int numero;

    public Producto() { }

     /**
     * Constructor copia para uso interno por subclases.
     *
     * @param other Producto a copiar
     */
    protected Producto(Producto other) {
        this.numero = other.numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public abstract Producto clonePrototype();


}

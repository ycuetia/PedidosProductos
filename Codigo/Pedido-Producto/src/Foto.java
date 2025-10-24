/**
 * Representa una fotografía como Producto.
 */

public class Foto extends Producto {

    private String fichero;

    public Foto() { }

    public Foto(int numero, String fichero) {
        this.numero = numero;
        this.fichero = fichero;
    }

    protected Foto(Foto other) {
        super(other);
        this.fichero = other.fichero;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    /**
     * Simula la impresión de la foto.
     */
    public void print() {
        System.out.println("Imprimiendo fichero: " + fichero);
    }

    @Override
    public Foto clonePrototype() {
        return new Foto(this);
    }

}

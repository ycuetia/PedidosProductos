public class Camara extends Producto{

    private String marca;
    private String modelo;

    public Camara() { }

    public Camara(int numero, String marca, String modelo) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
    }

    protected Camara(Camara other) {
        super(other);
        this.marca = other.marca;
        this.modelo = other.modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public Camara clonePrototype() {
        return new Camara(this);
    }

}

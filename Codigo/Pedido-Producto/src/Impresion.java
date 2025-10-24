import java.util.ArrayList;
import java.util.List;

/**
 * Representa una impresión que puede contener múltiples fotos.
 * La clonación realiza copia profunda de la lista de fotos para evitar compartir referencias.
 */

public class Impresion extends Producto{

    private String color;
    private ArrayList<Foto> fotos;

   

    public Impresion() {
        this.fotos = new ArrayList<>(); 
    }

     /**
     * Constructor por defecto de Impresion.
     * Inicializa el objeto en un estado válido para su uso inmediato.
     * Su objetivo es preparar las estructuras internas necesarias (como la colección de fotos)
     * para que el resto de métodos pueda operar sin comprobaciones adicionales de nulidad.
     * Evita posibles NullPointerException al manipular la lista de fotos tras crear la instancia.
     */
    public Impresion(int numero, String color, List<Foto> fotos) {
        this.numero = numero;
        this.color = color;
        
    /**
     * Inicializa el campo 'fotos' asignándole una lista vacía.
     * Se crea una nueva instancia de ArrayList<> para que la colección sea mutable y comience vacía,
     * garantizando que operaciones como add(...) funcionen correctamente desde el inicio.
     */
        this.fotos = new ArrayList<>();
        if (fotos != null) {
            this.fotos.addAll(fotos);
        }
    }

    /**
     * Constructor copia que realiza clonación profunda de la lista de fotos.
     *
     * @param other Impresion a copiar
     */
    protected Impresion(Impresion other) {
        super(other);
        this.color = other.color;
        this.fotos = new ArrayList<>();
        if (other.fotos != null) {
            for (Foto f : other.fotos) {
                this.fotos.add(f != null ? f.clonePrototype() : null);
            }
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve la lista de fotos asociadas.
     * La lista retornada es la copia interna; si se requiere protección adicional devolver copia defensiva.
     *
     * @return lista de fotos
     */
    public List<Foto> fotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = new ArrayList<>();
        if (fotos != null) {
            this.fotos.addAll(fotos);
        }
    }

    /**
     * Agrega una foto a la impresión.
     *
     * @param foto Foto a agregar
     */
    public void addFoto(Foto foto) {
        if (this.fotos == null) this.fotos = new ArrayList<>();
        this.fotos.add(foto);
    }

    @Override
    public Impresion clonePrototype() {
        return new Impresion(this);
    }

}

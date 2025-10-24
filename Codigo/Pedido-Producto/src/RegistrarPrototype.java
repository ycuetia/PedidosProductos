import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistrarPrototype {

    private final Map<Integer, Producto> prototypes = new HashMap<>();

    /**
     * Registra un prototipo bajo una clave.
     *
     * @param key clave identificadora, no null
     * @param p prototipo, no null
     */
    public void registrar(int key, Producto p) {
        Objects.requireNonNull(key, "key no puede ser null");
        Objects.requireNonNull(p, "prototipo no puede ser null");
        prototypes.put(key, p);
    }

    /**
     * Crea (clona) un producto a partir del prototipo registrado con la clave.
     *
     * @param key clave del prototipo
     * @return clon del prototipo o null si no existe
     */
    public Producto crear(int key) {
        Producto proto = prototypes.get(key);
        return (proto != null) ? proto.clonePrototype() : null;
    }

    /**
     * Elimina un prototipo del registro.
     *
     * @param key clave a eliminar
     */
    public void remover(int key) {
        prototypes.remove(key);
    }

}

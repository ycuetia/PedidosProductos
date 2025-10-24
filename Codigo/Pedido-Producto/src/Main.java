import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Main simplificado (sin interacción de personalización).
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos del cliente
        System.out.print("Ingrese cédula del cliente: ");
        String cedula = sc.nextLine().trim();
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = sc.nextLine().trim();
        Cliente cliente = new Cliente(cedula, nombre);

        // Registrar prototipos
        RegistrarPrototype registrar = new RegistrarPrototype();

        Foto protoFoto = new Foto(1, "gato.jpg");
        registrar.registrar(01, protoFoto);

        Impresion protoImpresion = new Impresion(2, "Rojo",
                List.of(new Foto(101, "foto1.jpg"), new Foto(102, "foto2.jpg")));
        registrar.registrar(02, protoImpresion);

        Camara protoCamara = new Camara(3, "Nikon", "D3500");
        registrar.registrar(03, protoCamara);

        Pedido pedido = new Pedido(cliente, new Date(), 12345678, registrar);

        int opcion_salir = 0;

        System.out.println("\nCatálogo: foto-base | impresion-rojo | camara-nikon");

        do{
            System.out.print("\nClave del prototipo a agregar\n");
            System.out.println("01.Foto\n 02.Impresion\n 03.Camara\n");
            int clave = sc.nextInt();

            Producto clone = registrar.crear(clave); // devuelve el clone
            if (clone == null) {
                System.out.println("Clave no encontrada. Intente nuevamente.");
                continue;
            }

            // Mostrar evidencias de clonación
            System.out.println("\n--- Clonación realizada ---");
            //obtiene en tiempo de ejecución el objeto Class<?> que representa la clase real del objeto referenciado por clone
            System.out.println("Tipo: " + clone.getClass().getSimpleName());
            //- Se usan System.identityHashCode(...) para mostrar que los clones son instancias distintas al prototipo original.
            System.out.println("Hash del clone: " + System.identityHashCode(clone));

            // Añadir el clone directamente al pedido
            pedido.getProductos().add(clone);

             // Resumen del pedido
            System.out.println("\n--- Resumen del pedido ---");
            System.out.println("Cliente: " + pedido.getCliente());
            int idx = 1;

            /*
              En este bucle for-each recorre la lista de productos del pedido, imprime información general de cada producto (tipo, número, hash) 
              y luego, según el tipo concreto (Foto, Impresion, Camara), imprime detalles específicos. Dentro de Impresion hay otro bucle 
              que recorre sus Foto internas y las imprime.
             */
            for (Producto p : pedido.getProductos()) {

                System.out.println("Item " + (idx++) + " -> " + p.getClass().getSimpleName()
                        + ", numero: " + p.getNumero() + ", hash: " + System.identityHashCode(p));
                if (p instanceof Foto) {
                    System.out.println("   Fichero: " + ((Foto) p).getFichero());
                } else if (p instanceof Impresion) {
                    Impresion imp = (Impresion) p;
                    System.out.println("   Color: " + imp.getColor());
                    System.out.println("   Fotos:");
                    int j = 1;
                    for (Foto f : imp.fotos()) {
                        System.out.println("     [" + (j++) + "] " + f.getFichero()
                                + " (hash:" + System.identityHashCode(f) + ")");
                    }
                } else if (p instanceof Camara) {
                    Camara c = (Camara) p;
                    System.out.println("   Marca: " + c.getMarca() + ", Modelo: " + c.getModelo());
                }
            }

            System.out.println("Realizar otra clonacion ?\n 1.Si\n 2.No\n");
            opcion_salir = sc.nextInt();

        }while(opcion_salir == 1);

        sc.close();
    }
}

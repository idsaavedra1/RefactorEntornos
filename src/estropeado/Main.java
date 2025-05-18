package estropeado;

/**
 * Clase principal para probar la clase {@link Baraja}.
 *
 * @author TuNombre
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que crea una baraja, la mezcla, saca cartas y las devuelve,
     * mostrando la baraja en consola.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        Baraja baraja = Baraja.crearBarajaEspanola();

        System.out.println("Baraja original:");
        baraja.imprimir(false);

        baraja.mezclar(5);
        System.out.println("\nTras 5 mezclas:");
        baraja.imprimir(true);

        baraja.mezclar(40);
        System.out.println("\nTras 40 mezclas:");
        baraja.imprimir(false);

        System.out.println("\nSaco una carta y la devuelvo:");
        String carta = baraja.sacar();
        System.out.println("Carta sacada: " + carta);
        baraja.meter(carta);

        System.out.println("\nBaraja después de sacar y devolver:");
        baraja.imprimir(false);
    }
}

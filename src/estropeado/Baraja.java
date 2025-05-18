package estropeado;

import java.util.Random;

/**
 * Representa una baraja española de 48 cartas con métodos para barajar,
 * sacar cartas, devolverlas y mostrar la baraja.
 *
 * @author TuNombre
 * @version 1.0
 */
public class Baraja {

    private static final int NUM_CARTAS = 48;
    private static final int CARTAS_POR_PALO = 12;
    private static final String[] PALOS = {"Oros", "Copas", "Espadas", "Bastos"};

    private final String[] cartas = new String[NUM_CARTAS];
    private final Random random = new Random();

    /**
     * Constructor privado que inicializa la baraja con las 48 cartas.
     */
    private Baraja() {
        inicializarMazo();
    }

    /**
     * Crea y devuelve una nueva baraja española.
     *
     * @return una nueva instancia de {@link Baraja}
     */
    public static Baraja crearBarajaEspanola() {
        return new Baraja();
    }

    /**
     * Inicializa el mazo con todas las cartas de los cuatro palos.
     */
    private void inicializarMazo() {
        int indice = 0;
        for (String palo : PALOS) {
            for (int numero = 1; numero <= CARTAS_POR_PALO; numero++) {
                cartas[indice++] = crearNombreCarta(numero, palo);
            }
        }
    }

    /**
     * Crea el nombre de la carta según el número y el palo.
     *
     * @param numero el número de la carta (1-12)
     * @param palo el palo de la carta (Oros, Copas, Espadas, Bastos)
     * @return el nombre completo de la carta (por ejemplo, "Sota de Copas")
     */
    private String crearNombreCarta(int numero, String palo) {
        switch (numero) {
            case 10: return "Sota de " + palo;
            case 11: return "Caballo de " + palo;
            case 12: return "Rey de " + palo;
            default: return numero + " de " + palo;
        }
    }

    /**
     * Saca una carta de la baraja (la primera no nula).
     *
     * @return la carta sacada
     * @throws IllegalStateException si la baraja está vacía
     */
    public String sacar() {
        for (int i = 0; i < NUM_CARTAS; i++) {
            if (cartas[i] != null) {
                String carta = cartas[i];
                cartas[i] = null;
                return carta;
            }
        }
        throw new IllegalStateException("La baraja está vacía");
    }

    /**
     * Devuelve una carta a la baraja en la primera posición vacía.
     *
     * @param carta la carta a devolver
     * @throws IllegalStateException si la baraja está llena
     */
    public void meter(String carta) {
        for (int i = NUM_CARTAS - 1; i >= 0; i--) {
            if (cartas[i] == null) {
                cartas[i] = carta;
                return;
            }
        }
        throw new IllegalStateException("La baraja está llena");
    }

    /**
     * Comprueba si la baraja está vacía.
     *
     * @return {@code true} si no hay cartas en la baraja, {@code false} en caso contrario
     */
    public boolean estaVacia() {
        for (String carta : cartas) {
            if (carta != null) return false;
        }
        return true;
    }

    /**
     * Imprime la baraja por pantalla.
     *
     * @param alReves si es {@code true}, imprime la baraja desde el final hacia el principio
     */
    public void imprimir(boolean alReves) {
        if (estaVacia()) {
            System.out.println("La baraja está vacía\n");
            return;
        }

        if (alReves) {
            for (int i = NUM_CARTAS - 1; i >= 0; i--) {
                if (cartas[i] != null) {
                    System.out.print(cartas[i] + " | ");
                }
            }
        } else {
            for (int i = 0; i < NUM_CARTAS; i++) {
                if (cartas[i] != null) {
                    System.out.print(cartas[i] + " | ");
                }
            }
        }
        System.out.println();
    }

    /**
     * Mezcla la baraja realizando un número dado de intercambios aleatorios.
     *
     * @param movimientos número de movimientos o intercambios a realizar
     */
    public void mezclar(int movimientos) {
        for (int i = 0; i < movimientos; i++) {
            int a = random.nextInt(NUM_CARTAS);
            int b = random.nextInt(NUM_CARTAS);
            String temp = cartas[a];
            cartas[a] = cartas[b];
            cartas[b] = temp;
        }
    }
}

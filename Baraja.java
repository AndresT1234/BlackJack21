package upb.BlackJack21;

import edu.princeton.cs.algs4.StdOut;

public class Baraja {

    private LS_Black<Carta> cartas;
    private int siguienteCarta;

    public Baraja() {

    }

    public Baraja(LS_Black<Carta> cartas) {
        this.cartas = cartas;
    }

    public LS_Black<Carta> GetCartas() {
        return cartas;
    }

    public int GetSiguienteCarta() {
        return siguienteCarta;
    }

    // jjj
    public void barajar() {

        int randomIndice;
        Carta temporal;

        for (int i = 0; i < cartas.longitud(); i++) {
            randomIndice = (int) (Math.random() * (cartas.longitud() - i)) + i; // indice= i mas randon en ("52 - i")
            temporal = cartas.get(randomIndice); // temporal = tomar una carta de la posicion indice
            cartas.insertOtrasPosiciones(cartas.get(i), randomIndice);
            cartas.insertOtrasPosiciones(temporal, i);
        }
    }

    public Carta sacarCarta() {
        if (cartas != null && siguienteCarta < cartas.longitud()) {
            Carta cartaRetirada = cartas.get(siguienteCarta);
            cartas.removertOtrasPosiciones(siguienteCarta);

            siguienteCarta++;
            return cartaRetirada;
        }
        return null;

    }

    public static void main(String[] args) {

        // Crear una instancia de la clase Lista
        LS_Black<Carta> listaCartas = new LS_Black<Carta>();

        // Crear cartas y agregarlas a la lista
        String[] pintas = { "trébol", "diamante", "corazón", "espada" };
        String[] valores = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        for (String pinta : pintas) {
            for (String valor : valores) {
                listaCartas.addFinal(new Carta(pinta, valor));
            }
        }

        // se crea baraja
        Baraja baraja = new Baraja(listaCartas);

        System.out.println("\nCartas antes de barajar:\n");
        for (Carta carta : baraja.GetCartas()) {
            System.out.println(carta.toString());
        }

        // provando el get
        System.out.println("\ncarta tomada fue");
        System.out.println(listaCartas.get(0));

        // probando el longitud
        System.out.println("\nla longitud de la lista es");
        System.out.println(listaCartas.longitud());

        // se revuelve la baraja
        baraja.barajar();
        StdOut.println("\nlas cartas barajadas son");
        int contar = 0;
        for (Carta carta : baraja.GetCartas()) {
            System.out.println("carta #" + contar + " ---> " + carta.toString());
            contar++;
        }
        System.out.println("\n");

        System.out.println("vamos a eliminar cartas de nuestra lista, esto simulara el retiro de carta\n");
        System.out.println("la carta 1 retirada de la baraja  fue: " + baraja.sacarCarta());
        System.out.println("la carta 2 retirada de la baraja fue: " + baraja.sacarCarta());
        System.out.println("la carta 3 retirada de la baraja fue: " + baraja.sacarCarta());
        System.out.println("la carta 4 retirada de la baraja fue: " + baraja.sacarCarta());
        System.out.println("la carta 5 retirada de la baraja fue: " + baraja.sacarCarta());
        System.out.println("la carta 6 retirada de la baraja fue: " + baraja.sacarCarta());

        System.out.println("\n");

        int numero = 0;

        for (Carta carta : baraja.GetCartas()) {
            System.out.println("carta #" + numero + " ---> " + carta.toString());
            numero++;
        }

        // probando el longitud
        System.out.println("\nla longitud de la lista es");
        System.out.println(listaCartas.longitud());

    }

}

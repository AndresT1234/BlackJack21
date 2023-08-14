package upb.Taller1_Black;

import java.util.Random;

public class Baraja {

    private LS_Black<Carta> cartas;
    private int siguienteCarta;

    public Baraja(LS_Black<Carta> cartas, int siguienteCarta) {
        this.cartas = cartas;
        this.siguienteCarta = siguienteCarta;
    }
//.. 
    public LS_Black<Carta> GetCartas() {
        return cartas;
    }

    public int GetSiguienteCarta() {
        return siguienteCarta;
    }

    public void barajar() {
        Random random = new Random();
        for (int i = 1; i <= cartas.longitud(); i++) {
            int randomIndice = i + random.nextInt(cartas.longitud() - i); // indice= i mas randon en ("52 - i")
            Carta temporal = cartas.get(randomIndice); // temporal = tomar una carta de la posicion indice
            cartas.insertOtrasPosiciones(cartas.get(i), randomIndice);
            cartas.removertOtrasPosiciones(randomIndice + 1);
            cartas.insertOtrasPosiciones(temporal, i);
        }
    }

    // public Carta sacarCarta() {
    //
    // }

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
        Baraja baraja = new Baraja(listaCartas, 0);

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

        System.out.println("\nlas cartas barajadas son");

        for (Carta carta : baraja.GetCartas()) {

            System.out.println(carta.toString());
        }

    }
}
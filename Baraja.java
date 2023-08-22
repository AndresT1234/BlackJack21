package upb.BlackJack21;

import edu.princeton.cs.algs4.StdOut;

//ADT Baraja
public class Baraja {

    // VALOR ADT
    private String[] pintas = { "trébol", "diamante", "corazon", "espada" };
    private String[] valores = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private LS_Black<Carta> cartas;
    private int siguienteCarta;

    // CONSTRUCTOR ADT
    public Baraja() {
        this.cartas = inicializarBaraja();
    }

    // ASESORES
    public LS_Black<Carta> GetCartas() {
        return cartas;
    }

    public int GetSiguienteCarta() {
        return siguienteCarta;
    }

    // INICIALIZADOR
    public LS_Black<Carta> inicializarBaraja() {

        LS_Black<Carta> listaCartas = new LS_Black<Carta>();
        // Crear cartas y agregarlas a la lista
        for (String pinta : pintas) {
            for (String valor : valores) {
                listaCartas.addFinal(new Carta(pinta, valor));
            }
        }
        return listaCartas;
    }

    // APIS
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

    //Override
    @Override
    public String toString(){
        String resultado = null;
            for (Carta carta : this.GetCartas()) {
            resultado = carta.toString();
        }
        return resultado;
    }

    // MAIN EJECUCION ADT

    public static void main(String[] args) {

        // se crea baraja y al llamar mi metodo se inicializa
        Baraja baraja = new Baraja();

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

        System.out.println("\n");

        // ver si si se eliminaron mis cartas de la baraja actual
        int numero = 0;
        for (Carta carta : baraja.GetCartas()) {
            System.out.println("carta #" + numero + " ---> " + carta.toString());
            numero++;
        }

        // ASSERTS
        Carta carta1 = new Carta("corazon", "As");
        Carta carta2 = new Carta("trébol", "2");
        Carta carta3 = new Carta("diamante", "As");

        assert carta1.toString().equals("As de corazon");
        assert carta1.equals(new Carta("corazon", "As"));
        assert !carta1.equals(carta2);
        assert carta1.equals(carta3); // Debería ser true debido a la sobrecarga de equals() en Carta

    }

}

package upb.BlackJack21;

public class Mano {

    private LS_Black<Carta> cartica;

    public Mano() {
        this.cartica = new LS_Black<>();
    }

    public LS_Black<Carta> GetCartas() {
        return cartica;
    }

    public void agregarCarta(Carta carta) {
        cartica.addFinal(carta);
    }

    public int operacionValor() {
        // contadores
        int total = 0; // Num || Letra
        int Contador = 0; // As
        // recorro cada carta en mi lista cartica
        for (Carta carta : cartica) {
            String valor = carta.GetValor();
            // Se verifica el valor de la carta
            if (valor.equals("As")) {
                Contador++;
                total += 11;
            } else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
                total += 10;
            } else {
                total += Integer.parseInt(valor);
            }
        }

        // ciclo para garantizar toma de decision entre 1 y 11
        while (Contador > 0 && total > 21) {
            total -= 10; // disminuye mi totalizador
            Contador--; // Disminuye el contador de Ases
        }

        return total;
    }

    public static void main(String[] args) {

        Mano Mano1 = new Mano();

        // Agregar cartas a la mano
        Mano1.agregarCarta(new Carta("As"));
        Mano1.agregarCarta(new Carta("5"));
        Mano1.agregarCarta(new Carta("3"));
        Mano1.agregarCarta(new Carta("8"));

        // Calcular el valor de la mano
        int valorMano = Mano1.operacionValor();

        // Valor de la mano
        System.out.println("Valor de la mano: " + valorMano);
    }

}
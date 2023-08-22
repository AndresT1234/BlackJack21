package upb.BlackJack21;

import edu.princeton.cs.algs4.StdOut;

//ADT MANO
public class Mano {

    // VALOR DEL ADT
    private LS_Black<Carta> cartica;
    private byte numJugador;
    private boolean pasar;

    // CONTRUCTOR
    public Mano() {
        this.cartica = new LS_Black<>();
        this.numJugador = 0;
        this.pasar = false;
    }

    // CONSTRUCTOR CON SOBRECARGA
    public Mano(byte numJugador) {
        this.cartica = new LS_Black<>();
        this.numJugador = numJugador;
        this.pasar = false;
    }

    // ASESORES
    public LS_Black<Carta> GetCartas() {
        return cartica;
    }

    public byte getNum() {
        return numJugador;
    }

    public boolean getPasa() {
        return pasar;
    }

    public void pasa(boolean pasa) {
        pasar = pasa;
    }

    // APIS
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


    // MAIN PRUEBAS

    @Override
    public boolean equals(Object mano){
        if(mano == null) return false;
        if(!(mano instanceof Mano)) return false;
        Mano ManoEqls = (Mano) mano;
        if(this.operacionValor()==ManoEqls.operacionValor())return true;
        return false;
    }




    public static void main(String[] args) {

        Mano mano1 = new Mano();

        // Agregar cartas a la mano
        mano1.agregarCarta(new Carta("As"));
        mano1.agregarCarta(new Carta("5"));
        mano1.agregarCarta(new Carta("3"));
        mano1.agregarCarta(new Carta("8"));

        // Calcular el valor de la mano
        int valorMano = mano1.operacionValor();

        // Valor de la mano
        StdOut.println("Valor de la mano: " + valorMano);

        // Prueba del método getPasa() y pasa()
        assert !mano1.getPasa();
        mano1.pasa(true);
        assert mano1.getPasa();

        // Prueba de agregarCarta()
        Mano mano2 = new Mano((byte) 2);
        assert mano2.GetCartas().longitud() == 0;
        mano2.agregarCarta(new Carta("10"));
        assert mano2.GetCartas().longitud() == 1;

        // Prueba de operacionValor()
        Mano mano3 = new Mano((byte) 3);
        mano3.agregarCarta(new Carta("As"));
        mano3.agregarCarta(new Carta("K"));
        int valorMano3 = mano3.operacionValor();
        assert valorMano3 == 21; // As vale 11 en esta combinación

        Mano mano4 = new Mano((byte) 4);
        mano4.agregarCarta(new Carta("As"));
        mano4.agregarCarta(new Carta("8"));
        mano4.agregarCarta(new Carta("10"));
        int valorMano4 = mano4.operacionValor();
        assert valorMano4 == 19; // As vale 1 en esta combinación

        Mano mano5 = new Mano((byte) 5);
        mano5.agregarCarta(new Carta("2"));
        mano5.agregarCarta(new Carta("3"));
        mano5.agregarCarta(new Carta("5"));
        int valorMano5 = mano5.operacionValor();
        assert valorMano5 == 10; // Suma de valores numéricos

        StdOut.println("Pruebas completadas.");
    }

}
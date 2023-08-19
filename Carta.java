package upb.BlackJack21;

import edu.princeton.cs.algs4.StdOut;

//ADT Carta
public class Carta {

    private String pinta;
    private String valor;

    public Carta() {
        pinta = null;
        valor = null;
    }

    public Carta(String pinta, String valor) {
        this.pinta = pinta;
        this.valor = valor;
    }

    public Carta(String valor) {
        this.valor = valor;
    }

    public String GetPinta() {
        return pinta;
    }

    public String GetValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "La Carta es " + GetValor() + " De " + GetPinta();
    }

    public static void main(String[] args) {

        Carta cartica = new Carta("trebol", "5");

        StdOut.println(cartica.toString());

    }
}

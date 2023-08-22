package upb.BlackJack21;

import edu.princeton.cs.algs4.StdOut;

//ADT Carta
public class Carta {

    // VALOR DEL ADT
    private String pinta;
    private String valor;

    // CONSTRUCTOR DEL ADT
    public Carta() {
        pinta = null;
        valor = null;

    }

    // CONTRUCTOR CON SOBRECARGA DEL ADT
    public Carta(String pinta, String valor) {
        this.pinta = pinta;
        this.valor = valor;
    }

    public Carta(String valor) {
        this.valor = valor;
    }

    // ASESORES
    public String GetPinta() {
        return pinta;
    }

    public String GetValor() {
        return valor;
    }

    // SOBREESCRITURA
    @Override
    public String toString() {
        return "La Carta es " + GetValor() + " De " + GetPinta();
    }

    @Override
    public boolean equals(Object nuevito) {
        if (nuevito == null)
            return false;
        if (!(nuevito instanceof Carta))
            return false;

        Carta carta = (Carta) nuevito;
        if (carta.GetPinta() == this.GetPinta() && carta.GetValor() == this.GetValor())
            return true;
        return false;
    }

    public static void main(String[] args) {

        // se crean 3 cartas
        Carta carta1 = new Carta("corazon", "As");
        Carta carta2 = new Carta("trébol", "2");
        Carta carta3 = new Carta("diamante", "As");

        // Prueba del método toString()
        StdOut.println(carta1.toString()); // Debería imprimir: La Carta es As De corazon

        // Prueba del método equals()
        boolean sonIguales1 = carta1.equals(carta2); // Debería ser false
        boolean sonIguales2 = carta1.equals(carta3); // Debería ser false
        boolean sonIguales3 = carta1.equals(new Carta("corazon", "As")); // Debería ser true

        // se realiza pruebas
        StdOut.println("¿Carta1 y Carta2 son iguales? " + sonIguales1);
        StdOut.println("¿Carta1 y Carta3 son iguales? " + sonIguales2);
        StdOut.println("¿Carta1 y otra Carta con mismo valor y pinta son iguales? " + sonIguales3);

        // assert
        assert (!carta1.equals(carta2));// negacion
        assert (carta1.equals(new Carta("corazon", "As"))); // true

    }
}

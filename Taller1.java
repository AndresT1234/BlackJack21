package upb.BlackJack21;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Taller1 {

    public static void main(String[] args) {

        StdOut.println("\nPorfavor ingrese los jugadores a participar\n");
        int jugadores = StdIn.readByte();

        if (jugadores > 0 && jugadores < 10) {

            boolean TodosPasan = false;

            while (!TodosPasan) {

                for (int i = 1; i <= jugadores; i++) {

                }
            }

        } else {
            StdOut.println(
                    "cantidad de jugadores no permitido, por favor ingrese jugadores en un rango de 1 a 9 jugadores");
        }

    }
}
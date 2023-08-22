package upb.BlackJack21;

import edu.princeton.cs.algs4.StdIn;

import edu.princeton.cs.algs4.StdOut;

public class Taller1 {

    public static void main(String[] args) {

        StdOut.println("\n----------------BLACKJACK 21----------------\n");
        StdOut.println("\nPOR FAVOR INGRESE LA CANTIDAD DE JUGADORES\n");

        int jugadores = StdIn.readByte();

        if (jugadores > 1 && jugadores < 8) {

            Baraja barajita = new Baraja();
            barajita.barajar();

            LS_Black<Mano> manitos = new LS_Black<>();
            for (byte i = 1; i <= jugadores; i++) {
                Mano manita = new Mano(i);
                manitos.addFinal(manita);
            }

            byte pide;
            Carta card = new Carta();
            byte todosPasan = 0;
            byte ronda = 1;

            StdOut.println("\nRONDA NUMERO:    " + ronda + "\n");
            for (Mano manolo : manitos) {

                StdOut.println("\nEL JUGADOR NUMERO : " + manolo.getNum() + "\nOBTUVO: ");
                for (int i = 0; i < 2; i++) {
                    card = barajita.sacarCarta();
                    manolo.agregarCarta(card);
                    StdOut.println(card.toString() + "");
                }
            }

            boolean juegoTerminado = false;
            int recordGanador = 0;
            Mano JugadorGAnador = null;

            while (!juegoTerminado) {
                ronda++;
                todosPasan = 0;
                StdOut.println("\nRONDA NUMERO:    " + ronda);

                for (Mano manolo : manitos) {
                    if(!manolo.getPasa()){
                    StdOut.println("\nTurno del Jugador " + manolo.getNum() + ":");
                    StdOut.println("PARA PEDIR INGRESE EL NUMERO 1, PARA PASAR INGRESE EL NUMERO 0");
                    boolean verifica = false;

                    do {
                        pide = StdIn.readByte();
                        if (pide == 1 || pide == 0)
                            verifica = true;
                        else
                            StdOut.println("Ingresa una opcion valida");
                    } while (!verifica);

                    if (pide == 1 && !manolo.getPasa()) {
                        card = barajita.sacarCarta();
                        manolo.agregarCarta(card);
                        StdOut.println("El jugador: " + manolo.getNum() + "\nObtuvo:" + card.toString());
                    } else
                        todosPasan++;
                        manolo.pasa(true);
                    }
                }

                for (Mano manolo : manitos) {
                    if (manolo.operacionValor() == 21) {
                        juegoTerminado = true;
                        recordGanador = 21;
                        JugadorGAnador = manolo;
                        break;
                    }
                }

                if (todosPasan == jugadores)
                    juegoTerminado = true;
            }

            Mano[] arreglito = new Mano[jugadores];
            byte count = 0;
            int mayor = 0;
            Mano actual;

            for (Mano manolo : manitos) {
                arreglito[count] = manolo;
                count++;
            }

            for (int i = 0; i < arreglito.length; i++) {
                actual = arreglito[i];
                if (actual.operacionValor() > mayor && actual.operacionValor() <= 21) {
                    mayor = actual.operacionValor();
                }
            }

            actual = null;
            byte empatado = 0;
            LS_Black<Mano> winners = new LS_Black<Mano>();

            for (int j = 0; j < arreglito.length; j++) {
                actual = arreglito[j];
                if (actual.operacionValor() == mayor) {
                    winners.addFinal(actual);
                    empatado++;
                }
            }

            if (JugadorGAnador != null) { // jugador con 21 cartas gana directamente
                StdOut.println("\nEl ganador por 21 cartas directo fue:\n");
                StdOut.println("    El jugador #: " + JugadorGAnador.getNum() +
                        " con puntaje: " + recordGanador + "\n");
            }

            if (empatado > 1) { // empate
                StdOut.println("\nEMPATE: Los ganadores fueron :");
                for (Mano manita : winners) {
                    StdOut.println("El jugador #:" + manita.getNum() + " con puntaje: " + manita.operacionValor());
                }

            } else { // un solo ganador
                for (Mano manita2 : winners) {
                    StdOut.println(
                            "\nEl ganador fue:" + "\n" + "\n" + "    El jugador #: " + manita2.getNum()
                                    + " con puntaje: " + manita2.operacionValor() +
                                    "\n");
                }
            }

            // Pruebas con assert
            assert JugadorGAnador != null;
            assert JugadorGAnador.operacionValor() == 21;

            assert empatado > 1;
            assert winners.longitud() == empatado;

            StdOut.println("Pruebas completadas.");

        } else {
            StdOut.println(
                    "cantidad de jugadores no permitido, por favor ingrese jugadores en un rango de 1 a 7 jugadores");

        }

    }
}

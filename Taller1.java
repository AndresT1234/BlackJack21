package upb.BlackJack21;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Taller1 {

    public static void main(String[] args) {

        StdOut.println("\nPorfavor ingrese los jugadores a participar\n");
        int jugadores = StdIn.readByte();

        Baraja barajita = new Baraja();

        barajita.barajar();

        LS_Black<Mano> manitos = new LS_Black<>();      

        for(byte i = 0; i < jugadores;i++){
            Mano manita = new Mano();
            manitos.addFinal(manita);
        }

        StdOut.println(manitos.longitud());
        if (jugadores > 0 && jugadores < 7) {

            byte todosPasan = 0;
            byte ronda = 0;

            while (todosPasan < jugadores) {
                ronda++;
                StdOut.println("RONDA NUMERO:    " + ronda);
                todosPasan = 0;
                int pide;
                for (Mano manolo:manitos){
                    StdOut.println("Para pedir ingrese 1 para pasar ingrese 0");
                    pide  = StdIn.readInt();
                    if(pide == 1 ){
                        manolo.agregarCarta(barajita.sacarCarta());
                    }
                    else todosPasan++;

                }
            }
            byte count = 1;
            int valor = 0;
            int ganador = 0;
            int mayor = 0;
            for (Mano manolo:manitos){
                valor = manolo.operacionValor();
                StdOut.println("La mano numero " + count + " Obtuvo:" + valor + " Puntos");
                if(valor > mayor){
                    mayor = valor;
                    ganador = count;
                } 
                count++;     
            }                                              

            StdOut.println("El ganador fue el jugador #: " + ganador);


    

        } else {
            StdOut.println(
                    "cantidad de jugadores no permitido, por favor ingrese jugadores en un rango de 1 a 7 jugadores");
        }

    }
}
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
        if (jugadores > 0 && jugadores < 8) {

            byte todosPasan = 0;
            byte ronda = 1;
            StdOut.println("RONDA NUMERO:    " + ronda+"\n");
            for (Mano manolo:manitos){
                    manolo.agregarCarta(barajita.sacarCarta());
                    manolo.agregarCarta(barajita.sacarCarta());
            }
            while (todosPasan < jugadores) {
                boolean verifica = false;
                int pide ;
                todosPasan = 0;
                ronda++;
                StdOut.println("RONDA NUMERO:    " + ronda+"\n");
                for (Mano manolo:manitos){
                    StdOut.println("Para pedir ingrese 1 para pasar ingrese 0");
                    do{
                        pide  = StdIn.readInt();
                        if(pide == 1 || pide == 0) verifica = true;
                        else StdOut.println("Ingresa una opcion valida");

                    }while(!verifica);
                    
                    if(pide == 1 ){
                        manolo.agregarCarta(barajita.sacarCarta());
                    }
                    else todosPasan++;

                }
            }
            byte count = 0;
            int[] arreglito = new int[jugadores];
            for (Mano manolo:manitos){
                arreglito[count] = manolo.operacionValor();
                count++;  
            }
            int max = 0;
            boolean empate = false;

            for (int value : arreglito) {
            if(value == 21) 
            if (value > max) {
                max = value;
                empate = false;
            } else if (value == max) {
                empate = true;
            }
        }

        if (empate) {
            System.out.println("Hay empate en el valor máximo: " + max);
        } else {
            System.out.println("El valor máximo es: " + max);
        }                                            

    

        } else {
            StdOut.println(
                    "cantidad de jugadores no permitido, por favor ingrese jugadores en un rango de 1 a 7 jugadores");
        }

    }
}
package upb.BlackJack21;

import java.util.List;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Taller1 {

    public static void main(String[] args) {

        StdOut.println("\nPorfavor ingrese los jugadores a participar\n");
        int jugadores = StdIn.readByte();

        Baraja barajita = new Baraja();

        barajita.barajar();

        LS_Black<Mano> manitos = new LS_Black<>();      

        for(byte i = 1; i <= jugadores;i++){
            Mano manita = new Mano(i);
            manitos.addFinal(manita);
        }

        if (jugadores > 0 && jugadores < 8) {

            Carta card = new Carta();
            byte todosPasan = 0;
            byte ronda = 1;
            StdOut.println("RONDA NUMERO:    " + ronda+"\n");
            for (Mano manolo:manitos){
                StdOut.println("EL JUGADOR NUMERO : "+ manolo.getNum()+" OBTUVO: \n");
                    card = barajita.sacarCarta();
                    manolo.agregarCarta(card);
                    StdOut.println(card.toString()+"\n");
                    card = barajita.sacarCarta();
                    manolo.agregarCarta(card);
                    StdOut.println(card.toString()+"\n");

            }
            while (todosPasan < jugadores) {
                boolean verifica = false;
                int pide ;
                ronda++;
                StdOut.println("RONDA NUMERO:    " + ronda+"\n");
                for (Mano manolo:manitos){
                    if(!manolo.getPasa()){
                    StdOut.println("Para pedir ingrese 1 para pasar ingrese 0");
                    do{
                        pide  = StdIn.readByte();
                        if(pide == 1 || pide == 0) verifica = true;
                        else StdOut.println("Ingresa una opcion valida");

                    }while(!verifica);
                    
                    if(pide == 1 && manolo.operacionValor() <=21 ){
                        card = barajita.sacarCarta();
                        manolo.agregarCarta(card);
                        StdOut.println("\n"+card.toString()+"\n");
                    }
                    else {
                        todosPasan++;
                        manolo.pasa(true);
                    }
                }

                }
            }
            byte count = 0;
            Mano[] arreglito = new Mano[jugadores];
            for (Mano manolo:manitos){
                arreglito[count] = manolo;;
                count++;  
            }
            count = 0;
            int mayor = 0;
            Mano actual;
            for (int i=0;i<arreglito.length;i++){
                actual = arreglito[i];
                if(actual.operacionValor()>mayor && actual.operacionValor()<= 21){
                    mayor = actual.operacionValor();
                }

            }
            boolean empate = false;
            actual = null;
            LS_Black<Mano> winners = new LS_Black<Mano>();
            for(int j=0;j<arreglito.length;j++){
                actual = arreglito[j];
                if(actual.operacionValor() == mayor){
                    winners.addFinal(actual);
                    count++;
                }
                if(count > 1) empate = true;
            }

            if(empate){
                StdOut.println("Los ganadores fueron:");
                for(Mano manita: winners){
                    StdOut.println("El jugador numero:"+manita.getNum()+" con puntaje: "+ manita.operacionValor());
                }

            }
            else  {
                for(Mano manita2 : winners){
                    StdOut.println("\nEl ganador fue:"+"\n"+"\n"+"    El jugador numero: "+manita2.getNum()+" con puntaje: "+ manita2.operacionValor()+
                    "\n");
                }
            }

                                  

    

        } else {
            StdOut.println(
                    "cantidad de jugadores no permitido, por favor ingrese jugadores en un rango de 1 a 7 jugadores");
        }

    }
}
package upb.BlackJack21;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

// Estructura de ListaSimple
public class LS_Black<Item> implements Iterable<Item> {

    // Clase interna Nodo
    public class Nodo {
        Item item;
        Nodo siguiente;
    }

    // para emanuel
    Nodo primero; // Lista vacia ->Nula veneco

    void addPrimero(Item i) {
        Nodo temporal = new Nodo();
        temporal.item = i;
        temporal.siguiente = primero; // el temporal nuevo que estamos creando
        primero = temporal;
    }

    void delPrimero() {
        if (primero == null)
            return;
        primero = primero.siguiente;
    }

    void addFinal(Item i) {
        Nodo temporal = new Nodo();
        temporal.item = i;
        if (primero == null) {
            addPrimero(i);
            return;
        }
        Nodo last = null;
        for (last = primero; last.siguiente != null; last = last.siguiente)
            ;
        last.siguiente = temporal;
    }

    void delFinal() {
        if (primero == null)
            return;
        if (primero.siguiente == null) {
            primero = null;
            return;
        }
        Nodo prev = null;
        for (prev = primero; prev.siguiente.siguiente != null; prev = prev.siguiente)
            ;
        prev.siguiente = null;
    }

    void insertOtrasPosiciones(Item nuevo, int posicion) {
        if (posicion < 0 || primero == null) {
            addPrimero(nuevo); // agregamos al principio si se cumple esta condicion
            return;
        }

        Nodo actual = primero; // ponemos nuestro primero como el actual
        Nodo previo = null;

        // recorremos nuestra lista hasta llegar a la posicion deseada que es donde
        // vamos a poner nuestro nodo
        for (int i = 0; i < posicion && actual != null; i++) {
            previo = actual;
            actual = actual.siguiente; // ponemos nuestro siguiente como el actual
        }

        if (actual == null) {
            addFinal(nuevo);
        } // Si la posición sale del rango superior de la lista, la
          // agregamos al final}
        else {
            Nodo temporal = new Nodo(); // creamos un nuevo nodito
            temporal.item = nuevo; // le asignamos el valor del nuevo item a nuestro nodo
            // aplicamos la conexion con nuestro nodo temporal
            temporal.siguiente = actual.siguiente; // error en siguiente
            if (posicion > 0)
                previo.siguiente = temporal;
        }
    }

    void removertOtrasPosiciones(int posicion) {
        if (posicion < 0 || primero == null) {
            return;// No se puede remover si esta en null
        }

        if (posicion == 0) {
            delPrimero();
            return;
        }

        Nodo actual = primero;
        Nodo previo = null;

        for (int i = 0; i < posicion && actual != null; i++) {
            previo = actual;
            actual = actual.siguiente; // buscamos la posicion a eliminar
        }

        if (actual == null) {
            return;// no hay nada que remover
        }
        if (posicion > 0)
            previo.siguiente = actual.siguiente;
    }

    public int longitud() {

        int contador = 0;
        Nodo concurrido = primero;

        while (concurrido != null) {
            concurrido = concurrido.siguiente;
            contador++;
        }

        return contador;
    }

    public Carta get(int i) {

        if (i < 0 || i >= longitud()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista");
        }

        Nodo concurrido = primero;
        for (int j = 0; j < i; j++) {
            concurrido = concurrido.siguiente;
        }

        return  (Carta)concurrido.item;

    }

    // sobreescritura
    @Override
    public Iterator<Item> iterator() {
        return new IteradorLS_Black();
    }

    // Implementacion del iterador para la lista simple
    private class IteradorLS_Black implements Iterator<Item> {

        private Nodo pos = primero;

        @Override
        public boolean hasNext() {
            return pos != null;
        }

        @Override
        public Item next() {
            Item i = pos.item;
            pos = pos.siguiente;
            return i;
        }

    }

    public static void main(String[] args) {

        LS_Black<String> lista = new LS_Black<String>(); // Crear una instancia de la clase Lista

        lista.addPrimero("3");// o
        lista.addPrimero("2");
        lista.addPrimero("1");// --->en la siguiente inserteme 4
        lista.addFinal("6");
        lista.addFinal("7");// 4
        lista.addFinal("7");
        lista.addFinal("8");

        System.out.println("\nLista original:");
        for (String x : lista) {
            StdOut.println(x);
        }

        lista.delPrimero();
        System.out.println("\nDespués de eliminar el primero:");
        for (String x : lista) {
            StdOut.println(x);
        }

        lista.delFinal();
        System.out.println("\nDespués de eliminar el último:");
        for (String x : lista) {
            StdOut.println(x);
        }

        lista.insertOtrasPosiciones("5", 2);
        System.out.println("\nDespués de insertar en posiciones intermedias:");
        for (String x : lista) {
            StdOut.println(x);
        }

        lista.removertOtrasPosiciones(2);
        System.out.println("\nDespués de remover en posición intermedia:");
        for (String x : lista) {
            StdOut.println(x);
        }

    }

}

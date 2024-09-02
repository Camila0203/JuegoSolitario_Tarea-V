package com.tuempresa.solitario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Juego {
    protected List<Stack<Carta>> pilasTablero;
    protected Stack<Carta> mazo;

    public Juego() {
        pilasTablero = new ArrayList<>();
        mazo = new Stack<>();
        inicializarJuego();
    }

    protected void inicializarJuego() {
        List<Carta> baraja = crearBaraja();
        Collections.shuffle(baraja);

        for (int i = 0; i < 7; i++) {
            Stack<Carta> pila = new Stack<>();
            for (int j = 0; j <= i; j++) {
                pila.push(baraja.remove(baraja.size() - 1));
            }
            pilasTablero.add(pila);
        }

        while (!baraja.isEmpty()) {
            mazo.push(baraja.remove(baraja.size() - 1));
        }
    }

    protected List<Carta> crearBaraja() {
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] simbolos = {"Corazones", "Espadas", "Trébol", "Diamante"};
        List<Carta> baraja = new ArrayList<>();

        for (String simbolo : simbolos) {
            for (String valor : valores) {
                baraja.add(new Carta(valor, simbolo));
            }
        }

        return baraja;
    }

    public boolean moverCarta(int pilaOrigen, int pilaDestino) {
        if (pilaOrigen < 0 || pilaDestino < 0 || pilaOrigen >= pilasTablero.size() || pilaDestino >= pilasTablero.size()) {
            return false;
        }

        Stack<Carta> origen = pilasTablero.get(pilaOrigen);
        Stack<Carta> destino = pilasTablero.get(pilaDestino);

        if (origen.isEmpty()) {
            return false;
        }

        Carta carta = origen.peek();
        if (destino.isEmpty() || (destino.peek().getValorNumerico() == carta.getValorNumerico() + 1
                && !destino.peek().getSimbolo().equals(carta.getSimbolo()))) {
            destino.push(origen.pop());
            return true;
        }

        return false;
    }

    public boolean esPilaCompleta(int pilaIndex) {
        Stack<Carta> pila = pilasTablero.get(pilaIndex);
        if (pila.size() != 13) return false;

        for (int i = 1; i <= 13; i++) {
            Carta carta = pila.get(pila.size() - i);
            if (carta.getValorNumerico() != i || !carta.getSimbolo().equals(pila.get(0).getSimbolo())) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTablero() {
        for (int i = 0; i < pilasTablero.size(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilasTablero.get(i));
        }
        System.out.println("Mazo: " + mazo.size() + " cartas restantes.");
    }
}

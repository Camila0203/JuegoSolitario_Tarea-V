package com.tuempresa.solitario;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void agregarCartaAMano(Carta carta) {
        mano.add(carta);
    }

    public void mostrarMano() {
        System.out.println(nombre + " tiene en mano: " + mano);
    }
}


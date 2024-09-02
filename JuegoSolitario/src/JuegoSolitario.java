package com.tuempresa.solitario;
public class JuegoSolitario  {
    public static void main(String[] args) {

                Juego solitario = new Juego();
                solitario.mostrarTablero();

                // Ejemplo de cómo mover una carta
                boolean movido = solitario.moverCarta(0, 1);
                System.out.println("Carta movida: " + movido);

                solitario.mostrarTablero();
            }
        }
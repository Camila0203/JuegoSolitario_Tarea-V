package com.tuempresa.solitario;

public class Carta {
    private String valor;
    private String simbolo;

    public Carta(String valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }

    public String getValor() {
        return valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getValorNumerico() {
        switch (valor) {
            case "As": return 1;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default: return Integer.parseInt(valor);
        }
    }

    @Override
    public String toString() {
        return valor + " de " + simbolo;
    }
}

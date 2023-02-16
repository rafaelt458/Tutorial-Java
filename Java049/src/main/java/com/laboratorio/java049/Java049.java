package com.laboratorio.java049;

public class Java049 {

    public static void main(String[] args) {
        Jugador jug1;
        final int estado;
        
        jug1 = new Jugador("Pedro");
        
        jug1.setNivel(2);
        
        jug1.mostrarJugador();
        
        estado = 5;
    }
}
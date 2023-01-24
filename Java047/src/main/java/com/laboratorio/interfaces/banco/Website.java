package com.laboratorio.interfaces.banco;

public class Website implements ServiciosBanco {
    @Override
    public void consultarSaldo() {
        System.out.println("Consulta de saldo desde el Website");
    }

    @Override
    public void ultimosMovimientos() {
        System.out.println("Ultimos movimientos desde el Website");
    }

    @Override
    public void transferirSaldo() {
        System.out.println("Transferir saldo desde el Website");
    }   
}

package com.laboratorio.interfaces.banco;

public class CajeroAutomatico implements ServiciosBanco {

    @Override
    public void consultarSaldo() {
        System.out.println("Consulta de saldo desde el cajero");
    }

    @Override
    public void ultimosMovimientos() {
        System.out.println("Ultimos movimientos desde el cajero");
    }

    @Override
    public void transferirSaldo() {
        System.out.println("Transferir saldo desde el cajero");
    }   
}
package com.laboratorio.interfaces.banco;

public class AtencionTelefonica implements ServiciosBanco {
    @Override
    public void consultarSaldo() {
        System.out.println("Consulta de saldo desde el teléfono");
    }

    @Override
    public void ultimosMovimientos() {
        System.out.println("Ultimos movimientos desde el teléfono");
    }

    @Override
    public void transferirSaldo() {
        System.out.println("Transferir saldo desde el teléfono");
    }   
}

package com.laboratorio.java046;

import com.laboratorio.java046.empleados.Carpintero;
import com.laboratorio.java046.empleados.Electricista;
import com.laboratorio.java046.empleados.Empleado;
import com.laboratorio.java046.empleados.Fontanero;
import com.laboratorio.java046.empleados.Mecanico;

public class Salarios {
    
    public static void main(String[] args) {
        Empleado plantilla[] = new Empleado[10];
        
        plantilla[0] = new Carpintero();
        plantilla[1] = new Mecanico();
        plantilla[2] = new Electricista();
        plantilla[3] = new Electricista();
        plantilla[4] = new Fontanero();
        plantilla[5] = new Fontanero();
        plantilla[6] = new Carpintero();
        plantilla[7] = new Mecanico();
        plantilla[8] = new Electricista();
        plantilla[9] = new Fontanero();
        
        int i;
        double promedio = 0;
        
        for (i=0; i<10; i++) {
            promedio += plantilla[i].salario();
        }
        
        promedio = promedio / 10;
        
        System.out.println("El salario promedio es: " + promedio);
        
    }
}

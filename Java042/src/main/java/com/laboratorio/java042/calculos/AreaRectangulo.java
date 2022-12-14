package com.laboratorio.java042.calculos;

/**
 *
 * @author Rafael
 */
public class AreaRectangulo {
    private double base;
    private double altura;
    private double area;

    public AreaRectangulo() {
    }

    public AreaRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }
    
    private void calcular() {
        area = base * altura;
    }
    
    public void mostrar() {
        calcular();
        System.out.println("El area del rectágulo es: " + area);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Triangulo extends FiguraBidimensional {

    private double a;
    private double b;
    private double c;
    
    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public double calcularPerimetro() {
        return a+b+c;
    }

    @Override
    public double calcularArea() {
        double s = calcularPerimetro()/2;
        return Math.sqrt(s*(s - a)*(s - b)*(s - c));
    }
    
}

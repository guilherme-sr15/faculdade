/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Retangulo extends FiguraBidimensional {

    private double b;
    private double h;
    
    public Retangulo(double b, double h) {
        this.b = b;
        this.h = h;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2*b + 2*h;
    }

    @Override
    public double calcularArea() {
        return b*h;
    }
    
}

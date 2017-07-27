/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Esfera extends FiguraTridimensional {

    private double raio;
    
    public Esfera(double raio) {
        this.raio = raio;
    }
    
    @Override
    public double calcularVolume() {
        return 4*Math.PI*Math.pow(raio,3)/3;
    }

    @Override
    public double calcularArea() {
        return 4*Math.PI*Math.pow(raio,2);
    }
    
}

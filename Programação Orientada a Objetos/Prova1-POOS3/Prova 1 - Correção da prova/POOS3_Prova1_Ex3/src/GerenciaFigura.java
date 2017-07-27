/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class GerenciaFigura {
    
    public void imprimirArea(Figura figura) {
        System.out.println(figura.calcularArea());
    }
    
    public void imprimirPerimetro(FiguraBidimensional figura) {
        System.out.println(figura.calcularPerimetro());
    }
    
    public void imprimirVolume(FiguraTridimensional figura) {
        System.out.println(figura.calcularVolume());
    }
}

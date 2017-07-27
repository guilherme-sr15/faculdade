/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Principal {

    public static void main(String[] args) {
        FiguraBidimensional retangulo = new Retangulo(2,4);
        FiguraTridimensional esfera = new Esfera(5.0);
        
        GerenciaFigura gerencia = new GerenciaFigura();

        gerencia.imprimirArea(retangulo);
        gerencia.imprimirArea(esfera);
        gerencia.imprimirPerimetro(retangulo);
        gerencia.imprimirVolume(esfera);
    }
    
}

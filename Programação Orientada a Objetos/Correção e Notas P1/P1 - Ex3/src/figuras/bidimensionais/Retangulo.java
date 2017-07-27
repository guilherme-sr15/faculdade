package br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.bidimensionais;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Retangulo extends DuasDimensoes {
    private double lado1;
    private double lado2;
    
    public Retangulo(double lado1, double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    @Override
    public double calculaArea(){
        return lado1*lado2;
    }
    
    @Override
    public double calculaPerimetro(){
        return ((lado1*2) + (lado2*2));
    }    
    
}

package br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.bidimensionais;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Triangulo extends DuasDimensoes{
    private double ladoA;
    private double ladoB;
    private double ladoC;
    
    public Triangulo(double ladoA, double ladoB, double ladoC){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }
    
    @Override
    public double calculaArea(){
        double s = calculaPerimetro() / 2;
        return Math.sqrt(s * (s-ladoA) * (s-ladoB) * (s-ladoC));
    }
    
    @Override
    public double calculaPerimetro(){
        return ladoA + ladoB + ladoC;
    }

}

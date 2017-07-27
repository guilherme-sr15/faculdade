package br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.tridimensionais;


import br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.FiguraGeometrica;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Esfera extends TresDimensoes{
    private double raio;
    
    public Esfera(double raio){
        this.raio = raio;
    }
    
    @Override
    public double calculaArea(){
        return (4* FiguraGeometrica.PI *(raio*raio));
    }
    
    @Override
    public double calculaVolume(){
        return (4* FiguraGeometrica.PI * (Math.pow(3, raio))); //Erro aqui (-0,2)
    }
    

}

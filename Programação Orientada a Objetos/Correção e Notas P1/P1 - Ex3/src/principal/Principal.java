package br.edu.ifsp.arq.ads.poos3.p1.ex3.principal;


import br.edu.ifsp.arq.ads.poos3.p1.ex3.gerenciamento.GerenciaFigura;
import br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.bidimensionais.Retangulo;
import br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.tridimensionais.Esfera;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        
        GerenciaFigura gf = new GerenciaFigura();
        
        Retangulo r = new Retangulo(2, 3);
        Esfera e = new Esfera(4);        
        
        gf.exibirArea(r);
        gf.exibirArea(e);
        gf.exibirPerimetro(r);
        gf.exibirVolume(e);
    }
}

package br.edu.ifsp.arq.ads.poos3.p1.ex3.gerenciamento;


import br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.bidimensionais.DuasDimensoes;
import br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.tridimensionais.TresDimensoes;
import br.edu.ifsp.arq.ads.poos3.p1.ex3.figuras.FiguraGeometrica;
import javax.swing.JOptionPane;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaFigura {
    
    public void exibirArea(FiguraGeometrica f){
        JOptionPane.showMessageDialog(null,"A área da figura é " + f.calculaArea());
    }
    
    public void exibirPerimetro(DuasDimensoes f){
        JOptionPane.showMessageDialog(null, "O perímetro da figura é " + f.calculaPerimetro());
    }
    
    public void exibirVolume(TresDimensoes f){
        JOptionPane.showMessageDialog(null, "O volume da figura é " + f.calculaVolume());
    }
}

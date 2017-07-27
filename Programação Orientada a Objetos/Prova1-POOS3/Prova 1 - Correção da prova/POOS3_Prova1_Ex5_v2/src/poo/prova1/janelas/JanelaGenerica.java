/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.prova1.janelas;

import javax.swing.JFrame;
import poo.prova1.paineis.PainelAbstrato;

/**
 *
 * @author denis
 */
public class JanelaGenerica extends JanelaAbstrata {
    
    private PainelAbstrato painel;
    
    public JanelaGenerica(String titulo, PainelAbstrato painel) {
        super(titulo);
        this.painel = painel;
    }
    
    @Override
    public void criarComponentes() {
        add(painel);
        painel.criarComponentes();
    }
   
    @Override
    protected void ajustarPropriedades() {
        super.ajustarPropriedades();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
   
}

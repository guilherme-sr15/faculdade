/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import javax.swing.JFrame;

/**
 *
 * @author Aluno
 */
public class JanelaGenerica extends JanelaAbstrata{
    private PainelAbstrato painel;
    
    public JanelaGenerica(PainelAbstrato painel){
        super("inserir",true,true,true,true);
        this.painel = painel;
        this.painel.criarComponentes();
        add(painel);
        this.ajustarComponentes();
    }

    @Override
    protected void ajustarComponentes() {
        super.ajustarComponentes();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
        
}

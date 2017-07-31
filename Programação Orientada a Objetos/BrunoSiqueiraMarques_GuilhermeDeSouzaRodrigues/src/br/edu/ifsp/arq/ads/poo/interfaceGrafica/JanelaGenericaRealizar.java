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
public class JanelaGenericaRealizar extends JanelaAbstrata{
    private PainelAbstrato painel;
    
    public JanelaGenericaRealizar(PainelAbstrato painel){
        super("realizar",true,true,true,true);
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

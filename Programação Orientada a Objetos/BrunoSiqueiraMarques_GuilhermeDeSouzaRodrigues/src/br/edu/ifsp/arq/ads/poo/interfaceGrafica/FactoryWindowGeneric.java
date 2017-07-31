/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

/**
 *
 * @author Bruno Siqueira
 */
public class FactoryWindowGeneric {

    public JanelaAbstrata getWindow(String window, PainelAbstrato painel) {
        if ("inserir".equalsIgnoreCase(window)) {
            return new JanelaGenericaInserir(painel);
        }else{
            return new JanelaGenericaRealizar(painel);
        }
        //return null;
    }
}

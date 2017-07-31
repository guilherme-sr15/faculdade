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
public class PanelRevistas extends PanelInsercaoObra{

    @Override
    public void criarComponentes() {
        super.criarComponentes(); 
        this.getLbEspecificidade1().setText("Nome da área:");
    }
    
}

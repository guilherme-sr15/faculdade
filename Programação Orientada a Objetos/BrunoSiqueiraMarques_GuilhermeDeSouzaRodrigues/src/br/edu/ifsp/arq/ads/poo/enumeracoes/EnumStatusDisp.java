/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.enumeracoes;

/**
 *
 * @author Bruno Siqueira
 */
public enum EnumStatusDisp {
    EMPRESTADO(0),
    DISPONIVEL(1);
    
    private int cod;
    
    EnumStatusDisp(int cod){
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }    
}

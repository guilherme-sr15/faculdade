package br.edu.ifsp.arq.ads.poo.enumeracoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno Siqueira
 */
public enum EnumStatusAluno {
    MATRICULADO(0),
    NAO_MATRICULADO(1);
    
    private int cod;
    
    EnumStatusAluno(int cod){
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }
}

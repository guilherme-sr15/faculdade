package br.edu.ifsp.arq.ads.poo.entidades;

import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumTitulacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Siqueira
 */
public class Professor extends Usuarios {

    private final int codigo;
    private EnumTitulacao titulacao;

    public Professor(String nome, String rg, int codigo, EnumTitulacao titulacao) {
        super(nome, rg);
        this.codigo = codigo;
        this.titulacao = titulacao;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the titulacao
     */
    public EnumTitulacao getTitulacao() {
        return titulacao;
    }
}

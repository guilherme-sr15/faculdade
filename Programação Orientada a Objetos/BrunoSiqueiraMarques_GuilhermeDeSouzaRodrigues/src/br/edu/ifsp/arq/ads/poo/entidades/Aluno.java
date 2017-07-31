package br.edu.ifsp.arq.ads.poo.entidades;

import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusAluno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Siqueira
 */
public class Aluno extends Usuarios {

    private final String codigo;
    private EnumStatusAluno status;

    public Aluno(String codigo, EnumStatusAluno status, String nome, String rg) {
        super(nome, rg);
        this.codigo = codigo;
        this.status = status;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the status
     */
    public EnumStatusAluno getStatus() {
        return status;
    }
}

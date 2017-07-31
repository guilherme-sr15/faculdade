/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

/**
 *
 * @author Bruno Siqueira
 */
public class EmprestimoProfessor extends Emprestimo {

    private final int nroMaxExemplares = 5;

    public EmprestimoProfessor(Usuarios usuario) {
        super(15, usuario);
    }

    @Override
    public boolean emprestimo(int idObra, int nroExemplar) {
        return acaoEmprestimo(idObra, nroExemplar);
    }

    @Override
    public int nrMaxExemplares() {
        return this.nroMaxExemplares;
    }
}

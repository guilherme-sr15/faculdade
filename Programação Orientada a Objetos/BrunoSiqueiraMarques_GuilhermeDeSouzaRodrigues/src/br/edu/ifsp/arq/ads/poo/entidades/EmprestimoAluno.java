/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Calendar;
import java.util.List;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusAluno;

/**
 *
 * @author Bruno Siqueira
 */
public class EmprestimoAluno extends Emprestimo {

    private final int nroMaxExemplares = 3;

    public EmprestimoAluno(Usuarios usuario) {
        super(10, usuario);
    }

    @Override
    public boolean emprestimo(int idObra, int nroExemplar) {
        Calendar dataAtual = Calendar.getInstance();
        
        if (!verificarAtrasosNosEmprestimos(dataAtual)) {
            Aluno aluno = (Aluno) this.getUsuario();

            if (aluno.getStatus() == EnumStatusAluno.MATRICULADO) {
                if (acaoEmprestimo(idObra, nroExemplar)) {
                    return true;
                }

            }
        }
        return false;
    }
    
    @Override
    public int nrMaxExemplares() {
        return this.nroMaxExemplares;
    }
}

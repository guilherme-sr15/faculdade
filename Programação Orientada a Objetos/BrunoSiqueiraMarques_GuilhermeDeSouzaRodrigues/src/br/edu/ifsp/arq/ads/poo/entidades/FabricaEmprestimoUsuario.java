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
public class FabricaEmprestimoUsuario {
    public Emprestimo getEmprestimo(Usuarios usuario){
        if(usuario instanceof Aluno){
            return new EmprestimoAluno(usuario);
        }
        else if(usuario instanceof Professor){
            return new EmprestimoProfessor(usuario);
        }
        return null;
    }    
}

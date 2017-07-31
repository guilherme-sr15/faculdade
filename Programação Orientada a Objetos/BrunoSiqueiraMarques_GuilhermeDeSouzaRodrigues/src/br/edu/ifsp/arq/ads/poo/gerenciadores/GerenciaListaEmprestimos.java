package br.edu.ifsp.arq.ads.poo.gerenciadores;


import java.util.ArrayList;
import java.util.List;
import br.edu.ifsp.arq.ads.poo.entidades.Emprestimo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Siqueira
 */
public class GerenciaListaEmprestimos {

    /**
     * @return the listaEmprestimos
     */
    public List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    private List<Emprestimo> listaEmprestimos;

    public GerenciaListaEmprestimos() {
        listaEmprestimos = new ArrayList<>();
    }
    
    public boolean add(Emprestimo emprestimo){
        if(emprestimo!=null){
            return getListaEmprestimos().add(emprestimo);
        }
        return false;
    }

}

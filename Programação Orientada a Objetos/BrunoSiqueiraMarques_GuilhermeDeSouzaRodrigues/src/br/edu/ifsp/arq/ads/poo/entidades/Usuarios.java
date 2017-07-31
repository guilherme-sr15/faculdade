package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Objects;
import br.edu.ifsp.arq.ads.poo.entidades.Emprestimo;
import br.edu.ifsp.arq.ads.poo.gerenciadores.GerenciaListaEmprestimos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Siqueira
 */
public abstract class Usuarios {

    private String nome;
    private final GerenciaListaEmprestimos emprestimos;
    private final String rg;

    public Usuarios(String nome, String rg) {
        this.nome = nome;
        this.rg = rg;
        emprestimos = new GerenciaListaEmprestimos();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.rg);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (getClass() == obj.getClass()) {
            return false;
        }
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the emprestimos
     */
    public GerenciaListaEmprestimos getEmprestimos() {
        return emprestimos;
    }
    
    public boolean add(Emprestimo e){
        return emprestimos.add(e);
    }

    @Override
    public String toString() {
        return "Usuarios{" + "nome=" + nome + ", emprestimos=" + emprestimos + ", rg=" + rg + '}';
    }
    
}

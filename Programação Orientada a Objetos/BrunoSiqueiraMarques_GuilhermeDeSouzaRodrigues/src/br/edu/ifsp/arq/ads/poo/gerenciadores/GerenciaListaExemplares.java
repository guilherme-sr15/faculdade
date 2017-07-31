/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.gerenciadores;

import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusDisp;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Bruno Siqueira
 */
public class GerenciaListaExemplares {

    /**
     * @return the listaExemplares
     */
    public Set<Exemplar> getListaExemplares() {
        return listaExemplares;
    }

    private final Set<Exemplar> listaExemplares;

    public GerenciaListaExemplares() {
        listaExemplares = new TreeSet<>();
    }

    public int getTamanhoLista() {
        return getListaExemplares().size();
    }

    public int getExemplaresDisponiveis() {
        int qtd = 0;
        for (Exemplar exemplar : getListaExemplares()) {
            if (exemplar.getStatus() == EnumStatusDisp.DISPONIVEL) {
                qtd++;
            }
        }
        return qtd;
    }

    public boolean addExemplar(Exemplar e) {
        if (e != null) {
            return getListaExemplares().add(e);
        }
        return false;
    }
    
    public Exemplar busca(int codigo){
        for (Exemplar exemplar : getListaExemplares()) {
            if(exemplar.getCodigo()==codigo){
                return exemplar;
            }
        }
        return null;
    }
    
    public boolean remove(Object obj){
        return listaExemplares.remove(obj);
    }

    @Override
    public String toString() {
        return "Lista de exemplares:" + listaExemplares;
    }
    
}

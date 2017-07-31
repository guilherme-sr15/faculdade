/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.gerenciadores;

import java.util.HashSet;
import java.util.Set;
import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.entidades.Obras;

/**
 *
 * @author Bruno Siqueira
 */
public class GerenciaExemplaresEmprestimo {
    private final Set<Exemplar> listaExemplaresUsuario;

    public GerenciaExemplaresEmprestimo() {
        listaExemplaresUsuario = new HashSet<>();
    }
    
    public boolean add(Exemplar exemplar){
        if(exemplar!=null){
            return listaExemplaresUsuario.add(exemplar);
        }
        return false;
    }
    
    public boolean remove(int idObra){
        for (Exemplar exemplares : getListaObrasUsuario()) {
            if(idObra == exemplares.getCodigo()){
                return listaExemplaresUsuario.remove(exemplares);
            }
        }
        return false;
    }
    
    public boolean remove(Object obj){
        return listaExemplaresUsuario.remove(obj);
    }
    
    public Exemplar busca(int codigo) {
        for (Exemplar exemplar : listaExemplaresUsuario) {
            if (exemplar.getCodigo() == codigo) {
                return exemplar;
            }
        }
        return null;
    }
    

    /**
     * @return the listaExemplaresUsuario
     */
    public Set<Exemplar> getListaObrasUsuario() {
        return listaExemplaresUsuario;
    }

    @Override
    public String toString() {
        return "GerenciaObrasEmprestimo{" + "listaObrasUsuario=" + listaExemplaresUsuario + '}';
    }
    
}

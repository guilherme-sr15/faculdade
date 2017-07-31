/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.bancos;

import br.edu.ifsp.arq.ads.poo.entidades.Obras;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bruno Siqueira
 */
public class BancoObrasBiblioteca {

    private final Set<Obras> listaObras;
    private static BancoObrasBiblioteca gerenciaListaObras;

    private BancoObrasBiblioteca() {
        listaObras = new HashSet<>();
    }

    public static BancoObrasBiblioteca getInstance() {
        if (gerenciaListaObras == null) { //se gerenciaAluno for nula, significa que não criamos ainda uma instância
            gerenciaListaObras = new BancoObrasBiblioteca();
        }
        return gerenciaListaObras; //apenas retornamos a referência para a instância já criada
    }

    public boolean add(Obras o) {
        if (o!=null) {
            return getListaObras().add(o);
        }
        return false;
    }
    
    public Obras busca(int idObra){
        for (Obras obra : getListaObras()) {
            if(obra.getCodigo()==idObra){
                return obra;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "BancoObrasBiblioteca\n" + "listaObras:\n" + getListaObras();
    }

    /**
     * @return the listaObras
     */
    public Set<Obras> getListaObras() {
        return listaObras;
    }
    
    
}

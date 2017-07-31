/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.gerenciadores;

import java.util.HashSet;
import java.util.Set;
import br.edu.ifsp.arq.ads.poo.entidades.Obras;

/**
 *
 * @author Bruno Siqueira
 */
public class GerenciaObrasEmprestimo {
    private final Set<Obras> listaObrasUsuario;

    public GerenciaObrasEmprestimo() {
        listaObrasUsuario = new HashSet<>();
    }
    
    public boolean add(Obras obra){
        if(obra!=null){
            return listaObrasUsuario.add(obra);
        }
        return false;
    }
    
    public boolean remove(int idObra){
        for (Obras obras : getListaObrasUsuario()) {
            if(idObra == obras.getCodigo()){
                return listaObrasUsuario.remove(obras);
            }
        }
        return false;
    }
    
    public boolean remove(Object obj){
        return listaObrasUsuario.remove(obj);
    }

    /**
     * @return the listaObrasUsuario
     */
    public Set<Obras> getListaObrasUsuario() {
        return listaObrasUsuario;
    }

    @Override
    public String toString() {
        return "GerenciaObrasEmprestimo{" + "listaObrasUsuario=" + listaObrasUsuario + '}';
    }
    
}

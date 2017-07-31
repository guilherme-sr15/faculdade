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
public class FabricaObras {
    public Obras getObra(Obras o){
        if(o instanceof Livros){
            return new Livros(o.getTitulo(), ((Livros) o).getIsbn());
        }
        else if(o instanceof Revistas){
            return new Revistas(o.getTitulo(),((Revistas) o).getNomeDaArea());
        }
        return null;
    }
}

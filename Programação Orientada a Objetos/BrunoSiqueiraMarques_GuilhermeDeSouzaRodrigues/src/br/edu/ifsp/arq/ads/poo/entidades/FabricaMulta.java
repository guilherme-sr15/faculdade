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
public class FabricaMulta {
    public Multa getMulta(Obras o){
        if(o instanceof Livros){
            return new MultaLivro();
        }
        else if(o instanceof Revistas){
            return new MultaRevista();
        }
        return null;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Objects;

/**
 *
 * @author Bruno Siqueira
 */
public class Revistas extends Obras{

    /**
     * @return the nomeDaArea
     */
    public String getNomeDaArea() {
        return nomeDaArea;
    }
    private String nomeDaArea;

    public Revistas(String nome,String nomeDaArea) {
        super(nome,"Revista");
        this.nomeDaArea = nomeDaArea;
    } 
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 15 * hash + Objects.hashCode(this.getTitulo());
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Revistas other = (Revistas) obj;
        if (!this.getTitulo().equals(other.getTitulo())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Revista: %s \n Area:%s",super.toString(),this.nomeDaArea);
    }
    
}

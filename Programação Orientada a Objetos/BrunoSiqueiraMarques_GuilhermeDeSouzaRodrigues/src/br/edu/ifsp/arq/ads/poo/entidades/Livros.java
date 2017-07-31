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
public class Livros extends Obras{
    private final int isbn;

    public Livros(String nome,int isbn) {
        super(nome,"Livro");
        this.isbn = isbn;
    }
    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.isbn;
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
        final Livros other = (Livros) obj;
        if (this.isbn != other.isbn) {
            return false;
        }
        return true;
    }
    
}

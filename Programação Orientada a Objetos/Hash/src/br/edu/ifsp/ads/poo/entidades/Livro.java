
package br.edu.ifsp.ads.poo.entidades;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Livro implements Comparable<Livro>{
    
    //// ATRIBUTOS ////
    
    private String titulo;
    private long ISBN;
    private Integer edicao;
    
    //// CONSTRUTOR ////
    
    public Livro(String titulo, long ISBN, Integer edicao){
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.edicao = edicao;
    }
    
    //// MÉTODOS ////
    
    @Override
    public String toString() {
        return String.format("Título: %s,ISBN: %d,Edição : %d%n", this.titulo, this.ISBN, this.edicao);
    }
    
    @Override
    public int compareTo(Livro livro) {
        return titulo.compareTo(livro.getTitulo());
    }
    
    @Override
    public int hashCode() {
        return titulo.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (!(obj instanceof Livro)){
            return false;
        }
        
        Livro l1 = (Livro) obj;
        
        if (this.titulo == null || l1.titulo == null){
            return false;
        }

        if (this.titulo.equals(l1.titulo)){
            return true;
        }
        
        return false;
    }
    
    //// GETS E SETS ////

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public long getISBN() {
        return ISBN;
    }
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }
    public Integer getEdicao() {
        return edicao;
    }
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }
}

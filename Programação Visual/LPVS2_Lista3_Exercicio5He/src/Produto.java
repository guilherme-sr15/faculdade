/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HVS
 */
public class Produto {
    
    //Atributos
    private String nome;
    private int estoque;
    private double precoUnitario;
    
    //Contrutor
    public Produto(String nome, int estoque, double precoUnitario){
        setNome(nome);
        setEstoque(estoque);
        setPrecoUnitario(precoUnitario);
    }
    
    //Encapsulamentos
    //gets
    public String getNome(){
        return this.nome;
    }
    public int getEstoque(){
        return this.estoque;
    }
    public double getPrecoUnitario(){
        return this.precoUnitario;
    }
    //sets
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    public void setPrecoUnitario(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    
    //Metodos
    public double calcularTotal(){
        return getEstoque() * getPrecoUnitario();
    }
    public double calcularTotal(Produto p){
        return p.getEstoque() * p.getPrecoUnitario();
    }
    
    public boolean verificarIguais(Produto p){
        return (this.nome.equalsIgnoreCase(p.nome) && this.estoque == p.estoque && this.precoUnitario == p.precoUnitario);
    }
    
    public Produto calcularMaiorEstoque(Produto p){
        //if (this.estoque >= p.estoque)
        //    return this;
        //return p;
        
        return this.estoque >= p.estoque ? this : p; // Operador Ternário (Usado apenas em situações de retorno e atribuição de variavel
    }
    
    @Override
    public String toString(){
        return "Nome: " + nome + "\nEstoque: " + estoque + "\nPreco: " + precoUnitario;
    }
    
}

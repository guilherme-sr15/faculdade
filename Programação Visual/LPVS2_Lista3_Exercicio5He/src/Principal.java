/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HVS
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Produto p1 = new Produto("Teclado", 10, 30.0);
        Produto p2 = new Produto("Janela", 50, 45.0);
        
        System.out.println(p1.calcularMaiorEstoque(p2)); // impreme os dados do produto com maior estoque
        
        System.out.println(p1.calcularTotal(p1.calcularMaiorEstoque(p2))); // calcula o total do produto com maior estoque
        
        System.out.println(p1.calcularTotal()); // retorna o total do objeto referenciado
        
        if (p1.verificarIguais(p2))
            System.out.println("Produtos Iguais");
        else
            System.out.println("Produtos Diferentes");
        
    }
}

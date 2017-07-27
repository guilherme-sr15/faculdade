/*
 * @author Guilherme de Souza Rodrigues
 */

public class Pessoa {
    
    private String nome;
    private int idade;
    String logradouro;
    String bairro;
    int nro;
    
    
    public Pessoa(String nome, int idade, Endereco pessoal, Endereco comercial){
        this.nome = nome;
        this.idade = idade;
        Endereco e = new 
    }
    
    public Pessoa(String nome, int idade, Endereco pessoal){
        this(nome, idade, pessoal, null);
    }    
}
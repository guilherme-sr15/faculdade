
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Pessoa {

    private String nome;
    private int cpf;
    private int idade;

    public Pessoa(String nome, int cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }   
    
}

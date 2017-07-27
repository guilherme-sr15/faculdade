
import java.io.Serializable;


/*
 * @author Guilherme de Souza Rodrigues
 */

public abstract class Pessoa /*implements Serializable */{
    
    private String nome;
    private int idade;
    private Contato contato;
    
    private final static long serialVersionUID = 1L;

    public Pessoa(String nome, int idade, Contato contato) {
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade + "\n" + contato;
    }
}

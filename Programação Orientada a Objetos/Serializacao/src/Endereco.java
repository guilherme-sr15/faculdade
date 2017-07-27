
import java.io.Serializable;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Endereco implements Serializable {
    
    private String logradouro;
    private String bairro;

    public Endereco(String logradouro, String bairro) {
        this.logradouro = logradouro;
        this.bairro = bairro;
    }
    
    @Override
    public String toString() {
        return "Endereço: " + logradouro + ", " + bairro;
    }
}

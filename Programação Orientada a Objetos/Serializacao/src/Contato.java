
import java.io.Serializable;

            
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Contato implements Serializable {
    
    private String telefone;
    private transient Endereco endereco;

    public Contato(String telefone, Endereco endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Contato: " + telefone + "\n" + endereco;
    }
}

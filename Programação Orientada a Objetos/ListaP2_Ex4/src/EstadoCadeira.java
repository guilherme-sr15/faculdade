
/**
 * @author Guilherme de Souza Rodrigues
 */

public enum EstadoCadeira {
    VAZIA(0),
    OCUPADA(1);
    
    private int numero;
    
    EstadoCadeira(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}

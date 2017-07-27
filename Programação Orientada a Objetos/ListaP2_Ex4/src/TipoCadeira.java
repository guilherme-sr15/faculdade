
/**
 * @author Guilherme de Souza Rodrigues
 */

public enum TipoCadeira {
    DESTRO(1),
    CANHOTO(2);
     
    private int numero;
     
    TipoCadeira(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}

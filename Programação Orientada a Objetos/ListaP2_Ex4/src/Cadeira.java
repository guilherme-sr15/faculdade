
/**
 * @author Guilherme de Souza Rodrigues
 */

public class Cadeira {
    private EstadoCadeira status;
    private TipoCadeira tipo;
    
    public Cadeira(EstadoCadeira status, TipoCadeira tipo){
        this.status = status;
        this.tipo = tipo;
    }

    public EstadoCadeira getStatus() {
        return status;
    }

    public TipoCadeira getTipo() {
        return tipo;
    }

    public void setStatus(EstadoCadeira status) {
        this.status = status;
    }

    public void setTipo(TipoCadeira tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{" + status + ", " + tipo + '}';
    }
}

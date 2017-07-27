
/*
 * @author Guilherme de Souza Rodrigues
 */

public abstract class Eletronico implements Ligaveis {
    private boolean estado;
    
    public Eletronico(boolean estado){
        this.estado = estado;
    }
    
    public boolean getEstado(){
        return this.estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}

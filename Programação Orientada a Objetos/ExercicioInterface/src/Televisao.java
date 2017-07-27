
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Televisao extends Eletronico implements Ligaveis{
    
    public Televisao(boolean estado){
        super(estado);
    }
    
    @Override
    public boolean ligar() {
        if(!this.getEstado()){
            this.setEstado(true);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean desligar(){
        if(this.getEstado()){
            this.setEstado(false);
            return true;
        }
        return false;   
    }
}

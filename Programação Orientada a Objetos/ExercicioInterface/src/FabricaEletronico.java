
/*
 * @author Guilherme de Souza Rodrigues
 */

public class FabricaEletronico {
    public static final String CELULAR = "Celular";
    public static final String NOTEBOOK = "Notebook";
    public static final String TV = "TV";
    
    public Eletronico getEletro(String tipo, boolean estado){
        if(CELULAR.equals(tipo)){
            return new Celular(estado);
        }else if (NOTEBOOK.equals(tipo)){
            return new Notebook(estado);
        }else{
            return new Televisao(estado);
        }
    }
}

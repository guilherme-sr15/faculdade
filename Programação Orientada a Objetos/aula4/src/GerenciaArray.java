/**
 *
 * @author Guilherme de Souza Rodrigues
 */
public class GerenciaArray {
    
    private String[] array;
    private int cont;
    public final static int MAX = 50;
    
    public GerenciaArray(){
        array = new String[MAX];
    }
    
    /*public GerenciaArray(final int MAX){
        this.max = MAX;
        array = new String[max];
    }
    
    public GerenciaArray(){
        this(50);
    }*/
    
    public boolean addPalavra(String word){
        if(cont < MAX){
            array[cont] = word;
            cont++;
            return true;
        }
        return false;
    }
    
    
}

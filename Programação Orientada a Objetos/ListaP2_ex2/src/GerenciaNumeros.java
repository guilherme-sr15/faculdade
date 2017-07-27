
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaNumeros {
    
    private List<Integer> lista;

    public GerenciaNumeros() {
        this.lista = new ArrayList<>();
    }
    
    public void preencherLista(){
        for(int i = 0; i<10; i++){
            lista.add(i, (int)(Math.random() * 1000 + 1));
        }
    }
    
    public List<Integer> ordenaCrescente(){
        Collections.sort(lista);
        return lista;
    }
    
    public List<Integer> ordenaDecrescente(){
        Collections.reverse(lista);
        return lista;
    }

    public List<Integer> getLista(){
        return lista;
    }
}

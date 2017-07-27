
import java.util.HashSet;
import java.util.Set;


/**
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaNumeros {
    private final Set<Integer> numeros;

    public GerenciaNumeros() {
        numeros = new HashSet<>();
    }
    
    public void adicionar(Integer numero){
        numeros.add(numero);
    }
    
    public Set<Integer> uniao(Set conjunto){
        Set<Integer> uniao = new HashSet<>();
        uniao.addAll(numeros);
        uniao.addAll(conjunto);
        return uniao;
    }
    
    public Set<Integer> interseccao(Set conjunto){
        Set<Integer> inter = new HashSet<>();
        inter.addAll(numeros);
        inter.retainAll(conjunto);
        return inter;
    }

    public Set<Integer> getNumeros() {
        return numeros;
    }   
}

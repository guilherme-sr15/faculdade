
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaNumeros {
    private final Set<Integer> numeros;

    public GerenciaNumeros() {
        numeros = new TreeSet<>();
    }
    
    public void adicionar(int numero){
        numeros.add(numero);
    }
    
    public Set<Integer> uniao(Set conjunto){
        Set<Integer> uniao = new TreeSet<>();
        uniao.addAll(numeros);
        uniao.addAll(conjunto);
        return uniao;
    }
    
    public Set<Integer> interseccao(Set conjunto){
        Set<Integer> inter = new TreeSet<>();
        inter.addAll(numeros);
        inter.retainAll(conjunto);
        return inter;
    }

    public Set<Integer> getNumeros() {
        return numeros;
    }
  
    public int getMaior(){
        int num = 0;
        Iterator iterator = numeros.iterator();
        while(iterator.hasNext()){
            num = (int)iterator.next();
        }
        return num;
    }
    
    public int getMenor(){
        int num = 0;
        Iterator iterator = numeros.iterator();
        if(iterator.hasNext()){
            num = (int)iterator.next();
        }
        return num;
    }
}

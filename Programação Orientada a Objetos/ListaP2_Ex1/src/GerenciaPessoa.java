
import java.util.ArrayList;
import java.util.List;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaPessoa {

    private List<Pessoa> lista;
    
    public GerenciaPessoa(){
        lista = new ArrayList<>();
    }
    
    public boolean addPessoa(Pessoa p){
        if(p != null){
            lista.add(p);
            return true;
        }
        return false;
    }
    
    public Pessoa returnOnIdex(int posicao){
        return lista.get(posicao);
    }
    
    public int getPosicao(Pessoa p){
        return lista.indexOf(p);
    }
    
    public void remover(Pessoa p){
        lista.remove(p);
    }
    
    public void remover(String nome){
        int i = 0;
        while(i < lista.size()){
            Pessoa p1 = lista.get(i);
            if(p1.getNome().equals(nome)){
                lista.remove(p1);
            }else{
                i++;
            }
        }
    }
    
    public List getPessoas(){
        List l = new ArrayList<>();
        l.addAll(lista);
        return l;
    }
      
    public String getDados(){
        return lista.toString();
    }
}

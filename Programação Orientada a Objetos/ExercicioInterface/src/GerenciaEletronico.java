
import java.util.ArrayList;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaEletronico {
    private ArrayList<Eletronico> lista;
    
    public GerenciaEletronico(){
        lista = new ArrayList<>();
    }
    
    public boolean adicionarEletronico(Eletronico e){
        if (lista.add(e)){
            return true;
        }
        return false;
    }
    
    public boolean ligarEletro(int pos){
        int tamanho = lista.size();
        if(lista.isEmpty())
            return false;
        else if(pos > tamanho)
            return false;
        else{
            if(lista.get(--pos).ligar()){   //1º elemento inserido vai estar no índice 0;
                return true;
            }else{
                System.out.println("Log: Já está ligado!");
                return false;
            }
        }
    }
    
    public boolean desligarEletro(int pos){
        int tamanho = lista.size();
        if(lista.isEmpty())
            return false;
        else if(pos > tamanho)
            return false;
        else{
            if(lista.get(--pos).desligar()){   //1º elemento inserido vai estar no índice 0;
                return true;
            }else{
                System.out.println("Log: Já está desligado!");
                return false;
            }
        }
    }
    
    public int getIndex(){
        return lista.size();
    }
}

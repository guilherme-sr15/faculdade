
import java.util.ArrayList;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class ListaFiguras {
    
    private ArrayList<FiguraGeometrica> lista;
    
    public ListaFiguras(){
        lista = new ArrayList<>();
    }
    
    public boolean adicionaFiguras(FiguraGeometrica figura){
        return lista.add(figura);
    }
    
    public FiguraGeometrica retornaFigura(int pos){
        int tamanho = lista.size();
        if(lista.isEmpty())
            return null;
        else if(pos > tamanho)
            return null;
        return lista.get(--pos); //Decrementa porque se o usuário quiser pesquisar o 1º elemento inserido ele vai estar no índice 0;
    }
    
    public boolean estaVazia(){
        return lista.isEmpty();
    }
    
    @Override
    public String toString(){
        
        StringBuilder dados = new StringBuilder();
        
        for (int i = 0; i < lista.size(); i++){
            dados.append(lista.get(i));
            dados.append("\n");
        }
        
        return dados.toString();        
    }
}

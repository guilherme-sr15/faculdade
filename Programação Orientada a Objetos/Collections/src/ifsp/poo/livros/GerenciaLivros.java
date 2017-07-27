
package ifsp.poo.livros;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaLivros {

    private List<Livro> lista;

    public GerenciaLivros() {
        this.lista = new ArrayList<>();
    }
    
    public void preencherLista(List<String> dados, String criterio){
        for(String dado: dados){
            String[] tokens = dado.split(criterio);
            String titulo = tokens[0];
            long isbn = Long.parseLong(tokens[1]);
            int edicao = Integer.parseInt(tokens[2]);
            
            Livro l = new Livro(titulo, isbn, edicao);
            lista.add(l);
        }
    }

    public List<Livro> getLista() {
        return lista;
    }
}

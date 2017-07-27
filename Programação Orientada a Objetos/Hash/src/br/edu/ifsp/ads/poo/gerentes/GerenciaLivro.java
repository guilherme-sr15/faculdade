
package br.edu.ifsp.ads.poo.gerentes;

import br.edu.ifsp.ads.poo.entidades.Livro;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaLivro {
   //// ATRIBUTOS ////

    private List<Livro> livros;

    //// CONSTRUTOR ////

    public GerenciaLivro(){
            livros = new ArrayList<>();
    }

    //// MÉTODOS ////

    public void preencherLista(List<String> dados, String criterio){

            for (String dado: dados){

                    String[] tokens = dado.split(criterio);

                    String titulo = tokens[0];
                    long ISBN = Long.parseLong(tokens[1]);
                    Integer edicao = Integer.parseInt(tokens[2]);

                    Livro livro = new Livro(titulo, ISBN, edicao);
                    livros.add(livro);
            }
    }

    //// GETS E SETS ////

    public List<Livro> getLivros() {
            return livros;
    }

    public void setLivros(List<Livro> livros) {
            this.livros = livros;
    }
}


package ifsp.poo.principal;

import ifsp.poo.arquivo.GerenciaArquivoTexto;
import ifsp.poo.livros.EdicaoComparator;
import ifsp.poo.livros.GerenciaLivros;
import ifsp.poo.livros.Livro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {

    public static void main(String[] args) {
        preencherArquivo();
        GerenciaLivros gl;
        GerenciaArquivoTexto gat = new GerenciaArquivoTexto("livros.txt");
        try{
            List<String> dados = gat.lerArquivo();
            gl = new GerenciaLivros();
            gl.preencherLista(dados, ";");
            List<Livro> livros = gl.getLista();
            System.out.println(livros);
            //Collections.sort(livros);
            //System.out.println(livros);
            Comparator ec = new EdicaoComparator();
            Collections.sort(livros, ec);
            System.out.println(livros);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void preencherArquivo(){
        GerenciaArquivoTexto gat = new GerenciaArquivoTexto("livros.txt");
        List<String> dados = new ArrayList<>();
        dados.add("Desenvolvimento Web Java;12345;2");
        dados.add("Desenvolvimento Web Java;12345;1");
        dados.add("Use a cabeça Java;12354;18");
        dados.add("Use a cabeça Java;12354;2");
        dados.add("Algoritmos e Programação;12453;1");
        dados.add("Algoritmos e Programação;12453;2");
        try{
            gat.escreverArquivo(dados);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

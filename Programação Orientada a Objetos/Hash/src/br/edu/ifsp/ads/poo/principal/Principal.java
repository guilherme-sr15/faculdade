
package br.edu.ifsp.ads.poo.principal;

import br.edu.ifsp.ads.poo.entidades.Livro;
import br.edu.ifsp.ads.poo.gerentes.GerenciaArquivoTexto;
import br.edu.ifsp.ads.poo.gerentes.GerenciaLivro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args){
        //preencherArquivo();

        GerenciaArquivoTexto gerenteArquivo;
        gerenteArquivo = new GerenciaArquivoTexto("livros.txt");

        List<String> dados = null;
        GerenciaLivro gerenteLivro = null;

        try {

            //preencherArquivo();
            dados = gerenteArquivo.ler();

            gerenteLivro = new GerenciaLivro();
            List<Livro> livros = gerenteLivro.getLivros();
            gerenteLivro.preencherLista(dados, ";");

            //Collections.sort(livros);
            //System.out.println(livros);

            Set<Livro> conjunto;
            conjunto = new TreeSet<>();

            conjunto.addAll(livros);

            System.out.println(conjunto);

            //Comparator<Livro> comp = new EdicaoComparator();
            //Collections.sort(livros, comp);		
            //System.out.println(livros)

            Map<String, Long> params = new HashMap<>();
            params.put("Java", 123L);
            params.put("C#", 456L);

            System.out.println(params.get("Java"));

        } catch (IOException e) {
                e.printStackTrace();
        }

    }

    public static void preencherArquivo(){

            GerenciaArquivoTexto gerencia = new GerenciaArquivoTexto("livros.txt");
            List<String> dados = new ArrayList<>();

            dados.add("Desenvolvimento Web Java;9788521617457;2");
            dados.add("Desenvolvimento Web Java;9788521617457;1");
            dados.add("Use a cabeça Java;9788576081739;18");
            dados.add("Use a cabeça Java;9788576081739;2");
            dados.add("Algoritmos e programação;857522073;1");
            dados.add("Algoritmos e programação;857522073;2");

            try{
                    gerencia.gravar(dados);
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
}

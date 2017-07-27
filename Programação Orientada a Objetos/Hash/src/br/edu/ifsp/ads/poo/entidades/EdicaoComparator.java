
package br.edu.ifsp.ads.poo.entidades;

import java.util.Comparator;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class EdicaoComparator implements Comparator<Livro>{
    @Override
    public int compare(Livro livro1, Livro livro2) {
        return Integer.compare(livro1.getEdicao(), livro2.getEdicao());
    }
}

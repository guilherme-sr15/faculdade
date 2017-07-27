package ifsp.poo.livros;

import java.util.Comparator;

/*
 * @author Guilherme de Souza Rodrigues
 */
public class EdicaoComparator implements Comparator<Livro> {

    @Override
    public int compare(Livro t, Livro t1) {
        int c = t.compareTo(t1);
        int d = Long.compare(t.getIsbn(), t1.getIsbn());
        if(d == 0)
            return Integer.compare(t.getEdicao(), t1.getEdicao());
        return c;
    }
}

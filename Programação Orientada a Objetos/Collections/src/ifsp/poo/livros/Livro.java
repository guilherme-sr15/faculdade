
package ifsp.poo.livros;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Livro implements Comparable<Livro>{
    
    private String titulo;
    private long isbn;
    private int edicao;

    public Livro(String titulo, long isbn, int edicao) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public long getIsbn() {
        return isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String toString() {
        return String.format("Título: %s, ISBN: %d, Edição: %d%n", titulo, isbn, edicao);
    }

    @Override
    public int compareTo(Livro t) {
        return titulo.compareTo(t.titulo);
    }
}

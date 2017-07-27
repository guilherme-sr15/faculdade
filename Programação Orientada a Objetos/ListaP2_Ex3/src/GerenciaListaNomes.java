
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaListaNomes {

    private final List<String> lista;
    private final String nomeArquivo = "nomes.txt";

    private static GerenciaListaNomes instance;
    
    public GerenciaListaNomes() {
        lista = new ArrayList<>();
    }
    
    public static GerenciaListaNomes getInstance(){
        if(instance == null){
            instance = new GerenciaListaNomes();
        }
        return instance;
    }
    
    public void adicionarNome(String nome) throws IOException{
        GerenciaArquivoTexto.escritor(nomeArquivo, nome);
    }
    
    public void recuperarNomes() throws IOException {
        String nomesArquivo = GerenciaArquivoTexto.leitor(nomeArquivo);
        String[] arrayNomes = nomesArquivo.split(";");
        lista.addAll(Arrays.asList(arrayNomes));
    }
    
    public boolean pesquisarNome(String nome) throws IOException{
        recuperarNomes();
        return lista.contains(nome);
    }
    
    
}

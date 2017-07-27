
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaArquivoTexto {
    
    public static String leitor(String caminho) throws IOException{
        FileReader arquivo = new FileReader(caminho);
        BufferedReader buffer = new BufferedReader(arquivo);
        String linha;
        StringBuilder saida = new StringBuilder();
        while((linha = buffer.readLine()) != null){
            saida.append(linha);
        }
        buffer.close();
        return saida.toString();
    }
    
    public static void escritor(String caminho, String nome) throws IOException{
        FileWriter arquivo = new FileWriter(caminho, true);
        BufferedWriter buffer = new BufferedWriter(arquivo);
        buffer.append(nome + ";");
        buffer.close();
    }    
}

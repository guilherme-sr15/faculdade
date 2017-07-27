
import java.io.IOException;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        ManipuladorArquivoTexto mat = new ManipuladorArquivoTexto("teste.txt");
        try{
            mat.gravar("Guilherme");
            mat.gravar("Teste1");
            mat.gravar("Teste2");
            mat.gravar("Teste3");
            mat.gravar("Teste4");
            mat.gravar("Teste5");
            
            mat.ler();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}

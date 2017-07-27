
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class ManipuladorArquivoTexto {

    private final File arquivo;
    private FileWriter fw;
    private FileReader fr;
    private BufferedWriter bw = null;
    private BufferedReader br = null;
    
    public ManipuladorArquivoTexto(String caminho) {
        arquivo = new File(caminho);
    }
    
    public void gravar(String s) throws IOException{
        try{
            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);

            bw.write(s);
            bw.newLine();
        }finally{
            try{
                if(bw != null)
                    bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void ler() throws IOException{
        try{
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);

            while(br.ready()){
                String linha = br.readLine();
                System.out.println(linha);
            }
        }finally{
            if(br != null){
                br.close();
            }
        }
    }
}

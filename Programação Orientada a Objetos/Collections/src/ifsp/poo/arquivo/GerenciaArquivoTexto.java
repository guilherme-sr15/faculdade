    
package ifsp.poo.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaArquivoTexto {
    
    private File arquivo;

    public GerenciaArquivoTexto(String caminho) {
        this.arquivo = new File(caminho);
    }
    
    public void escreverArquivo(List<String> dados) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try{
            fw = new FileWriter(arquivo, false);
            bw = new BufferedWriter(fw);
            
            for(String dado: dados){
                bw.write(dado);
                bw.newLine();
            }
            
        }finally{
            liberarRecursos(bw);
        }
            
    }
    
    public List lerArquivo() throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        List<String> dados = new ArrayList<String>();
        try{
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            String linha = null;
            while((linha = br.readLine()) != null){
                dados.add(linha);
            }
            return dados;
        }finally{
            liberarRecursos(br);
        }
    }
    
    private void liberarRecursos(Closeable recurso) throws IOException{
        try{
            if (recurso != null){
                recurso.close();
            }
        }finally{
            
        }
    }
}

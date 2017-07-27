
package br.edu.ifsp.ads.poo.gerentes;

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

    //// ATRIBUTOS ////
    
    private File file;
    
    //// CONSTRUTOR ////
    
    public GerenciaArquivoTexto(String caminho){
        file = new File(caminho);
    }

    //// METODOS ////
    
    public void liberarRecursos(Closeable recurso) throws IOException{
        if (recurso != null){
            recurso.close();
        }
    }
    
    public void gravar(List<String> dados) throws IOException {
        FileWriter fw = null; // FLUXO DE CONEXÃO
        BufferedWriter bw = null; // FLUXO DE CADEIA
        
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            for (String dado : dados){
                bw.write(dado);
                bw.newLine();
            }
            
        } finally {
            liberarRecursos(bw);
        }
        
    }
    
    public List<String> ler() throws IOException{
        FileReader fr = null;
        BufferedReader br = null;
        List<String> dados = new ArrayList<String>();
        
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String linha = null;            
            while((linha = br.readLine()) != null){
                dados.add(linha);
            }
            
            return dados;
            
        } finally {
            liberarRecursos(br);
        }
    }
        
    //// GETS E SETS ////
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

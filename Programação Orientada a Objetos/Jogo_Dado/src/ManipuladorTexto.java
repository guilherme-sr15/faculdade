
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class ManipuladorTexto extends Manipulador {
    
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;    
    
    public ManipuladorTexto(String caminho){
        super(caminho);
    }
    
    @Override
    public void saveGame(Object o) throws FileNotFoundException, IOException{
        try{
            fw = new FileWriter(this.getArquivo(), false);
            bw = new BufferedWriter(fw);
            
            JogoDado game = (JogoDado) o;

            bw.write(String.valueOf(game.getDice1()));
            bw.write(";");
            bw.write(String.valueOf(game.getDice2()));
            bw.write(";");
            bw.write(String.valueOf(game.getTries()));
            bw.write(";");
            bw.write(String.valueOf(game.getSum()));
            
        }finally{
            try{
                if(bw != null)
                    bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public Object recoverGame() throws IOException{
        try{
            fr = new FileReader(this.getArquivo());
            br = new BufferedReader(fr);
            String linha = null;
            while(br.ready()){
                linha = br.readLine();
                System.out.println(linha);
            }
            String[] vet = linha.split(";");
            
            JogoDado g = new JogoDado();
            g.setDice1(Integer.parseInt(vet[0]));
            g.setDice2(Integer.parseInt(vet[1]));
            g.setTries(Integer.parseInt(vet[2]));
            g.setSum(Integer.parseInt(vet[3]));
            
            return g;
        }finally{
            if(br != null){
                br.close();
            }
        }
    }
}

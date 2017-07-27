
import java.io.IOException;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        Endereco e = new Endereco("Rua 6", "Jd. Nova América");
        Contato c = new Contato("996121786", e);
        Pessoa p = new PessoaFisica("Guilherme", 21, c);
        
        ManipuladorArquivo ma = new ManipuladorArquivo("arq.ser");
        try{
            ma.serializarObjeto(p);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            System.out.println(ma.desserializarObjeto());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

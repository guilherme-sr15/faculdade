
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class ManipuladorSerializador extends Manipulador{
    
    public ManipuladorSerializador(String caminho) {
        super(caminho);
    }
    
    @Override
    public void saveGame(Object o) throws FileNotFoundException, IOException {
        FileOutputStream fs = null;
        ObjectOutputStream os = null;
        try{
            fs = new FileOutputStream(this.getArquivo(), false);
            os = new ObjectOutputStream(fs);
            System.out.println("entrou");
            os.writeObject(o);
        }finally{
            fecharRecursos(fs, os);
        }
    }
    
    @Override
    public Object recoverGame() throws FileNotFoundException, ClassNotFoundException, IOException {
        FileInputStream fs = null;
        ObjectInputStream os = null;
        Object o;
        try{
            fs = new FileInputStream(this.getArquivo());
            os = new ObjectInputStream(fs);
            o = os.readObject();
        }finally{
            fecharRecursos(fs, os);
        }
        
        return o;
    }
    
    private void fecharRecursos(Closeable c1, Closeable c2) throws IOException {
        if(c1 != null){
            c1.close();
            if(c2 != null)
                c2.close();
        }
    }
}



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * @author Guilherme de Souza Rodrigues
 */

public abstract class Manipulador {
    
    private final File arquivo;
    
    public Manipulador(String caminho){
        this.arquivo = new File(caminho);
    }

    abstract void saveGame(Object o) throws FileNotFoundException, IOException;
    abstract Object recoverGame() throws FileNotFoundException, ClassNotFoundException, IOException ;

    public File getArquivo() {
        return arquivo;
    }

    
}

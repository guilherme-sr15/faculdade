
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * @author Guilherme de Souza Rodrigues
 */

public interface Manipular {
    void saveGame(Object o) throws FileNotFoundException, IOException ;
    //void saveGame(JogoDado game) throws FileNotFoundException, IOException ;
    Object recoverGame() throws FileNotFoundException, ClassNotFoundException, IOException ;
}

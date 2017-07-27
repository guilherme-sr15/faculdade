
import javax.swing.JOptionPane;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Exit {
    
    public static final int OPTION_PANE = 1;
    public static final int SOUT = 2;
   
    public boolean print(int exitType, String word){
        if((exitType == 1)||(exitType == 2)){
            printString(exitType, word);
            return true;
        }
        return false;
    }
    
    private void printString(int exitType, String word){
        if (exitType == Exit.OPTION_PANE){
            JOptionPane.showMessageDialog(null, word);
        }else{
            System.out.println(word);
        }
    }
}
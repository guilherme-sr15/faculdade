/*
 * @author Guilherme de Souza Rodrigues
 */

public class Main {
    public static void main(String[] args) {
        Exit e1 = new Exit();
        Exit e2 = new Exit(); 
        
        boolean l ;
        l = e1.print(Exit.OPTION_PANE, "Test");
        log(l);
        l = e2.print(Exit.SOUT, "Test");
        log(l);  
    }
    
    public static void log(boolean l){
        if(l)
            System.out.println("\n\nDados impressos.\n\n");
        else
            System.out.println("\n\nMétodo de impressão inválido.\n\n");
    }
}
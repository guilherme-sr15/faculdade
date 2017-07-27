
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class JanelaGenerica extends JFrame{
   
    public JanelaGenerica(JPanel p1){
        adicionarComponentes(p1);
        configurarJanela();
    }
    
    private void adicionarComponentes(JPanel p1){
        add(p1);
    }
    
    private void configurarJanela(){
        setTitle("Janela Genérica");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

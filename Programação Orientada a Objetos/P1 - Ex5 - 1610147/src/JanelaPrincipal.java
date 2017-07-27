
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class JanelaPrincipal extends JFrame implements ActionListener {
    private JPanel panel;
    private JPanel panelGenerico;
    
    private JLabel label;
    private JLabel labelGenerico;
    
    private JButton button;
    private JButton buttonGenerico;
    
    private JTextField field;
    private JTextField fieldGenerico;
    
    private JanelaGenerica janela;
    
    public JanelaPrincipal(){
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        panelGenerico = new JPanel();
        
        label = new JLabel("Escolha um painel (A/B): ");
        
        button = new JButton("OK");
        button.addActionListener(this);
        
        field = new JTextField(5);
        
        adicionarComponentes();
    }
    
    private void configurarJanela(){
        setTitle("Exercício 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void adicionarComponentes(){
        panel.add(label);
        panel.add(field);
        panel.add(button);
        add(panel);
    }
    
    private void mostrarJanela(){
        String s = field.getText();
        if (s.equalsIgnoreCase("a")){
            criarJanela(gerarPainelA());
        }else if (s.equalsIgnoreCase("b")){
            criarJanela(gerarPainelB());
        }else
            JOptionPane.showMessageDialog(this, "Opção inválida!");
    }
    
    private void criarJanela(JPanel p){
        janela =  new JanelaGenerica(p);
    }
    
    private JPanel gerarPainelA(){
        labelGenerico = new JLabel("A");
        fieldGenerico = new JTextField(5);
        panelGenerico.add(labelGenerico);
        panelGenerico.add(fieldGenerico);
        return panelGenerico;
    }
    
    private JPanel gerarPainelB(){
        labelGenerico = new JLabel("B");
        buttonGenerico = new JButton("B");
        panelGenerico.add(labelGenerico);
        panelGenerico.add(buttonGenerico);
        return panelGenerico;   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button)
            mostrarJanela();
    }
    
    
    
}

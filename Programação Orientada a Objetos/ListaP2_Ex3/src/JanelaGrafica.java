
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class JanelaGrafica extends JFrame implements ActionListener {
    
    private JPanel panel;
    
    private JTextField fieldNome;
    
    private JButton buttonConsultar;
    private JButton buttonInserir;
    
    private JLabel labelNome;
    
    GerenciaListaNomes listaNomes;
    
    public JanelaGrafica(){
        listaNomes = GerenciaListaNomes.getInstance();
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        
        fieldNome = new JTextField(10);
        
        buttonConsultar = new JButton("Consultar");
        buttonConsultar.addActionListener(this);
        buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(this);
        
        labelNome = new JLabel("Nome:");
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes(){
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(buttonInserir);
        panel.add(buttonConsultar);
        add(panel);
    }
    
    private void configurarJanela(){
        setVisible(true);
        setTitle("Exercício 3 - Java");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void inserirNome(){
        try{
            listaNomes.adicionarNome(fieldNome.getText());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void consultarNome(){
        try{
            if (listaNomes.pesquisarNome(fieldNome.getText())) {
                JOptionPane.showMessageDialog(null,"Nome encontrado!");
            } else {
                JOptionPane.showMessageDialog(null,"Nome não encontrado!");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonInserir){
            inserirNome();
        }else{
            consultarNome();
        }
    }
    
    
}

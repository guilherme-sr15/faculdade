/*
 * @author Guilherme de Souza Rodrigues
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Show extends JInternalFrame implements ActionListener{

    private JPanel panel;
    
    private JLabel labelShow;
    
    private JButton buttonShow;
    
    private JTextArea areaDados;
    private JScrollPane scrollDados;
    
    private MainWindow window;
    
    Employee employee;
    
    public Show(MainWindow window){
        super("Mostrar cadastros", true, true, true, true);
        criarComponentes();
        configurarJanela();
        this.window = window;
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Exibir"));
        labelShow = new JLabel("Nome(s) já digitado(s):");
        areaDados = new JTextArea(10,20);
        areaDados.setEditable(false);
        buttonShow = new JButton("Mostrar");
        buttonShow.addActionListener(this);
        scrollDados = new JScrollPane(areaDados);
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes() {
        panel.add(labelShow);
        panel.add(buttonShow);
        panel.add(scrollDados);
        add(panel);
    }
    
    private void configurarJanela(){
        setVisible(true);
        setResizable(false);
        pack();
        setSize(400,300);
        setLocation(400,240);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void exibirDados(){
        areaDados.setText(window.getList().toString());
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonShow){
            exibirDados();
        }
    }
}
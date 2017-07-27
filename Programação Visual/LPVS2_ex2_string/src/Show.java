/*
 * @author Guilherme de Souza Rodrigues
 */

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
    
    private GridBagLayout layout;
    
    private GridBagConstraints constraints;
    
    private MainWindow window;
    
    Employee employee;
    
    public Show(MainWindow window){
        super("Mostrar cadastros", true, true, true, true);
        criarComponentes();
        configurarJanela();
        this.window = window;
    }
    
    private void criarComponentes(){
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        panel = new JPanel(layout);
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
        addComponents(scrollDados, 0,1, GridBagConstraints.WEST);
        addComponents(buttonShow, 2,1, GridBagConstraints.EAST);
        add(panel);
    }
    
    private void addComponents(Component comp, int line, int column, int position){
        constraints.gridy = line;
        constraints.gridx = column;
        constraints.anchor = position;
        constraints.insets = new Insets(10,10,10,10);
        Font font = new Font("tahoma", Font.PLAIN, 16);
        comp.setFont(font);
        layout.setConstraints(comp, constraints);
        panel.add(comp);
    }
    
    private void configurarJanela(){
        setVisible(true);
        setResizable(false);
        pack();
        setLocation(640,240);
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
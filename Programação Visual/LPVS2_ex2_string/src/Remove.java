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
import javax.swing.JTextField;

public class Remove extends JInternalFrame implements ActionListener{
    private JPanel panel;
    
    private JLabel labelRemove;
    
    private JTextField fieldRemove;
    
    private JButton buttonRemove;
    
    private MainWindow window;
    
    private GridBagConstraints constraints;
    
    private GridBagLayout layout;
    
    Employee employee;
    
    public Remove(MainWindow window){
        super("Remover pessoas", true, true, false, true);
        this.window = window;
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createTitledBorder("Remover"));
        buttonRemove = new JButton("Remover");
        buttonRemove.addActionListener(this);
        labelRemove = new JLabel("Remover:");
        fieldRemove =  new JTextField(10);
        
        adicionarComponentes();
    }
    
     private void adicionarComponentes() {
        addComponent(labelRemove, 0, 0, GridBagConstraints.EAST);
        addComponent(fieldRemove, 0, 1, GridBagConstraints.WEST);
        addComponent(buttonRemove,1,1, GridBagConstraints.EAST);
        add(panel);
    }
     
     private void addComponent(Component comp, int line, int column, int position){
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
        setLocation(700, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void remove(){
        if(fieldRemove.getText()!=null){
            if(window.getList().removeEmployee(fieldRemove.getText()))
                System.out.println("Removido.\n");
            else
                System.out.println("Não removido.\n");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonRemove){
            remove();
        }
    }
}
/*
 * @author Guilherme de Souza Rodrigues
 */

import java.awt.Dimension;
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
    
    Employee employee;
    
    public Remove(MainWindow window){
        super("Remover pessoas", true, true, true, true);
        this.window = window;
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Remover"));
        buttonRemove = new JButton("Remover");
        buttonRemove.addActionListener(this);
        labelRemove = new JLabel("Remover:");
        fieldRemove =  new JTextField(10);
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes() {
        panel.add(labelRemove);
        panel.add(fieldRemove);
        panel.add(buttonRemove);

        add(panel);
    }
    
    public Dimension changeSize(){
        return window.changeSize();
    }
    
    private void configurarJanela(){
        setVisible(true);
        //setResizable(false);
        setSize(changeSize());
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
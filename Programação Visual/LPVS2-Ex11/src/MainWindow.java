import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel labelIncome;
    private JLabel labelTitle;
    private JLabel labelSituation;
    private JTextField fieldIncome;
    private JButton buttonSet;
    private JRadioButton radioEspecializacao;
    private JRadioButton radioMestre;
    private JRadioButton radioDoutor;
    private ButtonGroup group;
    private JCheckBox boxTcc;
    private JCheckBox boxComissionado;
    
    public MainWindow(){
        setComponents();
        adjustWindow();
    }
    
    private void setComponents(){
        panel = new JPanel();
        
        labelIncome = new JLabel("Salário base: ");
        fieldIncome = new JTextField(10);
        
        labelTitle = new JLabel("Titulação: ");
        labelSituation = new JLabel("Situação: ");
        
        radioEspecializacao = new JRadioButton("Especialização");
        radioEspecializacao.setActionCommand("1");
        radioMestre = new JRadioButton("Mestre");
        radioMestre.setActionCommand("2");
        radioDoutor = new JRadioButton("Doutor");
        radioDoutor.setActionCommand("3");
        group = new ButtonGroup();
        group.add(radioEspecializacao);
        group.add(radioMestre);
        group.add(radioDoutor);
        radioEspecializacao.setSelected(true);
        
        boxTcc = new JCheckBox("Orientador de TCC");
        boxComissionado = new JCheckBox("Cargo comissionado");
        
        buttonSet = new JButton("Calcular");
        buttonSet.addActionListener(this);
        
        addComponents();
    }
    
    private void addComponents(){
        panel.add(labelIncome);
        panel.add(fieldIncome);
        panel.add(labelTitle);
        panel.add(radioEspecializacao);
        panel.add(radioMestre);
        panel.add(radioDoutor);
        panel.add(labelSituation);
        panel.add(boxTcc);
        panel.add(boxComissionado);
        panel.add(buttonSet);
        add(panel);
    }
    
    private void adjustWindow(){
        setVisible(true);
        setTitle("Calculadora de salário");
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void insertTeacher(){
        float salario = Float.parseFloat(fieldIncome.getText());
        int esp;
        esp = Integer.parseInt(group.getSelection().getActionCommand());
        /*if(radioEspecializacao.isSelected())
            esp = 0;
        else if (radioMestre.isSelected())
            esp = 1;
        else 
            esp = 2;*/
        
        Teacher t1 = new Teacher(salario, esp, boxTcc.isSelected(), boxComissionado.isSelected());
        t1.getFinalIncome();
        JOptionPane.showMessageDialog(null, t1);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonSet)
            insertTeacher();
    }
}

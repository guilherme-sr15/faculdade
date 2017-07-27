package br.edu.ifsp.arq.poos3.calc.janela;

import br.edu.ifsp.arq.poos3.calc.calculadora.Calculadora;
import br.edu.ifsp.arq.poos3.calc.operations.Add;
import br.edu.ifsp.arq.poos3.calc.operations.Divide;
import br.edu.ifsp.arq.poos3.calc.operations.Mod;
import br.edu.ifsp.arq.poos3.calc.operations.Multiply;
import br.edu.ifsp.arq.poos3.calc.operations.Subtract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class GraphicWindow extends JFrame implements ActionListener {
    private JPanel panel;
    
    private ButtonGroup group;
    
    private String opName;
    
    private JRadioButton buttonAdd;
    private JRadioButton buttonSubtract;
    private JRadioButton buttonMultiply;
    private JRadioButton buttonDivide;
    private JRadioButton buttonMod;
    
    private JLabel labelOp1;
    private JLabel labelOp2;
    
    private JTextField fieldOp1;
    private JTextField fieldOp2;
    
    private JButton buttonShowResult;
    
    private Calculadora c;
    
    private Add a;
    private Subtract s;
    private Multiply m;
    private Divide d;
    private Mod mod;
    
    public GraphicWindow(){
        createComponents();
        configureWindow();
    }
    
    private void createComponents(){
        panel = new JPanel();
        
        buttonShowResult = new JButton("Calcular");
        buttonShowResult.addActionListener(this);
        
        labelOp1 = new JLabel("Operando 1:");
        labelOp2 = new JLabel("Operando 2:");
        
        buttonAdd = new JRadioButton("Soma");
        buttonAdd.setSelected(true);
        buttonSubtract = new JRadioButton("Subtrai");
        buttonMultiply = new JRadioButton("Multiplica");
        buttonDivide = new JRadioButton("Divide");
        buttonMod = new JRadioButton("Módulo");

        group = new ButtonGroup();
        group.add(buttonAdd);
        group.add(buttonSubtract);
        group.add(buttonMultiply);
        group.add(buttonDivide);
        group.add(buttonMod);
        
        fieldOp1 = new JTextField(5);
        fieldOp2 = new JTextField(5);
        
        addComponents();
    }
    
    private void addComponents(){
        panel.add(labelOp1);
        panel.add(fieldOp1);
        panel.add(labelOp2);
        panel.add(fieldOp2);
        panel.add(buttonAdd);
        panel.add(buttonSubtract);
        panel.add(buttonMultiply);
        panel.add(buttonDivide);
        panel.add(buttonMod);
        panel.add(buttonShowResult);
        add(panel);
    }
    
    private void configureWindow(){
        setTitle("Calculadora");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void calc(){
        
        String s1 = fieldOp1.getText();
        String s2 = fieldOp2.getText();
        
        if(s1.matches("^[0-9]*[.]{0,1}[0-9]*$")){
            if(s2.matches("^[0-9]*[.]{0,1}[0-9]*$")){
                Double d1 = Double.parseDouble(s1);
                Double d2 = Double.parseDouble(s2);
                
                c = new Calculadora(d1, d2);
        
                if(buttonAdd.isSelected()){
                    a = new Add();
                    c.callOperation(a);
                }else if(buttonMultiply.isSelected()){
                    m = new Multiply();
                    c.callOperation(m);
                }else if(buttonSubtract.isSelected()){
                    s = new Subtract();
                    c.callOperation(s);
                }else if(buttonDivide.isSelected()){
                    d = new Divide();
                    c.callOperation(d);
                }else{
                    mod = new Mod();
                    c.callOperation(mod);
                }
            }
        }
    }
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonShowResult)
            calc();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.prova1.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import poo.prova1.paineis.FabricaPainel;
import poo.prova1.paineis.PainelAbstrato;

/**
 *
 * @author denis
 */
public class JanelaPrincipal extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel labelOp;
    private JTextField fieldOp;
    private JButton buttonOK;
    
    public JanelaPrincipal(String titulo) {
        super(titulo);
        criarComponentes();
        ajustarPropriedades();
    }
    
    private void criarComponentes() {
        panel = new JPanel();
                
        labelOp = new JLabel("Escolha um painel (A/B):");
        
        fieldOp = new JTextField(5);
        
        buttonOK = new JButton("OK");
        buttonOK.addActionListener(this);
        
        panel.add(labelOp);
        panel.add(fieldOp);
        panel.add(buttonOK);
        add(panel);
    }
    
    private void ajustarPropriedades() {
        setVisible(true);
        setSize(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String op = fieldOp.getText();
        FabricaPainel fabrica = new FabricaPainel();
        PainelAbstrato painel = fabrica.getPainel(op);
        JanelaGenerica janela = new JanelaGenerica("Janela genérica", painel);
    }
    
}

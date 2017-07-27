/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DênisLeonardo
 */
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastro extends JInternalFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel labelNome;
    private JTextField fieldNome;
    private JButton buttonOk;

    public JanelaCadastro(JanelaPrincipal janelaPrincipal) {
        super("Janela de Cadastro",true,true,true,true);
        
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes() {
        panel = new JPanel();
        
        labelNome = new JLabel("Nome: ");
        
        fieldNome = new JTextField(10);
        
        buttonOk = new JButton("OK");
        buttonOk.addActionListener(this);
        
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(buttonOk);
        
        add(panel);
    }
    
    private void configurarJanela() {
        setVisible(true);
        setSize(400,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

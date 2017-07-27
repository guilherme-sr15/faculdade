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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaExibicao extends JInternalFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel labelNome;
    private JTextArea areaNomes;
    private JScrollPane scrollNomes;
    private JButton buttonFechar;
    
    public JanelaExibicao(JanelaPrincipal janelaPrincipal) {
        super("Janela de Exibição",true,true,true,true);
        
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes() {
        panel = new JPanel();
        
        labelNome = new JLabel("Nome(s) digitado(s) na janela de cadastro: ");
        areaNomes = new JTextArea(15,15);
        areaNomes.setEditable(false);
        
        scrollNomes = new JScrollPane();
        scrollNomes.setViewportView(areaNomes);
        
        buttonFechar = new JButton("Fechar");
        buttonFechar.addActionListener(this);
        
        panel.add(labelNome);
        panel.add(scrollNomes);
        panel.add(buttonFechar);
        
        add(panel);
    }
    
    private void configurarJanela() {    
        setVisible(true);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DênisLeonardo
 */

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame implements ActionListener {

    private JDesktopPane desktop;
    //permite gerenciar múltiplas janelas internas
    
    private JMenuBar barra;
    //barra de menus
    
    private JMenu menuArquivo;
    //menu que ficará na barra de menus
    
    private JMenuItem itemCad,itemExi,itemSair;
    //itens que farão parte do menu
            
    private JanelaCadastro janelaCad;
    private JanelaExibicao janelaExi;
    
    public JanelaPrincipal() {
        super("Exemplo 1 - Menus e janelas internas");
        
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes() {
        desktop = new JDesktopPane();
        
        barra = new JMenuBar();
        
        menuArquivo = new JMenu("Arquivo");
        //menu.setText("Arquivo");
        
        itemCad = new JMenuItem("Tela de cadastro");
        itemCad.addActionListener(this);
        
        itemExi = new JMenuItem("Tela de exibição");
        itemExi.addActionListener(this);
        
        itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(this);
        
        menuArquivo.add(itemCad);
        menuArquivo.add(itemExi);
        menuArquivo.addSeparator();
        menuArquivo.add(itemSair);
        
        barra.add(menuArquivo);
        
        setJMenuBar(barra);
        
        add(desktop);
    }
    
    private void configurarJanela() {
        setVisible(true);
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void carregarJanela(JInternalFrame janela) {
        desktop.add(janela);
        desktop.moveToFront(janela);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemCad) {
            //carrega a tela de cadastro
            janelaCad = new JanelaCadastro(this);
            carregarJanela(janelaCad);
        }
        else if(e.getSource() == itemExi) {
            //carrega a tela de exibição
            janelaExi = new JanelaExibicao(this);
            carregarJanela(janelaExi);
        }
        else {
            //finaliza a aplicação
            System.exit(0);
        }
    } 
}

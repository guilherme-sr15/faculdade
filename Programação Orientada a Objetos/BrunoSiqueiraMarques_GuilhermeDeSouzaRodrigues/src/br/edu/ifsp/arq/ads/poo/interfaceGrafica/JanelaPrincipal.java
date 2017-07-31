/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import br.edu.ifsp.arq.ads.poo.interfaceGrafica.FactoryPanel;
import br.edu.ifsp.arq.ads.poo.interfaceGrafica.JanelaGenerica;
import br.edu.ifsp.arq.ads.poo.interfaceGrafica.PainelAbstrato;

/**
 *
 * @author Bruno Siqueira
 */
public class JanelaPrincipal extends JFrame implements ActionListener {

    private JDesktopPane desktop;
    private JMenu menu, menuUsuario, menuObras;
    private JMenuBar bar;

    private JMenuItem itemRealizarEmprestimo;
    private JMenuItem itemRealizarDevolucoes;
    private JMenuItem itemSair;
    private JMenuItem itemProfessor, itemAluno;
    private JMenuItem itemLivros, itemRevistas;

    public JanelaPrincipal() {
        super("SISTEMA BIBLIOTECA");
        criarComponentes();
        configurarJanela();
    }

    private void criarComponentes() {
        desktop = new BackGround("background.png");
        bar = new JMenuBar();
        menu = new JMenu("Menu");
        menuUsuario = new JMenu("Inserir usuários");
        menuObras = new JMenu("Inserir obras");

        itemRealizarDevolucoes = new JMenuItem("Realizar devoluções");
        itemRealizarEmprestimo = new JMenuItem("Realizar empréstimo");
        itemLivros = new JMenuItem("Livros");
        itemRevistas = new JMenuItem("Revistas");
        itemProfessor = new JMenuItem("Professor");
        itemAluno = new JMenuItem("Aluno");
        itemSair = new JMenuItem("Sair");

        adicionarComponentes();
    }
    
    private void configurarJanela() {
        setVisible(true);
        setSize(900, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void adicionarComponentes() {
        menu.add(menuObras);
        menu.addSeparator();
        menu.add(menuUsuario);
        menu.addSeparator();
        menu.add(itemRealizarDevolucoes);
        menu.addSeparator();
        menu.add(itemRealizarEmprestimo);

        menuUsuario.add(itemProfessor);
        menuUsuario.add(itemAluno);

        menuObras.add(itemLivros);
        menuObras.add(itemRevistas);

        menu.addSeparator();

        menu.add(itemSair);

        itemAluno.addActionListener(this);
        itemLivros.addActionListener(this);
        itemProfessor.addActionListener(this);
        itemRealizarDevolucoes.addActionListener(this);
        itemRealizarEmprestimo.addActionListener(this);
        itemRevistas.addActionListener(this);
        itemSair.addActionListener(this);
        
        itemAluno.setActionCommand("aluno");
        itemProfessor.setActionCommand("professor");
        itemLivros.setActionCommand("livro");
        itemRevistas.setActionCommand("revista");
        itemRealizarDevolucoes.setActionCommand("devolver");
        itemRealizarEmprestimo.setActionCommand("emprestar");

        bar.add(menu);
        setJMenuBar(bar);

        add(desktop);
    }

    private void adicionarJanela(JInternalFrame janela) {
        desktop.add(janela);
        desktop.moveToFront(janela);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String panel = e.getActionCommand();
        PainelAbstrato panelAbstrato = new FactoryPanel().getPanel(panel);
        JanelaGenerica janelaGenericaInserir = new JanelaGenerica(panelAbstrato);
        adicionarJanela(janelaGenericaInserir);
    }
}

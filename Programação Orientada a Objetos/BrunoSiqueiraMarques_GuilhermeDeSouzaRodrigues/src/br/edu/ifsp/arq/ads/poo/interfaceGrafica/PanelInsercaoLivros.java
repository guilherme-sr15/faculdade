/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.edu.ifsp.arq.ads.poo.bancos.BancoObrasBiblioteca;
import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.entidades.Obras;
import br.edu.ifsp.arq.ads.poo.entidades.Livros;

/**
 *
 * @author Bruno Siqueira
 */
public class PanelInsercaoLivros extends PainelAbstrato implements ActionListener {

    private JButton btnInserir;
    private JLabel lbTitulo, lbQtdExemplares, lbISBN;
    private JTextField fdTitulo, fdQtdExemplares, fdISBN;
    private final BancoObrasBiblioteca banco = BancoObrasBiblioteca.getInstance();

    @Override
    public void criarComponentes() {
        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);

        lbISBN = new JLabel("ISBN:");
        lbQtdExemplares = new JLabel("Quantidade de exemplares desta obra:");
        lbTitulo = new JLabel("Título:");

        fdISBN = new JTextField(5);
        fdQtdExemplares = new JTextField(5);
        fdTitulo = new JTextField(5);

        setLayout(this.getLayout());

        adicionarLayout(this, lbTitulo, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdTitulo, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbQtdExemplares, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdQtdExemplares, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbISBN, 2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdISBN, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnInserir, 3, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
    }

    private void inserirLivros() {
        String nome = fdTitulo.getText();
        String stringIsbn = fdISBN.getText();
        String ex = fdQtdExemplares.getText();
        if (validaString(nome)) {
            if (validaInteiro(stringIsbn)) {
                if (validaInteiro(ex)) {
                    int qtdDeExemplares = Integer.parseInt(ex);
                    int isbn = Integer.parseInt(stringIsbn);
                    Obras livro = addLivro(nome, isbn, qtdDeExemplares);
                    addAoBanco(livro);
                    System.out.println(banco);
                } else {
                    JOptionPane.showMessageDialog(null, "Verifice a quantidade de exemplares! Tente novamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifice o ISBN! Tente novamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifice o nome! Tente novamente");
        }
    }
    

    private Obras addLivro(String nome, int isbn, int qtdDeExemplares) {
        Obras livro = new Livros(nome, isbn);
        for (int i = 1; i <= qtdDeExemplares; i++) {
            Exemplar ex = new Exemplar(i, livro);
            livro.addExemplar(ex);
        }

        return livro;
    }

    private void addAoBanco(Obras obra) {
        boolean b = banco.add(obra);
        if (b) {
            JOptionPane.showMessageDialog(null, "Livro adicionado.");
        } else {
            JOptionPane.showMessageDialog(null, "ISBN já cadastrado.");
        }
    }

    private boolean validaString(String validar) {
        return validar.matches("[a-zA-Z][^\n]*");
    }

    private boolean validaInteiro(String validar) {
        return validar.matches("[0-9]+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInserir) {
            inserirLivros();
        }
    }
}

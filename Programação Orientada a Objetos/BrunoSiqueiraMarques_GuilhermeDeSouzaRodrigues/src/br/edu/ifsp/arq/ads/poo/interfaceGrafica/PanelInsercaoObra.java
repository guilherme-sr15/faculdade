/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Aluno
 */
public class PanelInsercaoObra extends PainelAbstrato {

    private JButton btnInserir;
    private JLabel lbTitulo, lbQtdExemplares, lbEspecificidade1;
    private JTextField fdTitulo, fdQtdExemplares, fdEspecificidade1;

    @Override
    public void criarComponentes() {
        btnInserir = new JButton("Inserir");

        lbEspecificidade1 = new JLabel();
        lbQtdExemplares = new JLabel("Quantidade de exemplares:");
        lbTitulo = new JLabel("Título:");

        fdEspecificidade1 = new JTextField(5);
        fdQtdExemplares = new JTextField(5);
        fdTitulo = new JTextField(5);

        setLayout(this.getLayout());

        adicionarLayout(this, lbTitulo, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdTitulo, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbQtdExemplares, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdQtdExemplares, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbEspecificidade1, 2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdEspecificidade1, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnInserir, 3, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
    }

    /**
     * @return the lbEspecificidade1
     */
    public JLabel getLbEspecificidade1() {
        return lbEspecificidade1;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author Aluno
 */
public abstract class PainelAbstrato extends JPanel {

    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();

    public abstract void criarComponentes();

    protected void adicionarLayout(Container cont, Component comp, int linha, int coluna, int larg, int alt, int preenchimento, int posicao) {

        constraints.gridy = linha;
        constraints.gridx = coluna;

        constraints.gridwidth = larg;
        constraints.gridheight = alt;

        constraints.anchor = posicao;

        constraints.fill = preenchimento;

        constraints.insets = new Insets(10, 10, 10, 10);

        layout.setConstraints(comp, getConstraints());

        cont.add(comp);
    }

    /**
     * @return the layout
     */
    @Override
    public GridBagLayout getLayout() {
        return layout;
    }

    /**
     * @return the constraints
     */
    public GridBagConstraints getConstraints() {
        return constraints;
    }
    
}

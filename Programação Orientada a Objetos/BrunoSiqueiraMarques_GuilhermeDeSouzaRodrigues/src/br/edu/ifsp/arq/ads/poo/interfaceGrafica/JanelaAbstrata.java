/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import javax.swing.JInternalFrame;

/**
 *
 * @author Aluno
 */
public abstract class JanelaAbstrata extends JInternalFrame{ 

    public JanelaAbstrata(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
    }
    protected void ajustarComponentes(){
        setVisible(true);
        pack();
        setResizable(false);
    }      
}

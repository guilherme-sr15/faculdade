/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.prova1.janelas;

import javax.swing.JFrame;

/**
 *
 * @author denis
 */
public abstract class JanelaAbstrata extends JFrame {
    
    public JanelaAbstrata(String titulo) {
        super(titulo);
    }
    
    public void abrirJanela() {
        criarComponentes();
        ajustarPropriedades();
    }
    
    protected abstract void criarComponentes();
    
    protected void ajustarPropriedades() {
        setVisible(true);
        setSize(400,100);
        setLocationRelativeTo(null);
    }
    
}

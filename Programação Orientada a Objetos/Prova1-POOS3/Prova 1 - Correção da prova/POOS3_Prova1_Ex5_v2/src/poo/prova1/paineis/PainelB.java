/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.prova1.paineis;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author denis
 */
public class PainelB extends PainelAbstrato {

    private JLabel labelB;
    private JButton buttonB;
    
    @Override
    public void criarComponentes() {
        labelB = new JLabel("B");
        buttonB = new JButton("B");
        add(labelB);
        add(buttonB);
    }
    
}

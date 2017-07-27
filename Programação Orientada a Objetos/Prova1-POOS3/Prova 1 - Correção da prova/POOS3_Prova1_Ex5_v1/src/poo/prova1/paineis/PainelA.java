/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.prova1.paineis;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author denis
 */
public class PainelA extends PainelAbstrato {

    private JLabel labelA;
    private JTextField fieldA;
    
    @Override
    public void criarComponentes() {
        labelA = new JLabel("A");
        fieldA = new JTextField(5);
        add(labelA);
        add(fieldA);
    }
    
}

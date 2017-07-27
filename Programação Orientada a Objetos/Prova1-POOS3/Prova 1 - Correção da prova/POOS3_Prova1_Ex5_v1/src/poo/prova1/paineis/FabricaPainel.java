/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.prova1.paineis;

/**
 *
 * @author denis
 */
public class FabricaPainel {
    
    public static final String TITULO_A = "A";
    public static final String TITULO_B = "B";
    
    public PainelAbstrato getPainel(String titulo) {
        if(TITULO_A.equals(titulo)) {
            return new PainelA();
        }
        return new PainelB();
    }
}

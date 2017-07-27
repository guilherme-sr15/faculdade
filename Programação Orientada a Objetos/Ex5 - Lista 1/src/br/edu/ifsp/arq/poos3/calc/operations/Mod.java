package br.edu.ifsp.arq.poos3.calc.operations;

import br.edu.ifsp.arq.poos3.calc.calculadora.Operations;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Mod extends Operations {
        
    @Override
    public Number performCalculation(double op1, double op2){
        if (op2 != 0) {
            return (int)op1 % (int)op2;
        }
        return null;
    }
    
    @Override
    public String getName(){
        return " % ";
    }
}

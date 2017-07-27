package br.edu.ifsp.arq.poos3.calc.operations;

import br.edu.ifsp.arq.poos3.calc.calculadora.Operations;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Divide extends Operations {
    
    @Override
    public Number performCalculation(double op1, double op2){
        if (op2 != 0) {
            return op1 / op2;
        }
        return null;
    }   
    
    @Override
    public String getName(){
        return " / ";
    }

}

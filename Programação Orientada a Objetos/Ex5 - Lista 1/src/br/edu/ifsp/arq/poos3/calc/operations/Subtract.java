package br.edu.ifsp.arq.poos3.calc.operations;

import br.edu.ifsp.arq.poos3.calc.calculadora.Operations;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Subtract extends Operations {
    
    @Override
    public Number performCalculation(double op1, double op2){
        return op1 - op2;
    }
    
    @Override
    public String getName(){
        return " - ";
    }
}

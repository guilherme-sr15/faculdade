package br.edu.ifsp.arq.poos3.calc.calculadora;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Result {
    private Number result;
    private Number op1;
    private Number op2;
    private String op;
    
    public Result(Calculadora c, Number result, Operations op){
        this.result = result;
        this.op = op.getName();
        this.op1 = c.getOp1();
        this.op2 = c.getOp2();
    }

    @Override
    public String toString() {
        return op1 + op + op2+ " = " + result;
    }
}

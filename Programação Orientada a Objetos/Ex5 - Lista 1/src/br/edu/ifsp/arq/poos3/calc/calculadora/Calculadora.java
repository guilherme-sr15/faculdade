package br.edu.ifsp.arq.poos3.calc.calculadora;


import javax.swing.JOptionPane;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Calculadora {
    private double op1, op2;
    
    public Calculadora(double op1, double op2){
        this.op1 = op1;
        this.op2 = op2;
    }

    public double getOp1() {
        return op1;
    }

    public double getOp2() {
        return op2;
    }
    
    public void callOperation(Operations op){
        Number n = op.performCalculation(op1, op2);
        Result r = new Result(this, n, op);
        
        if (n != null)
            JOptionPane.showMessageDialog(null, r);
        else
            JOptionPane.showMessageDialog(null, "Operação Inválida!");
    }
}

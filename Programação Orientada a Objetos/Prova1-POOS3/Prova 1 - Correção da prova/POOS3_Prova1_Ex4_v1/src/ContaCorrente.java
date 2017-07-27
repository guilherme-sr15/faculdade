/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class ContaCorrente extends Conta {
    
    private double limite;
    
    public ContaCorrente(String cliente, double saldo, double limite) {
        super(cliente, saldo);
        this.limite = limite;
    }
    
    @Override
    public boolean sacar(double valor) {
        if(getSaldo() + limite >= valor) {
            double novoSaldo = getSaldo() - valor;
            setSaldo(novoSaldo);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Conta Corrente";
    }
}

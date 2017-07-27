/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(String cliente, double saldo) {
        super(cliente, saldo);
    }
    
    @Override
    public boolean sacar(double valor) {
        if(getSaldo() >= valor) {
            double novoSaldo = getSaldo() - valor;
            setSaldo(novoSaldo);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Conta Poupança";
    }
}

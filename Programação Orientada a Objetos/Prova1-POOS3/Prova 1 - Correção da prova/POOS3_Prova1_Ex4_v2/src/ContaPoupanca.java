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
    protected boolean validarSaque(double valor) {
        return getSaldo() >= valor;
    }
    
    @Override
    public String toString() {
        return "Conta Poupança";
    }
}

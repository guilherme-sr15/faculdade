/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public abstract class Conta {
    
    private int numero;
    private String cliente;
    private double saldo;
    private static int cont;
    
    public Conta(String cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.numero = ++Conta.cont;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public int getNumero() {
        return numero;
    }
    
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(double valor) {
        this.saldo += valor;
    }
    
    public abstract boolean sacar(double valor);
}

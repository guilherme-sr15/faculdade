/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Principal {

    public static void main(String[] args) {
        Conta cc1 = new ContaCorrente("Dênis",1000.0,500.0);
        Conta cc2 = new ContaCorrente("João",10000.0,5000.0);
        Conta cp1 = new ContaPoupanca("Maria",5000.0);
        
        GerenciaConta gerencia1 = GerenciaConta.getInstance();
        
        gerencia1.addConta(cc1);
        gerencia1.addConta(cc2);
        gerencia1.addConta(cp1);
        
        GerenciaConta gerencia2 = GerenciaConta.getInstance(); //mesmo objeto GerenciaConta
        
        Conta conta; 
        
        conta = gerencia2.buscarConta(1);
        
        if(conta.sacar(1500.0)) {
            System.out.println(conta);
            System.out.println(String.format("Saque Realizado. Saldo restante = %s",conta.getSaldo()));
        }
        
        conta = gerencia2.buscarConta(3);
        
        if(conta.sacar(4000.0)) {
            System.out.println(conta);
            System.out.println(String.format("Saque Realizado. Saldo restante = %s",conta.getSaldo()));
        }
    }
    
}

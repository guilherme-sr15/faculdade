/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */

import javax.swing.JOptionPane;

public class ContaBancaria {
    //variáveis de instância(cores diferentes das locais)
    int codigo; 
    double saldo;
    String nomeCliente;
    
    void sacar(double valor){
       if (saldo >= valor){
           saldo -= valor;
       } 
    }
    
    void depositar(double valor){
        saldo += valor;
    }
    
    void consultarDados(){
        String dados = "Cliente: "+nomeCliente+"\nSaldo: "+saldo;
        JOptionPane.showMessageDialog(null, dados);
    }
}

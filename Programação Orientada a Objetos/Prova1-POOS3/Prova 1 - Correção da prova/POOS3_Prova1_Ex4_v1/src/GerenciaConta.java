/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class GerenciaConta {
    
    private final int MAX = 10;
    private Conta[] contas;
    private int cont;
    
    private static GerenciaConta gerencia;
    
    private GerenciaConta() {
        contas = new Conta[MAX];
    }
    
    public boolean addConta(Conta conta) {
        if(cont < MAX) {
            contas[cont++] = conta;
            return true;
        }
        return false;
    }
    
    public Conta buscarConta(int numero) {
        for(int i = 0; i < cont; i++) {
            if(contas[i].getNumero() == numero) {
                return contas[i];
            }
        }
        return null;
    }
    
    public static GerenciaConta getInstance() {
        if(gerencia == null) {
            gerencia = new GerenciaConta();
        }
        return gerencia;
    }
}

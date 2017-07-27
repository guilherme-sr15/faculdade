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

public class Empregado {
    String nome;
    float salarioBase;
    float salarioFinal;
    
    void receberSalario(float valor){
        salarioBase = valor;
    }
    void calcularSalarioFinal(float percentual){
        percentual = percentual / 100; 
        salarioFinal = salarioBase + (salarioBase*percentual);
    }    
    
    void consultar(){
            String dados;
            dados = "Salario base: " + salarioBase + "\nSalario final: " + salarioFinal;
            JOptionPane.showMessageDialog(null, dados);
        }
}

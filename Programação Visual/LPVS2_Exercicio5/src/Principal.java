/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Principal {
    public static void main(String[] args) {
        Empregado e1;
        e1 = new Empregado();
        
        e1.receberSalario(1000);
        e1.calcularSalarioFinal(10);
        e1.consultar();
    }
    
}

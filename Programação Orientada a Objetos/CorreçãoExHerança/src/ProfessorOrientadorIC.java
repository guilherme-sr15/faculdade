/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class ProfessorOrientadorIC extends ProfessorOrientador {
    
    public static final int AULAS = 4;
    
    public ProfessorOrientadorIC(String nome, double horaAtividade, double salarioBase, int quantTrabalhos) {
        super(nome, horaAtividade, salarioBase, quantTrabalhos);
    }
    
    @Override
    public double calcularComissao() {
        return getQuantTrabalhos() * AULAS * Professor.VALOR_AULA;
    }
}

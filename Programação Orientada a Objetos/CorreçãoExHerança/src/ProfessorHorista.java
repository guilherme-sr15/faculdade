/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class ProfessorHorista extends Professor {
    
    private int quantAulas;
    
    public static final double SEMANAS = 5.25;
    
    public ProfessorHorista(){
        super();
    }
    
    public ProfessorHorista(String nome, double horaAtividade, int quantAulas) {
        super(nome, horaAtividade);
        this.quantAulas = quantAulas;
    }
    
    @Override
    public double calcularSalario() {
        return quantAulas * Professor.VALOR_AULA * ProfessorHorista.SEMANAS + getHoraAtividade();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class ProfessorMensalista extends Professor {
    
    private double salarioBase;
    
    public ProfessorMensalista(){
        super();
    }
    
    public ProfessorMensalista(String nome, double horaAtividade, double salarioBase) {
        super(nome, horaAtividade);
        this.salarioBase = salarioBase;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + getHoraAtividade();
    }
}

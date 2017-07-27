/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Aluno
 */
public class ProfessorMensalista extends Professor{
    private final double baseIncome = 7500.0;
    
    public ProfessorMensalista(String name, double actValue){
        super(name, actValue);
        
    }
    
    @Override
    private double calculateIncome(){
        return baseIncome+actValue;
    }
}

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
public class ProfessorHorista extends Professor{
    private int classesQtd;
    
    
    
    
    public ProfessorHorista(String name, int classesQtd, double classValue, double actValue){
        super(name, actValue);
        this.classesQtd = classesQtd;
        this.income = calculateIncome();
    }
    
    @Override
    private double calculateIncome(){
        return (classesQtd*Professor.CLASS_VALUE)*5.25 + Professor.actValue; 
    }
}

/*
 * @author denis
 */

public class Principal {
    
    public static void main(String[] args) {
        
        ProfessorHorista horista = new ProfessorHorista();
        ProfessorMensalista mensalista = new ProfessorMensalista();
        
        RelatorioProfessor rel = new RelatorioProfessor();
        rel.imprimeSalario(horista);
        rel.imprimeSalario(mensalista);
        
        
        
        /*
        ProfessorHorista horista = new ProfessorHorista("Maria", 200, 20);
        
        ProfessorOrientadorIC orientadorIC = new ProfessorOrientadorIC("Dênis", 200, 4000, 10);
        
        ProfessorOrientadorTCC orientadorTCC = new ProfessorOrientadorTCC("João", 200, 4000, 4);
        
        System.out.println(horista.calcularSalario());
        System.out.println(orientadorIC.calcularSalario());
        System.out.println(orientadorTCC.calcularSalario());
        */
    }
}

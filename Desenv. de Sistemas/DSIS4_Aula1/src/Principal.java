
/**
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        Empregado emp1 = new Empregado("Teste1", "1231");
        Empregado emp2 = new Empregado("Teste2", "1232");
        Empregado emp3 = new Empregado("Teste3", "1233");
        Empregado emp4 = new Empregado("Teste4", "1234");
        Empregado emp5 = new Empregado("Teste5", "1235");
        EmpregadoBD empBD = new EmpregadoBD();
        try{
            empBD.salvar(emp1);
            empBD.salvar(emp2);
            empBD.salvar(emp3);
            empBD.salvar(emp4);
            empBD.salvar(emp5);
            //emp.remover(emp5);
            //emp.alterar("Teste", emp4); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

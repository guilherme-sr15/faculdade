/*
 * @author denis
 */

public class ProfessorOrientador extends ProfessorMensalista {
    
    private int quantTrabalhos;
    
    public ProfessorOrientador(String nome, double horaAtividade, double salarioBase, int quantTrabalhos) {
        super(nome, horaAtividade, salarioBase);
        this.quantTrabalhos = quantTrabalhos;
    }
    
    public int getQuantTrabalhos() {
        return quantTrabalhos;
    }
    
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + calcularComissao();
    }
    
    public double calcularComissao() {
        return 0.0;
    }
}

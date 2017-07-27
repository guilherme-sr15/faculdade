/*
 * @author denis
 */

public abstract class Professor {
    
    private String nome;
    private double horaAtividade;
    private final int CODIGO;
    private static int cont;
    
    public static final double VALOR_AULA = 20.00;
    
    public Professor() {
        this("", 100.0);
    }
    
    public Professor(String nome, double horaAtividade) {
        this.nome = nome;
        this.horaAtividade = horaAtividade;
        Professor.cont++;
        this.CODIGO = Professor.cont;
    }
    
    public double getHoraAtividade() {
        return horaAtividade;
    }
    
    public int getCODIGO() {
        return CODIGO;
    }
    
    public abstract double calcularSalario();
}

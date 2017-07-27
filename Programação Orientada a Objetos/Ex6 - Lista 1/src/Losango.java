
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Losango extends FiguraGeometrica {
    private double diagMaior;
    private double diagMenor;
    
    public Losango(double diagMaior, double diagMenor){
        this.diagMaior = diagMaior;
        this.diagMenor = diagMenor;
    }
    
    @Override
    public double calcularArea(){
        return ((diagMaior*diagMenor)/2);
    }
    
    @Override
    public String toString() {
        return String.format("Losango, área de %.2f", calcularArea());
    }

}

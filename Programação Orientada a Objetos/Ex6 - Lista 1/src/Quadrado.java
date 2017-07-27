
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Quadrado extends FiguraGeometrica {
    private double lado1;
    private double lado2;
    
    public Quadrado(double lado1, double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    @Override
    public double calcularArea(){
        return lado1 * lado2;
    }

    @Override
    public String toString() {
        return String.format("Quadrado, área de %.2f", calcularArea());
    }
    
    
}

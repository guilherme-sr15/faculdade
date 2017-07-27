
/**
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        GerenciaNumeros g1 = new GerenciaNumeros();
        GerenciaNumeros g2 = new GerenciaNumeros();
        for(int i = 0; i < 10; i++){
            g1.adicionar((int)(Math.random()*100 + 1));
            g2.adicionar((int)(Math.random()*100 + 1));
        }
        System.out.println("Conjunto 1: " + g1.getNumeros());
        System.out.println("Conjunto 2: " + g2.getNumeros());
        System.out.println("União: " + g1.uniao(g2.getNumeros()));
        System.out.println("Intersecção: " + g1.interseccao(g2.getNumeros()));
        System.out.println("Conjunto 1: " + g1.getNumeros());
        System.out.println("Conjunto 2: " + g2.getNumeros());
        System.out.println("Maior do conjunto 1: " + g1.getMaior());
        System.out.println("Maior do conjunto 2: " + g2.getMaior());
        System.out.println("Menor do conjunto 1: " + g1.getMenor());
        System.out.println("Menor do conjunto 2: " + g2.getMenor());
    }
}

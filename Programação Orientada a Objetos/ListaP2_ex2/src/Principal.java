
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        GerenciaNumeros gl = new GerenciaNumeros();
        
        gl.preencherLista();
        
        System.out.println("Original: " +gl.getLista());
        gl.ordenaCrescente();
        System.out.println("Ordenada crescente: " + gl.getLista());
        gl.ordenaDecrescente();
        System.out.println("Ordenada decrescente: " + gl.getLista());
    }
}

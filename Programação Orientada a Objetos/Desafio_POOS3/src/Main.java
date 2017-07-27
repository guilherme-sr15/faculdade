/*
 * @author Guilherme de Souza Rodrigues
 */

public class Main {
    public static void main(String[] args) {
        Pessoa p1, p2, p3;
        
        p1 = Pessoa.getInstance("Guilherme", 21);
        p2 = Pessoa.getInstance("Teste1", 21);
        p3 = Pessoa.getInstance("Teste2", 21);
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
    }
}

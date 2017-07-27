/*
 * @author Guilherme de Souza Rodrigues
 */

public class Main {
    public static void main(String[] args) {
        Pessoa p1, p2, p3;
        
        p1 = new Pessoa(Pessoa.createPessoa("Guilherme", 21));
        p2 = new Pessoa("Guilherme1", 21);
        p3 = new Pessoa("Guilherme2", 21);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}

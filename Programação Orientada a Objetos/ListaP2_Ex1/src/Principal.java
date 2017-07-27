
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        GerenciaPessoa gerencia = new GerenciaPessoa();
        Pessoa p1 = new Pessoa("Fernando", 123, 41);
        Pessoa p2 = new Pessoa("Dênis", 456, 33);
        Pessoa p3 = new Pessoa("Fernando", 789, 23);
        Pessoa p4 = new Pessoa("Dênis", 321, 50);
        gerencia.addPessoa(p1);
        gerencia.addPessoa(p2);
        gerencia.addPessoa(p3);
        gerencia.addPessoa(p4);
        
        
        
        System.out.println("Pessoa na posicao 1: " + gerencia.returnOnIdex(1));
        System.out.println("Posicao da pessoa Fernando: " + gerencia.getPosicao(p1));
        System.out.println(gerencia.getPessoas());
        gerencia.remover(p2);
        System.out.println("Removeu Dênis: " + gerencia.getPessoas());
        gerencia.remover("Fernando");
        System.out.println("Removeu Fernando: " + gerencia.getPessoas());
        
        System.out.println(gerencia.getDados());
    }
}

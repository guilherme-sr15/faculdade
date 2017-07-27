


/**
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    static GerenciaSala sala = new GerenciaSala();
    
    private static void adicionar(Cadeira c, int fileira){
        if(sala.adicionarCadeira(c, 0)){
            System.out.println("Cadeira adicionada com sucesso!");
        }else{
            System.out.println("Cadeira não adicionada!");
        }
    }
    
    private static void sentar(Cadeira c, int fileira){
        if(sala.sentar(fileira, c)){
            System.out.println("Sentou!");
        }else{
            System.out.println("Não sentou!");
        }
    }
    
    private static void levantar(Cadeira c, int fileira){
        if(sala.levantar(fileira, c)){
            System.out.println("Levantou!");
        }else{
            System.out.println("Não levantou!");
        }
    }
    
    public static void main(String[] args) {
        Cadeira c1 = new Cadeira(EstadoCadeira.VAZIA,TipoCadeira.DESTRO);
        Cadeira c2 = new Cadeira(EstadoCadeira.VAZIA,TipoCadeira.CANHOTO);
        Cadeira c3 = new Cadeira(EstadoCadeira.VAZIA,TipoCadeira.DESTRO);
        Cadeira c4 = new Cadeira(EstadoCadeira.VAZIA,TipoCadeira.CANHOTO);
        
        adicionar(c1, 0);
        adicionar(c2, 0);
        adicionar(c3, 2);
        adicionar(c4, 1);
        
        System.out.println("Sala: " + sala.getFileiras());
        
        sentar(c2, 0);
        
        System.out.println("Sala: " + sala.getFileiras());
        
        levantar(c2, 0);
        
        System.out.println("Sala: " + sala.getFileiras());
    }
}

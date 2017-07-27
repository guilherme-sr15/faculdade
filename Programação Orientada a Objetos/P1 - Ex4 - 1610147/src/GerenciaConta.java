
/*
 * @author Guilherme de Souza Rodrigues
 */

public class GerenciaConta {
    private ContaBancaria[] lista;
    private int cont;
    public static final int LIMITE = 10;
    
    private static GerenciaConta gerenciaConta;
    
    private GerenciaConta(){
       this.lista = new ContaBancaria[GerenciaConta.LIMITE];
    }
    
    public boolean adicionaConta(ContaBancaria c){
        if(cont < GerenciaConta.LIMITE){
            lista[cont] = c;
            cont++;
            return true;
        }
        return false;
    }
    
    public boolean sacar(int nroConta, double valor){
        for(int i = 0; i<lista.length;i++){
            if (lista[i].getNroConta() == nroConta)
                return lista[i].saque(valor);
        }
        return false;
    }
    
    public static GerenciaConta getInstance(){
        if(gerenciaConta == null)
            gerenciaConta = new GerenciaConta();
        return gerenciaConta;
    }
}

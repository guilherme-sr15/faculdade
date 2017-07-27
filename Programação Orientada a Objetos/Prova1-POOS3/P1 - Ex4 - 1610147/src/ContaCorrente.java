
/*
 * @author Guilherme de Souza Rodrigues
 */

public class ContaCorrente extends ContaBancaria{
    private double limite;
    
    public ContaCorrente(String nome, double saldo, double limite){
        super(nome, saldo);
        this.limite = limite;
    }
            
    @Override
    public boolean saque(double valor){
        if(valor <= ContaBancaria.getSaldo()+limite){
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }
    
    @Override
    public void deposito(double valor){
        setSaldo(getSaldo() + valor);
    }
}

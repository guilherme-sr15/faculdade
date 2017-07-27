
/*
 * @author Guilherme de Souza Rodrigues
 */

public class ContaPoupanca extends ContaBancaria{
    
    public ContaPoupanca(String nome, double saldo){
        super(nome, saldo);
    }
    
    @Override
    public boolean saque(double valor){
        if (valor <= getSaldo()){
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    } //ok
    
    @Override
    public void deposito(double valor){
        setSaldo(getSaldo() + valor);
    }
}

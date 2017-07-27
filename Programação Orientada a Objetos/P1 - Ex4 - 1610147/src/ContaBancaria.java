
/*
 * @author Guilherme de Souza Rodrigues
 */

public abstract class ContaBancaria {
    private final int NRO_CONTA;
    private static int cont = 0;
    private String nome;
    private static double saldo;
    
    public ContaBancaria(String nome, double saldo){
        this.NRO_CONTA = ++ContaBancaria.cont;
        this.nome = nome;
        this.saldo = saldo;
    }
    
    public int getNroConta(){
        return this.NRO_CONTA;
    }
    
    public static double getSaldo(){
        return saldo;
    }
    
    public static void setSaldo(double valor){
        saldo = valor;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nNro da conta: %d\nSaldo: R$ %.2f", nome, NRO_CONTA, saldo);
    }
    
    public abstract boolean saque(double valor);
    public abstract void deposito(double valor);
}

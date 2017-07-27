
import javax.swing.JOptionPane;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente("Guilherme", 100, 1000);
        ContaPoupanca c2 = new ContaPoupanca("Guilherme", 100);
        
        GerenciaConta gerencia = GerenciaConta.getInstance();
        
        gerencia.adicionaConta(c1);
        gerencia.adicionaConta(c2);
        
        JOptionPane.showMessageDialog(null, c1);
        JOptionPane.showMessageDialog(null, c2);
        
        c1.deposito(100);
        
        JOptionPane.showMessageDialog(null, "Saldo de R$ " + c1.getSaldo());
        if(gerencia.sacar(2,50))
            JOptionPane.showMessageDialog(null, "Novo saldo de R$ " + c2.getSaldo());
        else
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");

    }
}

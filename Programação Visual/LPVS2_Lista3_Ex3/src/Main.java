import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String name;
        int pNumber;
        int cNumber;
        
        name = JOptionPane.showInputDialog("Informe o nome: ");
        pNumber = Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone pessoal: "));
        cNumber = Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone comercial: "));
        
        Pessoas pessoa1 = new Pessoas(name, pNumber, cNumber);
        
        JOptionPane.showMessageDialog(null, pessoa1);
    }
}

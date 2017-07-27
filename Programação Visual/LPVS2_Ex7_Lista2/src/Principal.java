import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        String nome, vaga;
        String temp;
        float nota1, nota2;
        String print;
        float media;
        
        nome = JOptionPane.showInputDialog("Digite o nome: ");
        vaga = JOptionPane.showInputDialog("Digite a vaga: ");
        temp = JOptionPane.showInputDialog("Digite a nota 1: ");
        nota1 = Float.parseFloat(temp);
        nota2 = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota 2: "));
        
        
        Candidato c1 = new Candidato();
        
        media = c1.calcularMediaAritimetica(nota1, nota2);
        
        c1.inicializarDados(nome, vaga, nota1, nota2, media); 
        
        print = c1.consultarDados();
        JOptionPane.showMessageDialog(null, print, "Dados do candidato", JOptionPane.INFORMATION_MESSAGE);
    }
}

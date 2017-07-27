import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Veiculo v1 = new Veiculo("M", 10, 200, true, 20);
        String marca, s;
        float km, comb, kmL;
        boolean sit, andou;
        float distancia;
        
        marca = JOptionPane.showInputDialog("Informe a marca: ");
        km = Float.parseFloat(JOptionPane.showInputDialog("Informe a quilometragem: "));
        comb = Float.parseFloat(JOptionPane.showInputDialog("Informe a qtde de combustível: "));
        kmL = Float.parseFloat(JOptionPane.showInputDialog("Informe km/L: "));
        sit  = Boolean.parseBoolean(JOptionPane.showInputDialog("Informa a situação(True ou False): "));
        
        //v1.inicializarDados(marca, km, comb, true, kmL);
        
        //v1.manutencao();
        //v1.sairManutencao();
        
        distancia = Float.parseFloat(JOptionPane.showInputDialog("Informe a distância: "));
        
        andou = v1.andar(distancia);
        
        if(andou)
            JOptionPane.showMessageDialog(null, "Andou", null, JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Não andou", null, JOptionPane.INFORMATION_MESSAGE);
        
        s = v1.informarDados();
       
        JOptionPane.showMessageDialog(null, s, "Dados do veiculo", JOptionPane.INFORMATION_MESSAGE);
        
        }
}

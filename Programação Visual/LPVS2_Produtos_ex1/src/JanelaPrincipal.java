import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class JanelaPrincipal extends JFrame implements ActionListener{
    private JPanel panel;
    private JLabel labelName;
    private JLabel labelEstoque;
    private JLabel labelPrice;
    private JTextField fieldName;
    private JTextField fieldEstoque;
    private JTextField fieldPrice;
    private JButton buttonOk;
    
    public JanelaPrincipal(){
        criaComponentes();
        ajustaPropriedades();
    }
    
    private void criaComponentes(){
        panel = new JPanel();
        
        labelName = new JLabel("Nome: ");
        //labelName.setText("x"); //Troca o nome da label
        labelEstoque = new JLabel("Estoque: ");
        labelPrice = new JLabel("Preço: ");
        
        fieldName = new JTextField(10);
        fieldEstoque = new JTextField(5);
        fieldPrice = new JTextField(5);       
        buttonOk = new JButton("OK");
        buttonOk.addActionListener(this);
        
        adicionaComponentes();
    }
    
    private void ajustaPropriedades(){
        setTitle("Exercíco Lista 3");
        setVisible(true);
        //setSize(600,400); -> larg x alt
        pack();//define o tamanho mínimo necessário para os componentes na tela
        setResizable(false);
        setLocationRelativeTo(null);//coloca a janela no centro da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void adicionaComponentes(){
        panel.add(labelName);
        panel.add(fieldName);
        panel.add(labelEstoque);
        panel.add(fieldEstoque);
        panel.add(labelPrice);
        panel.add(fieldPrice);
        panel.add(buttonOk);
        add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonOk){
            //System.out.println("Botão clicado!");
            String name = fieldName.getText();
            int estoque = Integer.parseInt(fieldEstoque.getText());
            float price = Float.parseFloat(fieldPrice.getText());
            float total = estoque * price;
            
            Produto p1;
            p1 = new Produto(name, price, estoque);
            
            JOptionPane.showMessageDialog(null, p1);
        }
    }
    
    
}
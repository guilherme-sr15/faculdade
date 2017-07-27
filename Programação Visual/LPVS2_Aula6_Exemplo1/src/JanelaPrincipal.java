import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JanelaPrincipal extends JFrame implements ActionListener{
    private JPanel panel;
    private JLabel labelName;
    private JLabel labelName1;
    private JLabel labelName2;
    private JLabel labelArea;
    private JTextField fieldName1;
    private JTextField fieldName2;
    //private JTextField fieldPrice;
    private JButton buttonCreate;
    private JButton buttonCompare;
    private JButton buttonClear;
    private JTextArea areaNames; //mostra texto em mútiplas linhas
    private JScrollPane scrollNames; //habilita barras de rolagem
    Pessoa p1;
    Pessoa p2;
    
            
    public JanelaPrincipal(){
        criaComponentes();
        ajustaPropriedades();
    }
    
    private void criaComponentes(){
        panel = new JPanel();
        
        labelName1 = new JLabel("Nome 1: ");
        labelName2 = new JLabel("Nome 2: ");
        labelArea = new JLabel("Nomes já digitados: ");
        //labelName.setText("x"); //Troca o nome da label
        
        fieldName1 = new JTextField(10);
        fieldName2 = new JTextField(10);
             
        buttonCreate = new JButton("Criar");
        buttonCreate.addActionListener(this);
        buttonCompare = new JButton("Comparar");
        buttonCompare.addActionListener(this);
        buttonClear = new JButton("Limpar");
        buttonClear.addActionListener(this);
        
        areaNames = new JTextArea(10,10); //alt x larg
        
        scrollNames = new JScrollPane();
        scrollNames.setViewportView(areaNames);
        
        adicionaComponentes();
    }
    
    private void ajustaPropriedades(){
        fieldName1.grabFocus(); //coloca o cursor no field especiifcado
        buttonCompare.setEnabled(false); //botão fica desabilitado
        buttonClear.setEnabled(false); 
        areaNames.setEditable(false); //area se torna não editavel
        setTitle("Comparar nomes");
        setVisible(true);
        //setSize(600,400); -> larg x alt
        pack();//define o tamanho mínimo necessário para os componentes na tela
        setResizable(false); //não permite reajustar o tamanho da janela
        setLocationRelativeTo(null);//coloca a janela no centro da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void adicionaComponentes(){
        panel.add(labelName1);
        panel.add(fieldName1);
        panel.add(labelName2);
        panel.add(fieldName2);
        panel.add(buttonCreate);
        panel.add(buttonCompare);
        panel.add(labelArea);
        panel.add(scrollNames);
        panel.add(buttonClear);
        this.add(panel);
    }
    
    private void setNames(){
        p1 = new Pessoa(fieldName1.getText());
        p2 = new Pessoa(fieldName2.getText());
        String names = p1.getName() + "\n" + p2.getName() + "\n";
        areaNames.append(names + "\n");
        buttonCompare.setEnabled(true);
        buttonClear.setEnabled(true);

        fieldName1.setText("");
        fieldName1.grabFocus();
        fieldName2.setText("");
        }
    
    private void compNames(){
        if (p1.compareNames(p2)){
            JOptionPane.showMessageDialog(null, "Nomes iguais!");
            buttonCompare.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Nomes diferentes!");
            buttonCompare.setEnabled(false);
            if (p1.getStringLength(p1.getName())> p2.getStringLength(p2.getName()))
                JOptionPane.showMessageDialog(null, "O maior nome é " + p1);
            if (p1.getStringLength(p1.getName())< p2.getStringLength(p2.getName()))
                JOptionPane.showMessageDialog(null, "O maior nome é " + p2);
            if (p1.getStringLength(p1.getName())== p2.getStringLength(p2.getName()))
                JOptionPane.showMessageDialog(null, "Os nomes tem o mesmo tamanho. ");
        }
    }
    
    private void clear(){
        areaNames.setText("");
        buttonClear.setEnabled(false);
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonCreate){
            setNames();
        }else if(e.getSource() == buttonCompare){
            compNames();
        }else{
            clear();
        }
    }
}
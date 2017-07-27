
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class JanelaGrafica extends JFrame implements ActionListener{
    
    private ListaFiguras lista;
    
    private JPanel panel;
    
    private ButtonGroup group;
      
    private JRadioButton buttonQuadrado;
    private JRadioButton buttonTriangulo;
    private JRadioButton buttonLosango;
   
    private JLabel labelValor1;
    private JLabel labelValor2;
    
    private JTextField fieldValor1;
    private JTextField fieldValor2;
    
    private JButton buttonListar;
    private JButton buttonAdicionar;
    private JButton buttonBuscar;
    
    private Quadrado q;
    private Triangulo t;
    private Losango l;
    
    private JTextArea areaTexto;
    
    private JScrollPane scrollPane;
  
    public JanelaGrafica(){
        lista = new ListaFiguras();
        
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        
        buttonListar = new JButton("Listar");
        buttonListar.addActionListener(this);
        buttonAdicionar = new JButton("Adicionar");
        buttonAdicionar.addActionListener(this);
        buttonBuscar = new JButton("Buscar");
        buttonBuscar.addActionListener(this);
        
        labelValor1 = new JLabel("Lado 1:");
        labelValor2 = new JLabel("Lado 2:");
        
        buttonQuadrado = new JRadioButton("Quadrado");
        buttonQuadrado.addActionListener(this);
        buttonQuadrado.setSelected(true);
        buttonTriangulo = new JRadioButton("Triângulo");
        buttonTriangulo.addActionListener(this);
        buttonLosango = new JRadioButton("Losango");
        buttonLosango.addActionListener(this);

        group = new ButtonGroup();
        group.add(buttonQuadrado);
        group.add(buttonTriangulo);
        group.add(buttonLosango);
        
        fieldValor1 = new JTextField(5);
        fieldValor2 = new JTextField(5);
        
        areaTexto = new JTextArea(10,10);
        
        scrollPane = new JScrollPane(areaTexto);
        
        addComponentes();
    }
    
    private void addComponentes(){
        panel.add(labelValor1);
        panel.add(fieldValor1);
        panel.add(labelValor2);
        panel.add(fieldValor2);
        panel.add(buttonQuadrado);
        panel.add(buttonTriangulo);
        panel.add(buttonLosango);
        panel.add(buttonAdicionar);
        panel.add(buttonBuscar);
        panel.add(buttonListar);
        add(panel);
    }
    
    private void configurarJanela(){
        setTitle("Figuras Geométricas");
        setVisible(true);
        setResizable(false);
        setSize(900,75);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void adicionarFigura(){
        String valor1 = fieldValor1.getText().trim();
        String valor2 = fieldValor2.getText().trim();
        if(valor1.matches("^[0-9]*[.]{0,1}[0-9]*$")){
            if(valor2.matches("^[0-9]*[.]{0,1}[0-9]*$")){
                double v1 = Double.parseDouble(valor1);
                double v2 = Double.parseDouble(valor2);
                if(buttonQuadrado.isSelected())
                    adicionarQuadrado(v1, v2);
                else if(buttonTriangulo.isSelected())
                    adicionarTriangulo(v1, v2);
                else
                    adicionarLosango(v1, v2);
            }
        }
    }
    
    private void adicionarQuadrado(double v1, double v2){
        q = new Quadrado(v1, v2);
        System.out.println(lista.adicionaFiguras(q));
    }
    
    private void adicionarTriangulo(double v1, double v2){
        t = new Triangulo(v1, v2);
        System.out.println(lista.adicionaFiguras(t));
    }
    
    private void adicionarLosango(double v1, double v2){
        l = new Losango(v1, v2);
        System.out.println(lista.adicionaFiguras(l));
    }
    
    private void buscarFigura(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a posição: "));
        if (pos <= 0)
            JOptionPane.showMessageDialog(null, "Posição inicial é 1.");
        else{
            FiguraGeometrica f = lista.retornaFigura(pos);
            if (f != null)
                JOptionPane.showMessageDialog(null, f);
            else
                JOptionPane.showMessageDialog(null, "Posição vazia!");
        }
    }
    
    private void listarFiguras(){
        areaTexto.setText(lista.toString());
        if(!lista.estaVazia())
            JOptionPane.showMessageDialog(null, scrollPane);
        else
            JOptionPane.showMessageDialog(null, "Lista vazia!");
    }
    
    private void mudarLabel(ActionEvent e){
        if(e.getSource() == buttonQuadrado){
            labelValor1.setText("Lado 1:");
            labelValor2.setText("Lado 2:");
        }else if(e.getSource() == buttonTriangulo){
            labelValor1.setText("Base:");
            labelValor2.setText("Altura:");
        }else{
            labelValor1.setText("Diag. Maior:");
            labelValor2.setText("Diag. Menor:");
        }
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAdicionar)
            adicionarFigura();
        else if (e.getSource() == buttonListar)
            listarFiguras();
        else if (e.getSource() == buttonBuscar)
            buscarFigura();
        else 
            mudarLabel(e);
    }
}

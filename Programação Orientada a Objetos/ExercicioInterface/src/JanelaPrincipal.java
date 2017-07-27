
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/*
 * @author Guilherme de Souza Rodrigues
 */

public class JanelaPrincipal extends JFrame implements ActionListener{

    private JPanel panelPrincipal;
    private JPanel panelEletro;
    private JPanel panelAcao;
    
    private JButton buttonAdicionar;
    private JButton buttonLigar;
    private JButton buttonDesligar;
    
    private JRadioButton buttonCelular;
    private JRadioButton buttonNotebook;
    private JRadioButton buttonTV;
    private JRadioButton buttonLigado;
    private JRadioButton buttonDesligado;
    
    private ButtonGroup grupoEletro;
    private ButtonGroup grupoEstado;
    
    private FabricaEletronico fabrica;
    
    private GerenciaEletronico lista;
    
    public JanelaPrincipal(){
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        panelPrincipal = new JPanel();
        
        lista = new GerenciaEletronico();
        
        panelEletro = new JPanel();
        panelEletro.setBorder(BorderFactory.createTitledBorder("Selecione um tipo de eletrônico e um estado"));
        
        panelAcao = new JPanel();
        panelAcao.setBorder(BorderFactory.createTitledBorder("Selecione uma ação"));

        grupoEletro = new ButtonGroup();
        grupoEstado = new ButtonGroup();
        
        buttonAdicionar = new JButton("Adicionar");
        buttonAdicionar.addActionListener(this);
        
        buttonCelular = new JRadioButton("Celular");
        buttonCelular.setSelected(true);
        buttonCelular.setActionCommand("Celular");
        buttonNotebook = new JRadioButton("Notebook");
        buttonNotebook.setActionCommand("Notebook");
        buttonTV = new JRadioButton("TV");
        buttonTV.setActionCommand("TV");
        
        grupoEletro.add(buttonCelular);
        grupoEletro.add(buttonNotebook);
        grupoEletro.add(buttonTV);
        
        buttonLigado = new JRadioButton("Ligado");
        buttonLigado.setActionCommand("Ligado");
        buttonDesligado = new JRadioButton("Desligado");
        buttonDesligado.setActionCommand("Desligado");
        buttonDesligado.setSelected(true);
        
        grupoEstado.add(buttonLigado);
        grupoEstado.add(buttonDesligado);
        
        buttonLigar = new JButton("Ligar");
        buttonLigar.addActionListener(this);
        buttonDesligar = new JButton("Desligar");
        buttonDesligar.addActionListener(this);
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes(){
        panelEletro.add(buttonCelular);
        panelEletro.add(buttonNotebook);
        panelEletro.add(buttonTV);
        panelEletro.add(buttonLigado);
        panelEletro.add(buttonDesligado);
        panelEletro.add(buttonAdicionar);
        panelAcao.add(buttonLigar);
        panelAcao.add(buttonDesligar);
        panelPrincipal.add(panelEletro);
        panelPrincipal.add(panelAcao);
        add(panelPrincipal);
        
    }
    
    private void configurarJanela(){
        setTitle("Eletrônicos");
        setVisible(true);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private boolean setEstadoInicial(){
        if(grupoEstado.getSelection().getActionCommand().equals("Ligado"))
                return true;
        return false;
    }
    
    private void adicionarEletronico(){
        fabrica = new FabricaEletronico();
        boolean estado = setEstadoInicial();
        Eletronico eletro = fabrica.getEletro(grupoEletro.getSelection().getActionCommand(), estado);
        System.out.println(String.format("Log: %b\nAdicionado na posição: %d\nEstado: %s\n", lista.adicionarEletronico(eletro), lista.getIndex(), stringEstado())); 
    }
    
    private String stringEstado(){
        return grupoEstado.getSelection().getActionCommand();
    }
    
    private void ligarEletro(){
        int ligar = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posição do eletrônico: "));
        if (ligar <= 0)
            JOptionPane.showMessageDialog(null, "Posição inicial é 1.");
        else{
            boolean l = lista.ligarEletro(ligar);
            if (l)
                JOptionPane.showMessageDialog(null, "Ligado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi ligado!");
        }
    }
    
    private void desligarEletro(){
        int ligar = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posição do eletrônico: "));
        if (ligar <= 0)
            JOptionPane.showMessageDialog(null, "Posição inicial é 1.");
        else{
            boolean l = lista.desligarEletro(ligar);
            if (l)
                JOptionPane.showMessageDialog(null, "Desligado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi desligado!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAdicionar)
            adicionarEletronico();
        else if (e.getSource() == buttonLigar)
            ligarEletro();
        else
            desligarEletro();
    }
}
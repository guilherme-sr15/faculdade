
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class SignUp extends JInternalFrame implements ActionListener {
    private JPanel panel;
    
    private JLabel labelAge;
    private JLabel labelNome;
    
    private JTextField fieldAge;
    private JTextField fieldNome;
    
    private JButton buttonInserir;
    private JButton buttonExibir;
    
    private MainWindow window;
    
    Employee employee;
    
    public SignUp(MainWindow window){
        super("Cadastro de pessoas", true, true, true, true);
        this.window = window;
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Cadastrar"));
        buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(this);
        buttonExibir = new JButton("Exibir");
        buttonExibir.addActionListener(this);
        buttonExibir.setEnabled(false);
        labelAge = new JLabel("Idade:");
        fieldAge = new JTextField(3);
        fieldAge.setFocusable(true);
        labelNome = new JLabel("Nome:");
        fieldNome = new JTextField(10);
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes() {
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(labelAge);
        panel.add(fieldAge);
        panel.add(buttonInserir);
        add(panel);
    }
    
    public Dimension changeSize(){
        return window.changeSize();
    }
    
    private void configurarJanela(){
        setVisible(true);
        //setResizable(false);
        setSize(changeSize());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void insertEmployees(){
        String name = fieldNome.getText();
        String surname = "";
        String[] aux = name.split(" ");
        name = aux[0];
        for(int i=1; i<aux.length;i++)
            surname += aux[i] + " ";
        System.out.println(name + " " + surname + "\n");
        int age = Integer.parseInt(fieldAge.getText());
        
        employee = new Employee(name, surname, age);
        
        if(window.getList().addEmployee(employee))
            System.out.println("Sucesso. Pessoa inserida.\n");
        else
            System.out.println("Fracasso. Pessoa já existe.\n");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonInserir){
            insertEmployees();
            buttonExibir.setEnabled(true);
        }
    }
}
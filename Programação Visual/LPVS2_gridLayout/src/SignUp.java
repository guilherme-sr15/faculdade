
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
    
    private GridBagLayout layout;
    
    private GridBagConstraints constraints;
    
    Employee employee;
    
    public SignUp(MainWindow window){
        super("Cadastro de pessoas", true, true, false, true);
        this.window = window;
        criarComponentes();
        configurarJanela();
    }
    
    private void criarComponentes(){
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();        
        panel = new JPanel(layout);
        //panel.setLayout(layout);
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
        addComponent(labelNome, 0, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(fieldNome, 0, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.WEST);
        addComponent(labelAge, 1, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(fieldAge, 1, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.WEST);
        addComponent(buttonInserir, 2, 1, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.EAST);
        //addComponent(buttonExibir, 0, 2, 1, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        add(panel);
    }
    
    private void addComponent(Component comp, int line, int column, int width, int height, int fill, int position){
        constraints.gridy = line;
        constraints.gridx = column;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.anchor = position;
        constraints.fill = fill;
        constraints.insets = new Insets(10,10,10,10);
        Font font = new Font("tahoma", Font.PLAIN, 16);
        comp.setFont(font);
        layout.setConstraints(comp, constraints);
        panel.add(comp);
    }
    
    private void configurarJanela(){
        setVisible(true);
        setResizable(false);
        pack();
        //setLocation(280,100);
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
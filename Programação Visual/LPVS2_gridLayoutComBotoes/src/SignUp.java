
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    //private JPanel panel;
    private JPanel panel;
    private JPanel panel2;
    
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
        setLayout(layout); // deine layout do InternalFrame
        panel = new JPanel(layout);
        panel2 =  new JPanel(layout);
        //panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel2.setBorder(BorderFactory.createEtchedBorder());
        
        ImageIcon iconAdd = new ImageIcon("imagens/inserir.png");
        
        Image image = iconAdd.getImage();
        Image newImage  = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        
        iconAdd.setImage(newImage);
        
        ImageIcon iconRemove = new ImageIcon("imagens/remover.png");
        
        buttonInserir = new JButton("Inserir", iconAdd);
        buttonInserir.addActionListener(this);
        buttonExibir = new JButton("Exibir", iconRemove);
        buttonExibir.addActionListener(this);
        buttonExibir.setEnabled(false);
        labelAge = new JLabel("Idade:");
        fieldAge = new JTextField(3);
        fieldAge.setFocusable(true);
        labelNome = new JLabel("Nome:");
        fieldNome = new JTextField(10);
        
        //iconFinder -- ENCONTRAR ICONES
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes() {
        addComponent(panel, labelNome, 0, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(panel, fieldNome, 0, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.WEST);
        addComponent(panel, labelAge, 1, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(panel, fieldAge, 1, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.WEST);
        addComponent(panel2, buttonInserir, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.EAST);
        addComponent(panel2, buttonExibir, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.WEST);
        addComponent(this, panel, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.SOUTH);
        addComponent(this, panel2, 1, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.SOUTH);
    }
    
    private void addComponent(Container cont, Component comp, int line, int column, int width, int height, int fill, int position){
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
        cont.add(comp);
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
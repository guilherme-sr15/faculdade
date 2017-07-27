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

public class MainWindow extends JFrame implements ActionListener{
    private JPanel panel;
    
    private JLabel labelWager;
    private JLabel labelNome;
    private JLabel labelSearch;
    
    private JTextField fieldWager;
    private JTextField fieldNome;
    private JTextField fieldSearch;
    
    private JRadioButton buttonMale;
    private JRadioButton buttonFemale;
    private ButtonGroup group;
    
    private JButton buttonInserir;
    private JButton buttonExibir;
    private JButton buttonSearch;
    
    private JTextArea areaDados;
    private JScrollPane scrollDados;
    
    private EmployeeList list;
    private EmployeeList search;
    
    Employee employee;
    
    public MainWindow(){
        criarComponentes();
        configurarJanela();
        list = new EmployeeList(1000);
        //search = new EmployeeList(1000);
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(this);
        buttonExibir = new JButton("Exibir");
        buttonExibir.addActionListener(this);
        buttonExibir.setEnabled(false);
        buttonSearch = new JButton("Busca");
        buttonSearch.addActionListener(this);
        buttonSearch.setEnabled(false);
        buttonMale = new JRadioButton("Masc.");
        buttonMale.setSelected(true);
        buttonFemale = new JRadioButton("Fem.");
        group = new ButtonGroup();
        group.add(buttonMale);
        group.add(buttonFemale);
        labelWager = new JLabel("Salário:");
        fieldWager = new JTextField(5);
        fieldWager.setFocusable(true);
        labelNome = new JLabel("Nome:");
        fieldNome = new JTextField(10);
        labelSearch = new JLabel("Busca:");
        fieldSearch =  new JTextField(10);
        areaDados = new JTextArea(10,10);
        areaDados.setEditable(false);
        scrollDados = new JScrollPane(areaDados);
        adicionarComponentes();
    }
    
    private void adicionarComponentes() {
        panel.add(labelWager);
        panel.add(fieldWager);
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(buttonMale);
        panel.add(buttonFemale);
        panel.add(buttonInserir);
        panel.add(buttonExibir);
        panel.add(labelSearch);
        panel.add(fieldSearch);
        panel.add(buttonSearch);
        panel.add(scrollDados);
        add(panel);
    }
    
    private void configurarJanela(){
        setTitle("Employees");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void insertEmployees(){
        String nome = fieldNome.getText();
        int wager = Integer.parseInt(fieldWager.getText());
        boolean sex = buttonMale.isSelected();
        
        employee = new Employee(nome, sex, wager);
        
        if(list.addEmployee(employee))
            System.out.println("Sucesso!");
        else
            System.out.println("Fracasso");
    }
    
    private void exibirDados(){
        areaDados.setText(list.toString());
    }
    
    private void search(){
        String searchName = fieldSearch.getText();
        search = list.searchEmployees(searchName);
        
        JTextArea area = new JTextArea(10,10);
        JScrollPane pane = new JScrollPane(area);
        area.setText(search.toString());
        JOptionPane.showMessageDialog(null,pane);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonInserir){
            insertEmployees();
            buttonSearch.setEnabled(true);
            buttonExibir.setEnabled(true);
        }
        if(e.getSource()==buttonExibir){
            exibirDados();
        }
        if(e.getSource()==buttonSearch){
            search();
        }
    }
}
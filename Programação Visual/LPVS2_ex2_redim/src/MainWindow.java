/*
*@Author Guilherme de Souza Rodrigues
*/

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame implements ActionListener{

    private JMenuBar bar;
    private JMenu menuArquivo;
    private JMenuItem itemSignUp;
    private JMenuItem itemRemove;
    private JMenuItem itemExit;
    private JMenuItem itemShow;
    private JDesktopPane desktop;
    private EmployeeList2 list;
    private SignUp signUp;
    private Remove remove;
    private Show show;
    private Dimension d;
    
    public MainWindow(){
        super("Exemplo de menus");
        list = new EmployeeList2();
        createComponents();
        adjustProperties();
    }
    
    private void createComponents(){
        desktop = new JDesktopPane();
        
        bar = new JMenuBar();
        
        menuArquivo = new JMenu("Arquivo");
        
        itemSignUp = new JMenuItem("Tela de cadastro");
        itemSignUp.addActionListener(this);
        itemRemove = new JMenuItem("Tela de remoção");
        itemRemove.addActionListener(this);
        itemExit = new JMenuItem("Sair");
        itemExit.addActionListener(this);
        itemShow = new JMenuItem("Tela de exibição");
        itemShow.addActionListener(this);
        
        menuArquivo.add(itemSignUp);
        menuArquivo.add(itemRemove);
        menuArquivo.add(itemShow);
        menuArquivo.addSeparator();
        menuArquivo.add(itemExit);
        
        bar.add(menuArquivo);
        
        setJMenuBar(bar);
        
        add(desktop);
    }
    
    private void adjustProperties(){
        setVisible(true);
        setSize(1280,720);
        //setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }
    
    private void addWindow(JInternalFrame window){
        desktop.add(window);
        desktop.moveToFront(window);
    }
    
    public EmployeeList2 getList(){
        return list;
    }
    
    private boolean isActive(JInternalFrame window){
        return window != null && !window.isClosed();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemSignUp){
            if(!isActive(signUp)){
                signUp = new SignUp(this);
                addWindow(signUp);
            }
        }else if (e.getSource() == itemRemove){
            if(!isActive(remove)){
                remove = new Remove(this);
                addWindow(remove);
        }
        }else if (e.getSource() == itemShow){
            if(!isActive(show)){
                show = new Show(this);
                addWindow(show);
            }
        }else{
            System.exit(0);
        }
    }
    
    public Dimension changeSize(){
        int width1 = getSize().width-100;
        int height1 = getSize().height-100;
        d = new Dimension(width1, height1);
        return d;
    }
    
    @Override
    public void repaint(int x, int y, int width, int height){
        super.repaint(x, y, width, height);
        
        if(isActive(signUp)){
            signUp.setSize(changeSize());
        }
        
        if(isActive(remove)){
            remove.setSize(changeSize());
        }
    }
}

/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
public class MainWindow extends JFrame implements ActionListener{
    private JPanel panel;
    
    private JLabel labelAge;
    private JLabel labelNome;
    private JLabel labelRemove;
    
    private JTextField fieldAge;
    private JTextField fieldNome;
    private JTextField fieldRemove;
    
    private JRadioButton buttonMale;
    private JRadioButton buttonFemale;
    private ButtonGroup group;
    
    private JButton buttonInserir;
    private JButton buttonExibir;
    private JButton buttonRemove;
    
    private JTextArea areaDados;
    private JScrollPane scrollDados;
    
    private EmployeeList2 list;
    private EmployeeList2 search;
    
    private JComboBox box;
    
    Employee employee;
    
    public MainWindow(){
        criarComponentes();
        configurarJanela();
        list = new EmployeeList2();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(this);
        buttonExibir = new JButton("Exibir");
        buttonExibir.addActionListener(this);
        buttonExibir.setEnabled(false);
        buttonRemove = new JButton("Remover");
        buttonRemove.addActionListener(this);
        buttonRemove.setEnabled(false);
        buttonMale = new JRadioButton("Masc.");
        buttonMale.setSelected(true);
        buttonFemale = new JRadioButton("Fem.");
        group = new ButtonGroup();
        group.add(buttonMale);
        group.add(buttonFemale);
        labelAge = new JLabel("Idade:");
        fieldAge = new JTextField(3);
        fieldAge.setFocusable(true);
        labelNome = new JLabel("Nome:");
        fieldNome = new JTextField(10);
        labelRemove = new JLabel("Remover:");
        fieldRemove =  new JTextField(10);
        areaDados = new JTextArea(10,20);
        areaDados.setEditable(false);
        scrollDados = new JScrollPane(areaDados);
        
        adicionarComponentes();
    }
    
    private void adicionarComponentes() {
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(labelAge);
        panel.add(fieldAge);
        panel.add(buttonMale);
        panel.add(buttonFemale);
        panel.add(buttonInserir);
        panel.add(buttonExibir);
        panel.add(labelRemove);
        panel.add(fieldRemove);
        panel.add(buttonRemove);
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
        String name = fieldNome.getText();
        String surname = "";
        String[] aux = name.split(" ");
        name = aux[0];
        for(int i=1; i<aux.length;i++)
            surname += aux[i] + " ";
        System.out.println(name + " " + surname + "\n");
        int age = Integer.parseInt(fieldAge.getText());
        
        employee = new Employee(name, surname, age);
        
        if(list.addEmployee(employee))
            System.out.println("Sucesso.\n");
        else
            System.out.println("Fracasso. Pessoa já existe.\n");
    }
    
    public void remove(){
        if(fieldRemove.getText()!=null){
            if(list.removeEmployee(fieldRemove.getText()))
                System.out.println("Removido.\n");
            else
                System.out.println("Não removido.\n");
        }
    }
    
    private void exibirDados(){
        areaDados.setText(list.toString());
    }
    
    private void setComboBox(EmployeeList l){
        
    }
    
//    private void search(){
//        String searchName = fieldSearch.getText();
//        search = list.searchEmployee(searchName);
//        
//        JTextArea area = new JTextArea(10,10);
//        JScrollPane pane = new JScrollPane(area);
//        area.setText(search.toString());
//        JOptionPane.showMessageDialog(null,pane);
//    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonInserir){
            insertEmployees();
            buttonRemove.setEnabled(true);
            buttonExibir.setEnabled(true);
        }
        if(e.getSource()==buttonExibir){
            exibirDados();
        }
        if(e.getSource()==buttonRemove){
            remove();
        }
    }
}*/
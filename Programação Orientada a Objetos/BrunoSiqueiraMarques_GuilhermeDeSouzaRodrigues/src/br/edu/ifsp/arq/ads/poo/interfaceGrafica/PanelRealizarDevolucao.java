/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import br.edu.ifsp.arq.ads.poo.bancos.BancoUsuariosBiblioteca;
import br.edu.ifsp.arq.ads.poo.entidades.Usuarios;
import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.entidades.Emprestimo;
import br.edu.ifsp.arq.ads.poo.entidades.Devolucao;

/**
 *
 * @author Aluno
 */
public class PanelRealizarDevolucao extends PainelAbstrato implements ActionListener {
    private JButton btnDevolver,btnBuscar;
    private JLabel lbTitulo, lbExemplar, lbData,lbRg;
    private JTextField fdTitulo, fdExemplar, fdData;
    private Devolucao devolucao;
    private JFormattedTextField rg;
    private String rgValido;
    private Usuarios user;
    private JTable tabelaVendas; 
    private DefaultTableModel modeloTabela;  
    private JScrollPane scrollTabela;   
    private BancoUsuariosBiblioteca banco;
    
    @Override
    public void criarComponentes() {
        btnDevolver = new JButton("Devolver");
        btnDevolver.addActionListener(this);

        lbExemplar = new JLabel("Nro exemplar:");
        fdTitulo = new JTextField(10);
        lbTitulo = new JLabel("ID da obra:");
        fdExemplar = new JTextField(10);
        lbData = new JLabel("Data do ato da devolução:");
        fdData = new JFormattedTextField(MascaraData("##/##/####"));
        
        btnBuscar = new JButton("Buscar usuário");
        
        banco = BancoUsuariosBiblioteca.getInstance();
        
        btnBuscar.addActionListener(this);

        lbRg = new JLabel("RG usuário:");
        
        rgValido = "\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d";

        rg = new JFormattedTextField(MascaraRg("##.###.###-#"));
        
        tabelaVendas = new JTable();
        
        modeloTabela = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
               
        scrollTabela = new JScrollPane(tabelaVendas);
        
        scrollTabela.setPreferredSize(new Dimension(this.getWidth()+600, this.getHeight()+300));
        
        adicionarColunas();

        tabelaVendas.setModel(modeloTabela);
        tabelaVendas.setFillsViewportHeight(true);              
        
        
        setLayout(this.getLayout());

        adicionarLayout(this, lbRg, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, rg, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnBuscar, 1, 2, 1, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER);      
        adicionarLayout(this, lbData, 2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdData, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, scrollTabela, 3, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnDevolver, 4, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
    }
    
    public MaskFormatter MascaraData(String Mascara){
       MaskFormatter F_Mascara = new MaskFormatter();
       try{
           F_Mascara.setMask(Mascara); //Atribui a mascara
           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
       }
       catch (Exception excecao) {
           excecao.printStackTrace();
       } 
       return F_Mascara;
    }
     public MaskFormatter MascaraRg(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        } 
        return F_Mascara;
    }
     
    private void realizarDevolucao() {
        int[] obrasSelecionadas = buscaLinhasSelecionadas();
        
        String d = fdData.getText();
        String rg = lbRg.getText();
        user = banco.buscaUsuario(rg);
        
        if(d.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
            Calendar cal = converteData(d);
                for (int i = 0; i <obrasSelecionadas.length; i++) {
                    System.out.println(i);
                    int idObra = (int) tabelaVendas.getValueAt(obrasSelecionadas[i], 2);

                    int nroEx = (int) tabelaVendas.getValueAt(obrasSelecionadas[i], 3);

                    devolucaoEmprestimo(idObra, nroEx, cal);
                }   
        }else{
            JOptionPane.showMessageDialog(null, "Informe uma data");
        }   
    }
    
    private int[] buscaLinhasSelecionadas(){
        int[] lista = tabelaVendas.getSelectedRows();
        return lista;
    }
    
    private Usuarios buscaUsuario(){
        String cod = rg.getText();
        Usuarios u = null;
        if(!cod.isEmpty()){
            u = BancoUsuariosBiblioteca.getInstance().buscaUsuario(cod);
        }
        return u;        
    }
    
    private void adicionarColunas(){
        modeloTabela.addColumn("Data empréstimo");
        modeloTabela.addColumn("Data devolução");
        modeloTabela.addColumn("ID da obra");
        modeloTabela.addColumn("Código do exemplar");
        modeloTabela.addColumn("Status do exemplar");
        modeloTabela.addColumn("Nome da obra");
    }    
    
    private void devolucaoEmprestimo(int idObra, int nroEx, Calendar cal){
        devolucao = new Devolucao();
        boolean b = devolucao.devolucao(idObra, nroEx, cal);
        if(b){
            JOptionPane.showMessageDialog(null, "Devolução feita com sucesso.");
        }else{
            boolean multa = mostrarMulta(devolucao);
            if(!multa)
                devolucao.devolucao(idObra, nroEx, GregorianCalendar.getInstance());
        }
    }
    
    private boolean mostrarMulta(Devolucao devolucao){
        float multa = devolucao.getMulta();
        if(multa != 0){
            String msg = String.format("Pagar multa de R$%.2f", multa);
            JOptionPane.showMessageDialog(null, msg);
            return false;
        }else
            JOptionPane.showMessageDialog(null, "Empréstimo não encontrado.");
        return true;
    }  
    
    private void preencherTabela(Usuarios u) {
        modeloTabela.setNumRows(0);
        List<Emprestimo> listaEmp = u.getEmprestimos().getListaEmprestimos();
        for (Emprestimo emprestimo : listaEmp) {
            Set<Exemplar> listaExemplar = emprestimo.getExemplaresEmprestados().getListaObrasUsuario();
            for (Exemplar exemplar : listaExemplar) {
                modeloTabela.addRow(new Object[]{emprestimo.getDataEmprestimo().getTime(),
                    emprestimo.getDataDevolucao().getTime(),
                    exemplar.getObraDoExemplar().getCodigo(),
                    exemplar.getCodigo(),
                    exemplar.getStatus(),
                    exemplar.getObraDoExemplar().getTitulo()});
            }
        }
    }  
    
    private boolean validaString(String validar){
        return validar.matches("[a-zA-Z][^\n]*");
    }
    
    private boolean validaInteiro(String validar){
        return validar.matches("[0-9]+");
    }    
    
    private Calendar converteData(String data){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(data));
            return cal;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnDevolver){
            realizarDevolucao();
        } else if (e.getSource() == btnBuscar) {
            Usuarios u = buscaUsuario();
            if(u!= null)
                preencherTabela(u);
            else
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
        }
    }
}

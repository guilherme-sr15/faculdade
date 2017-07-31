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
import br.edu.ifsp.arq.ads.poo.bancos.BancoObrasBiblioteca;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusDisp;
import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.entidades.Obras;
import br.edu.ifsp.arq.ads.poo.entidades.Emprestimo;
import br.edu.ifsp.arq.ads.poo.entidades.FabricaEmprestimoUsuario;

/**
 *
 * @author Aluno
 */
public class PanelRealizarEmprestimo extends PainelAbstrato implements ActionListener{
    private JButton btnEmprestar;
    private JLabel lbTitulo, lbExemplar, lbUsuario;
    private JTextField fdTitulo, fdExemplar, fdUsuario;
    private Emprestimo emprestimo;
    private BancoUsuariosBiblioteca banco;
    private String rgValido;
    private JFormattedTextField rg;
    private BancoObrasBiblioteca bancoObras;
    
    private  JTable tabelaVendas; 
    private DefaultTableModel modeloTabela;  
    private JScrollPane scrollTabela;
    
    

    @Override
    public void criarComponentes() {
        btnEmprestar = new JButton("Emprestar");
        btnEmprestar.addActionListener(this);
        
        rgValido = "\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d";
        
        banco = BancoUsuariosBiblioteca.getInstance();
        
        bancoObras = BancoObrasBiblioteca.getInstance();
        
        lbExemplar = new JLabel("Nro exemplar:");
        fdTitulo = new JTextField(10);
        lbUsuario = new JLabel("RG do usuário:");
        rg = new JFormattedTextField(Mascara("##.###.###-#"));
        lbTitulo = new JLabel("Selecione uma obra:");
        fdExemplar = new JTextField(10);
        
        
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

        adicionarLayout(this, lbUsuario, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, rg, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbTitulo, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        //adicionarLayout(this, fdTitulo, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        //adicionarLayout(this, lbExemplar, 2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        //adicionarLayout(this, fdExemplar, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, scrollTabela, 2, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnEmprestar, 3, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
    }
    
    public MaskFormatter Mascara(String Mascara){
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
    
    private void realizarEmprestimo() {
        int[] obrasSelecionadas = buscaLinhasSelecionadas();
        String cod = rg.getText();
        Usuarios u = banco.buscaUsuario(cod);
        System.out.println(obrasSelecionadas.length);
        if (u != null) {

            for (int i = 0; i <obrasSelecionadas.length; i++) {
                System.out.println(i);
                int idObra = (int) tabelaVendas.getValueAt(obrasSelecionadas[i], 1);

                int nroEx = (int) tabelaVendas.getValueAt(obrasSelecionadas[i], 3);

                emprestimo(u, idObra, nroEx);
            }
            preencherTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
        }
    }
    
    private void emprestimo(Usuarios usuario, int idObra, int nroEx) {
        emprestimo = new FabricaEmprestimoUsuario().getEmprestimo(usuario);
        usuario.add(emprestimo);
        
        if (emprestimo.emprestimo(idObra, nroEx)) {
            JOptionPane.showMessageDialog(null, "Emprestimo realizado.");
        }
        else
            JOptionPane.showMessageDialog(null, "Emprestimo não realizado.");
    }
    
    private boolean validaString(String validar){
        return validar.matches("[a-zA-Z][^\n]*");
    }
    private boolean validaInteiro(String validar){
        return validar.matches("[0-9]+");
    }
    
    private boolean testaValidade(String s, String sValido){
        return s.matches(sValido);
    }
    
    private void adicionarColunas(){
        modeloTabela.addColumn("Obra");
        modeloTabela.addColumn("ID obra");
        modeloTabela.addColumn("Tipo");
        modeloTabela.addColumn("Código do exemplar");
        modeloTabela.addColumn("Status do exemplar");
        
        preencherTabela();
    }
    
    private int[] buscaLinhasSelecionadas(){
        int[] lista = tabelaVendas.getSelectedRows();
        return lista;
    }
    
    private void preencherTabela() {
        modeloTabela.setNumRows(0);
        Set<Obras> lista = bancoObras.getListaObras();
        for (Obras obras : lista) {
            Set<Exemplar> lista1 = obras.getGerenciaListaExemplares().getListaExemplares();
            for (Exemplar exemplar : lista1) {
                if(exemplar.getStatus() != EnumStatusDisp.EMPRESTADO)
                modeloTabela.addRow(new Object[]{obras.getTitulo(), obras.getCodigo(), obras.getTipo(), exemplar.getCodigo(), exemplar.getStatus()});
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnEmprestar){
            realizarEmprestimo();
        }
    }
}

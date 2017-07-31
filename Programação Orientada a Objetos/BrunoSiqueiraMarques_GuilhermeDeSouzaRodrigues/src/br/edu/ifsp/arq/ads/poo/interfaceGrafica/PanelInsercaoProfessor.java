/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import br.edu.ifsp.arq.ads.poo.bancos.BancoUsuariosBiblioteca;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumTitulacao;
import br.edu.ifsp.arq.ads.poo.entidades.Professor;
import br.edu.ifsp.arq.ads.poo.entidades.Usuarios;

/**
 *
 * @author Aluno
 */
public class PanelInsercaoProfessor extends PainelAbstrato implements ActionListener{

    private JButton btnInserir;
    private JLabel lbNome,lbRg,lbCodigo,lbStatus;
    private JTextField fdNome,fdCodigo;
    private JFormattedTextField rg;
    private JComboBox comboStatus;
    private Usuarios prof;
    private BancoUsuariosBiblioteca banco;
    private String codValido, rgValido;
    
    @Override
    public void criarComponentes(){
        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);
        
        lbNome = new JLabel("Nome:");
        lbRg = new JLabel("RG:");
        
        codValido = "[\\d]+";
        rgValido = "\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d";
        
        fdNome = new JTextField(5);
        
        banco = BancoUsuariosBiblioteca.getInstance();
        
        comboStatus = new JComboBox(EnumTitulacao.values());
        
        rg = new JFormattedTextField(Mascara("##.###.###-#"));
        
        lbCodigo = new JLabel("Código:");
        lbStatus = new JLabel("Status:");
        
        fdCodigo = new JTextField(5);
        
        setLayout(this.getLayout());
        
        adicionarLayout(this, lbNome, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdNome, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbRg, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, rg, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbCodigo, 2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdCodigo, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbStatus, 3, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, comboStatus, 3, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnInserir, 4, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
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
     
    private void inserirProfessor(){
        String nome = fdNome.getText();
        String cod = fdCodigo.getText();
        String rg1 = rg.getText();
        EnumTitulacao status = (EnumTitulacao)comboStatus.getSelectedItem();
        
        if(testaNome(nome)){
            if(testaValidade(cod, codValido)){
                int c = Integer.parseInt(cod);
                if(testaValidade(rg1, rgValido)){
                    prof = addProfessor(nome, rg1, c, status);
                    addAoBanco(prof);
                }else
                    JOptionPane.showMessageDialog(null, "Verifique o RG\n e tente novamente.");
            }else
                JOptionPane.showMessageDialog(null, "Verifique o código\n e tente novamente.");
        }else
            JOptionPane.showMessageDialog(null, "Verifique o nome\n e tente novamente.");
    }
    
    private void addAoBanco(Usuarios p){
        boolean b = banco.addUsuario(prof);
        if(b)
            JOptionPane.showMessageDialog(null, "Professor adicionado.");
        else
            JOptionPane.showMessageDialog(null, "RG já cadastrado.");
    }
    
    private Usuarios addProfessor(String nome, String rg1, int c, EnumTitulacao status){
        prof = new Professor(nome, rg1, c, status);
        System.out.println(prof.toString());
        return prof;
    }
    
    private boolean testaNome(String nome){
        return nome.matches("[a-zA-Z][^\n]*");
    }
    
    private boolean testaValidade(String s, String sValido){
        return s.matches(sValido);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInserir){
            inserirProfessor();
        }
    }
}

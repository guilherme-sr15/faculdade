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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.edu.ifsp.arq.ads.poo.bancos.BancoObrasBiblioteca;
import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.entidades.Obras;
import br.edu.ifsp.arq.ads.poo.entidades.Revistas;

/**
 *
 * @author Bruno Siqueira
 */
public class PanelInsercaoRevistas extends PainelAbstrato implements ActionListener{

    private JButton btnInserir;
    private JLabel lbTitulo, lbQtdExemplares, lbArea;
    private JTextField fdTitulo, fdQtdExemplares, fdArea;
    private final BancoObrasBiblioteca banco=BancoObrasBiblioteca.getInstance();    

    @Override
    public void criarComponentes() {
        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);

        lbArea = new JLabel("Nome da área:");
            lbQtdExemplares = new JLabel("Quantidade de exemplares desta obra:");
        lbTitulo = new JLabel("Título:");

        fdArea = new JTextField(5);
        fdQtdExemplares = new JTextField(5);
        fdTitulo = new JTextField(5);

        setLayout(this.getLayout());

        adicionarLayout(this, lbTitulo, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdTitulo, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbQtdExemplares, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdQtdExemplares, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, lbArea, 2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, fdArea, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        adicionarLayout(this, btnInserir, 3, 0, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
    }

    /**
     * @return the lbEspecificidade1
     *
    public JLabel getLbEspecificidade1() {
        return lbEspecificidade1;
    }*/
    
    private void inserirRevista() {
        String nome = fdTitulo.getText();
        String area = fdArea.getText();
        String ex = fdQtdExemplares.getText();
        if (validaString(nome)) {
            if (validaString(area)) {
                if (validaInteiro(ex)) {
                    int qtdDeExemplares = Integer.parseInt(ex);
                    Obras revista = addRevista(nome, area, qtdDeExemplares);
                    addAoBanco(revista);
                    System.out.println(banco);
                } else {
                    JOptionPane.showMessageDialog(null, "Verifice a quantidade de exemplares! Tente novamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifice a área! Tente novamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifice o nome! Tente novamente");
        }

    }
    private Obras addRevista(String nome, String area, int qtdDeExemplares) {
        Obras revista = new Revistas(nome, area);
        for (int i = 1; i <= qtdDeExemplares; i++) {
            Exemplar ex = new Exemplar(i, revista);
            revista.addExemplar(ex);
        }
        return revista;
    }
    private void addAoBanco(Obras obra){
        boolean b = banco.add(obra);
        if(b)
            JOptionPane.showMessageDialog(null, "Revista adicionada.");
        else
            JOptionPane.showMessageDialog(null, "Titulo já cadastrado.");
    }    
    private boolean validaString(String validar){
        return validar.matches("[a-zA-Z][^\n]*");
    }
    private boolean validaInteiro(String validar){
        return validar.matches("[0-9]+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnInserir){
            inserirRevista();
        }
    }
    
    
    
}

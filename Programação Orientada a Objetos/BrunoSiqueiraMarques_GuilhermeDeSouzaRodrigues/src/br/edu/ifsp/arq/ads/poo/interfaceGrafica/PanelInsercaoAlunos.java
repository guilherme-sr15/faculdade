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
import br.edu.ifsp.arq.ads.poo.entidades.Aluno;
import br.edu.ifsp.arq.ads.poo.bancos.BancoUsuariosBiblioteca;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusAluno;
import br.edu.ifsp.arq.ads.poo.entidades.Usuarios;

public class PanelInsercaoAlunos extends PainelAbstrato implements ActionListener {

    private JButton btnInserir;
    private JLabel lbNome, lbRg, lbCodigo, lbStatus;
    private JTextField fdNome, fdCodigo;
    private JFormattedTextField rg;
    private JComboBox comboStatus;
    private Usuarios aluno;
    private BancoUsuariosBiblioteca banco;
    private String codValido, rgValido;

    @Override
    public void criarComponentes() {
        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);

        lbNome = new JLabel("Nome:");
        lbRg = new JLabel("RG:");

        codValido = "[a-zA-Z]+";
        rgValido = "\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d";

        fdNome = new JTextField(5);

        banco = BancoUsuariosBiblioteca.getInstance();

        comboStatus = new JComboBox(EnumStatusAluno.values());

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

    public MaskFormatter Mascara(String Mascara) {
        MaskFormatter F_Mascara = new MaskFormatter();
        try {
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        } catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }

    private void inserirAluno() {
        String nome = fdNome.getText();
        String cod = fdCodigo.getText();
        String rg1 = rg.getText();
        EnumStatusAluno status = (EnumStatusAluno) comboStatus.getSelectedItem();

        if (testaNome(nome)) {
            if (testaValidade(cod, codValido)) {
                if (testaValidade(rg1, rgValido)) {
                    aluno = addAluno(nome, rg1, cod, status);
                    addAoBanco(aluno);
                    System.out.println(banco);
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique o RG\n e tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique o código\n e tente novamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique o nome\n e tente novamente.");
        }
    }

    private void addAoBanco(Usuarios a) {
        boolean b = banco.addUsuario(a);
        if (b) {
            JOptionPane.showMessageDialog(null, "Aluno adicionado.");
        } else {
            JOptionPane.showMessageDialog(null, "RG já cadastrado.");
        }
    }

    private Usuarios addAluno(String nome, String rg, String cod, EnumStatusAluno status) {
        aluno = new Aluno(cod, status, nome, rg);
        System.out.println(aluno.toString());
        return aluno;
    }

    private boolean testaNome(String nome) {
        return nome.matches("[a-zA-Z][^\n]*");
    }

    private boolean testaValidade(String s, String sValido) {
        return s.matches(sValido);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInserir) {
            inserirAluno();
        }
    }
}

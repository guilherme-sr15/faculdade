
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * @author Guilherme de Souza Rodrigues
 */

public class JanelaPrincipal extends JFrame implements ActionListener, Serializable {
    private JPanel panel;
    
    private JButton buttonPlay;
    private JButton buttonStart;
    private JButton buttonSave;
    private JButton buttonRecover;
    private JButton buttonSaveMethod;
    
    private JRadioButton serializar;
    private JRadioButton texto;
    
    private ButtonGroup group;
    
    private JTextField fieldBet;
    
    private JLabel labelBet;
    
    JogoDado game;
    
    Manipulador m;
    ManipuladorTexto mt;
    ManipuladorSerializador ms;
    
    public JanelaPrincipal(){
        createComponents();
        adjustComponents();
    }
    
    private void createComponents(){
        panel = new JPanel();
        
        buttonStart = new JButton("Iniciar jogo");
        buttonStart.addActionListener(this);
        
        buttonPlay = new JButton("Jogar!");
        buttonPlay.addActionListener(this);
        
        buttonSave = new JButton("Salvar jogo");
        buttonSave.addActionListener(this);
        buttonSave.setEnabled(false);
        
        buttonRecover = new JButton("Recuperar jogo");
        buttonRecover.addActionListener(this);
        
        buttonSaveMethod = new JButton("Selecionar método");
        buttonSaveMethod.addActionListener(this);
        
        serializar = new JRadioButton("Serializar");
        serializar.setActionCommand("serializar");
        serializar.setSelected(true);
        texto = new JRadioButton("Texto");
        texto.setActionCommand("texto");
     
        group = new ButtonGroup();
        group.add(texto);
        group.add(serializar);
        
        fieldBet = new JTextField(5);
        
        labelBet = new JLabel("Informe a aposta: ");
        
        enableComponents(false);
        addComponents();
    }
    
    private void addComponents(){
        panel.add(buttonStart);
        panel.add(labelBet);
        panel.add(fieldBet);
        panel.add(buttonPlay);
        panel.add(buttonSave);
        panel.add(buttonRecover);
        panel.add(serializar);
        panel.add(texto);
        panel.add(buttonSaveMethod);
        add(panel);
    }
    
    private void adjustComponents(){
        setTitle("Jogo de Dados");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void startGame(){
        game = new JogoDado();
        System.out.println(game);
        enableComponents(true);
        fieldBet.setText("");
    }
    
    private void playGame(){
        String text = fieldBet.getText();
      
            if(text.matches("[0-9]+")){
                int bet = Integer.parseInt(text);
                
                game(bet);   
            }else{
                JOptionPane.showMessageDialog(null, "Informe um numeral!");
        }
    }
    
    private void game(int bet){
        if (!game.play(bet)){
            JOptionPane.showMessageDialog(null, game.getTries() + " tentativas restantes");
            if(game.getTries()==0){
                youLost();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Acertou!");
            endGame();
        }    
    }
    
    private void endGame(){
        game = null;
        enableComponents(false);
    }
    
    private void youLost(){
        JOptionPane.showMessageDialog(null, "Você perdeu! \n O número correto era " + game.getSum());
        endGame();
    }
    
    private void enableComponents(boolean status){
        buttonPlay.setEnabled(status);
        fieldBet.setEditable(status);
    }
    
    private void saveGame(){
        try{
            m.saveGame(game);
        }catch(IOException e){
            e.getMessage();
        }
        enableComponents(false);
        buttonSave.setEnabled(false);
    }
    
    private void recoverGame(){
        try{
            Object o = m.recoverGame();
            game = (JogoDado) o;
        }catch(Exception e){
            e.printStackTrace();
        }
        enableComponents(true);
        buttonSave.setEnabled(true);
    }
    
    private void changeSaveMethod(){
        buttonSaveMethod.setEnabled(false);
        ControleSalvar cs = new ControleSalvar();
        m = cs.changeSaveMethod(group.getSelection().getActionCommand());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonStart){
            startGame();
        }else if(e.getSource() == buttonSave){
            saveGame();
        }else if(e.getSource() == buttonRecover){
            recoverGame();
        }else if (e.getSource() == buttonPlay){
            playGame();
        } else{
            buttonSave.setEnabled(true);
            changeSaveMethod();
        }
    }
}
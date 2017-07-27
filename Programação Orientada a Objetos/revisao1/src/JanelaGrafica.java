
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Guilherme de Souza Rodrigues
 */
public class JanelaGrafica extends JFrame implements ActionListener {
    private JPanel panel;
    
    private JButton buttonPlay;
    private JButton buttonStart;
    
    private JTextField fieldBet;
    
    private JLabel labelBet;
    
    Game game;
    
    public JanelaGrafica(){
        createComponents();
        adjustComponents();
    }
    
    private void createComponents(){
        panel = new JPanel();
        
        buttonStart = new JButton("Iniciar jogo");
        buttonStart.addActionListener(this);
        
        buttonPlay = new JButton("Jogar!");
        buttonPlay.addActionListener(this);
        
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
        add(panel);
    }
    
    private void adjustComponents(){
        setTitle("Jogo de Dados");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }
    
    private void startGame(){
        game = new Game();
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
            if(game.getTries()==0)
                youLost();
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonStart){
            startGame();
        }else{
            playGame();
        }
    }
}
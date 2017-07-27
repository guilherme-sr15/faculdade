/*
 * @author Guilherme de Souza Rodrigues
 */
public class Game {
    
    private int tries;
    private int dice1;
    private int dice2;
    private int sum;
   
    public Game(){
        tries = 3;
        dice1 = (int)(Math.random() * 6 + 1);
        dice2 = (int)(Math.random() * 6 + 1); //(y+1-x) + x ---> fórmula para nº aleatório
        sum = dice1 + dice2;
    }
    public boolean play(int bet){
        if(tries >0){
            tries--;
            if(bet == sum){
                return true;
            }
        }
        return false;
    }
    
    public int getTries(){
        return tries;
    }
    
    public int getDice1(){
        return dice1;
    }
    
    public int getSum(){
        return sum;
    }
    
    public int getDice2(){
        return dice2;
    }    

    @Override
    public String toString() {
        return "Dado 1: " + dice1 + 
                "\nDado 2: " + dice2 + 
                "\nSoma: " + sum;
    }
    
}
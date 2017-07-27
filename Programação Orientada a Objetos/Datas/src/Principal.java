
import java.text.ParseException;
import java.util.Calendar;

/*
 * @author  Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        String data = ("18/04/1984");
        ManipuladorData md = new ManipuladorData();
        try{
            Calendar c  = md.converteData(data);
        }catch(ParseException e){
            System.out.println("Erro de parse");
        }
    }
}

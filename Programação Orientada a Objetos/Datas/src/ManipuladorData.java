
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @author  Guilherme de Souza Rodrigues
 */

public class ManipuladorData {
    
    public Calendar converteData(String data) throws ParseException{
        Calendar c  = null;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        
        try{
            Date date = format.parse(data);

            c = Calendar.getInstance();
            c.setTime(date);
            
            /*
            System.out.println(c.get(Calendar.DAY_OF_MONTH));
            System.out.println(c.get(Calendar.MONTH)+1);
            System.out.println(c.get(Calendar.YEAR));
            */
            
            return c;
        }finally{
            System.out.println("fazendo alguma coisa.");
        }
    }
}

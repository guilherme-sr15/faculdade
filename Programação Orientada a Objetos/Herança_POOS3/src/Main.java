/*
 * @author Guilherme de Souza Rodrigues
 */

public class Main {
    public static void main(String[] args) {
        
        String tireType = "normal";
        
        Auto a = new Auto(5, tireType);
	Bus b = new Bus(40, tireType);

	a.setPassengers(4);
	b.setPassengers(30);               
    }
}

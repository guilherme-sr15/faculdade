/*
 * @author Guilherme de Souza Rodrigues
 */

/* ----- EM UML -----
* public (+)
* protected (#)
* default (~)
* private (-)
*/

public class Vehicle {

    protected int passengers;
    
    public Vehicle(int passengers){
        this.passengers = passengers;
    }

    public int getPassengers(){
        return passengers;
    }

    public void setPassengers(int passengers){
        this.passengers = passengers;
    }
	
    
}

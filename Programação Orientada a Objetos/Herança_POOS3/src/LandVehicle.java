/*
 * @author Guilherme de Souza Rodrigues
 */

public class LandVehicle extends Vehicle {

    private String tireType;
    
    public LandVehicle(int passengers, String tireType){
        super(passengers);
        this.tireType = tireType;
    }
    
}

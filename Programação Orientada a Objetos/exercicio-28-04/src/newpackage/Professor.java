package newpackage;

public class Professor {
    private static int i = 0;
    
    private String name;
    private final int CODE;
    private double actValue;
    
    public static final double CLASS_VALUE = 20.0;
    
    public Professor(String name, double actValue){
        this.name = name;
        this.actValue = actValue;
        this.CODE = ++Professor.i   ;
    }
    
    public double calculateIncome(){
        return 0;
    }
    
}

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Pessoa {
    
    private String name;
    private int age;
    private final int CODE;
    private static int cont;
    
    private Pessoa(String name, int age){
        this.name = name;
        this.age = age;
        CODE = ++Pessoa.cont;
    }
    
    public int getCODE(){
        return CODE;
    }
    
    public static int getCont(){
        return cont;
    }
    
    private static boolean verifyName(String name){
        return ((name != null) && (!name.trim().isEmpty()));
    }
    
    private static boolean verifyAge(int age){
        return age > 0;
    }
    
    public static Pessoa getInstance(String name, int age){
        if(verifyName(name)){
            if(verifyAge(age)){
                return new Pessoa(name, age);
            }
        }
        return null;
    }
    
    
}

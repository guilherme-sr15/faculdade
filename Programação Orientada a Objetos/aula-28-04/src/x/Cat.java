package x;

/**
 *
 * @author Aluno
 */
public class Cat extends Animal{
    private String type;
    
    public Cat(String type){
        super(type);
    }
    
    @Override
    public int eat(){
        
        super.eat();
        
        System.out.println("Comer de gato");
        return 2;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x;

/**
 *
 * @author Aluno
 */
public class Dog extends Animal{
    private String type;

    public Dog(String type){
        super(type);
    }
    
    @Override
    public int eat() {
        
        super.eat();
        
        System.out.println("Comer de cachorro");
        return 1;
    }
}

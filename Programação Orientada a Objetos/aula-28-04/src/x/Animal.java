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
public class Animal {
    private String type;
    
    public Animal(String type){
        this.type = type;
    }
    
    protected int eat() {               
        System.out.println("Comer de animal");
        return 0;
    }
     
    public final void sleep(){
        System.out.println("Dormir de animal");
    }
}

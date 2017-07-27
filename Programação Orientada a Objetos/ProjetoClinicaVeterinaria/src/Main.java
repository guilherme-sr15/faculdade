
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        
        VetClinic clinic = new VetClinic();
        clinic.addAnimal(d);
        clinic.addAnimal(c);
        
        clinic.feedAllAnimals();
        
    }
}

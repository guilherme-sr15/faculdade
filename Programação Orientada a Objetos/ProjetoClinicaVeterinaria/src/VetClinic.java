/*
 * @author Guilherme de Souza Rodrigues
 */

public class VetClinic {

    private AnimalDomestico[] animals;
    private int cont;
    
    public VetClinic(){
        animals = new AnimalDomestico[10];
    }
    
    public boolean addAnimal(AnimalDomestico animal){
        if (cont < animals.length) {
            animals[cont] = animal;
            cont++;
            return true;
        }
        return false;
    }
    
    public void feedAllAnimals() {
        for(int i = 0; i < cont; i++){
            animals[i].eat();
        }
    }
    
    public void feedAnimal(AnimalDomestico animal) {
        animal.eat();
    }
}

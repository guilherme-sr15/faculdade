
/*
 * @author Guilherme de Souza Rodrigues
 */

public class Principal {
    public static void main(String[] args) {
        AnimalDomestico a1 = new Gato();
        AnimalDomestico a2 = new Cachorro();
        
        GerenciaAnimaisDomesticos gad = new GerenciaAnimaisDomesticos();
        
        gad.fazerAnimalBrincar(a1);
        gad.fazerAnimalBrincar(a2);
        
    }
}
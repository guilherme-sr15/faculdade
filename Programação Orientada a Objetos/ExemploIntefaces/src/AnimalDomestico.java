
/**
 *
 * @author Guilherme de Souza Rodrigues
 */
public interface AnimalDomestico{
    
    void brincar(); //Como uma interface é uma classe abstrata pura, podemos omitir o public abstract, já que é seu default;
    void serAmigavel();
    
    int x = 1; //Constate publica estática por default, podemos omitir o public static final
}

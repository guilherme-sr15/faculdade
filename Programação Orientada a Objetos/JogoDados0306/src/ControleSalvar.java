
/*
 * @author Guilherme de Souza Rodrigues
 */

public class ControleSalvar {
    
    private static final String SERIALIZAR = "serializar";
    private static final String TEXTO = "texto";
    
    Manipulador changeSaveMethod(String s){
        if(SERIALIZAR.equals(s)){
            return new ManipuladorSerializador("jogo_dado.game");
        }else{
            return new ManipuladorTexto("jogo_dado.txt");
        }
    }
}

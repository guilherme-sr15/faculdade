public class Candidato {
    String nome;
    String vaga;
    float nota1;
    float nota2;
    float media;
    
    void inicializarDados(String n, String v, float n1, float n2, float m){
        nome = n;
        vaga = v;
        nota1 = n1;
        nota2 = n2;
        media = m;
        
    }
    
    float calcularMediaAritimetica(float nota1, float nota2){
        return (nota1+nota2)/2;
        //System.out.println(media);
    }
    
    String consultarDados(){
        String string;
        
        string = "Nome: "+nome;
        string += "\nVaga: "+vaga;
        string += "\nNota 1: "+nota1;
        string += "\nNota 2: "+nota2;
        string += "\nMédia: "+media;
        
        return string;
    }
}
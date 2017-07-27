/*
 * @author Guilherme de Souza Rodrigues
 */

public class Pessoa {
    private String name;
    private int age;
    private final int personalCode;
    public static int code = 0;
    
    public Pessoa(String name, int age){
        this.name = name;
        this.age = age;
        this.personalCode = ++Pessoa.code;
    }
    
    public static void createPessoa(String name, int age){
        if(verifyAge(age)){
            if(verifyName(name)){
                p = new Pessoa(name, age);
            }
        }
    }
    
    public static boolean verifyAge(int age){
        if(age>=1)
            return true;
        return false;
    }
    
    public static boolean verifyName(String name){
        String name1 = name.trim();
        if(name1.isEmpty())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + name + 
               "\nIdade: " + age +
               "\nCódigo: " + personalCode +
               "\n";
    }

    
    


}
    

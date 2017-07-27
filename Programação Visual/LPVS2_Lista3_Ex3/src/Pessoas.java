public class Pessoas {
    private String name;
    private int personalNumber;
    private int commercialNumber;
    
    
    public Pessoas(String n, int pN, int cN){
        setName(n);
        setPersonalNumber(pN);
        setCommercialNumber(cN);
        
    }
    
    public void setName(String name){
        if(compareStrings(name))
            this.name = name;
        else 
            this.name = "Erro! Nome é nulo";
    }
    
    public String getName(){
        return name;
    }
    
    public void setPersonalNumber(int personalNumber){
        if (compareValues(personalNumber, commercialNumber))
            this.personalNumber = personalNumber;
    }
    
    public int getPersonalNumber(){
        return personalNumber;
    }
    
    public void setCommercialNumber(int commercialNumber){
        if (compareValues(commercialNumber, personalNumber))
            this.commercialNumber = commercialNumber;
    }
    
    public int getCommercialNumber(){
        return commercialNumber;
    }
    
    private boolean compareValues(int value1, int value2){
        return value1 != value2;
    }
    
    private boolean compareStrings(String s1){
        return s1 != null;
    }
    
    @Override
    public String toString(){
        return "Nome: " + name +
                "\nTelefone pessoal: " + personalNumber +
                "\nTelefone comercial: " + commercialNumber;
    }
}


/*EVIAR O EX 4 E 5 POR EMAIL
-- >   if (nome1.equals(nome2)) || compara se são diferentes ou não -> if(!nome1.equals(nome2)) --> É CASE SENSITIVE
-- >>> if (nome1.equalsIgnoreCase(nome2)) --> NÃO É CASE SENSITIVE
--
--
--
*/
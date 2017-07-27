public class Pessoa {
    
    private String name;
    
    public Pessoa(String n){
    setName(n);
}
    
    public void setName(String newName){
        if (newName != null)
            this.name = newName;
    }
    
    public boolean nullCheck(String name){
        return this.name == null;
    }
    
    String getName(){
        return this.name;
    }

    public boolean compareNames(Pessoa p){
        if (this.name == null && p.name == null){
            return true;
        }
        if (p.name != null && this.name != null){
            return this.name.equalsIgnoreCase(p.name);
        }
        return false;
    }
    
    public int getStringLength(String n){
        if (n != null){
            return this.name.length();
        }
        return 0;
    }

    @Override
    public String toString(){
        return name;
    }

}
public class Employee {
    String name;
    boolean sex;    //true = m; false = f
    String sexText = "Feminino";
    float wager;
    
    public Employee(String name, boolean sex, float wager){
        this.name = name;
        this.sex = sex;
        if(this.sex)
            sexText = "Masculino";
        this.wager = wager;
    }

    public String getName() {
        return this.name;
    }

    public boolean getSex() {
        return this.sex;
    }

    public float getWager() {
        return this.wager;
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s\n"
                           + "Sexo: %s\n"
                           + "Salário: %.2f", this.name, this.sexText, this.wager);
    }
    
}

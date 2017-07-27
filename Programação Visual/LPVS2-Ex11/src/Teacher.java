public class Teacher {
    private int title; //0 - esp; 1- mestre; 2 doutor
    private float income;
    private float finalIncome;
    private boolean tcc;
    private boolean comission;

    
    public Teacher(float income, int title, boolean tcc, boolean comission){
        this.income = income;
        this.title = title;
        this.tcc = tcc;
        this.comission = comission;
    }
    
    public float getFinalIncome(){
        float bonus;
        if (this.title == 0)
            bonus = 0.05f;
        else if (this.title == 1)
            bonus = 0.1f;
        else
            bonus = 0.15f;
        if (this.tcc)
            bonus += 0.025;
        if (this.comission)
            bonus += 0.1;
        this.finalIncome = this.income+(this.income*bonus);
        
        return this.finalIncome;
    }

    @Override
    public String toString() {
        String var = null;
        return String.format("Salário base: R$%.2f\nSalário final: R$%.2f", income, finalIncome);
    }
}

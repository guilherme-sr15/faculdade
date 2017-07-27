public class Produto {
    
    private String name;
    private double price;
    private int estoque;
    
    public Produto(String n, double p, int e){
    setName(n);
    price = p;
    estoque = e;
}
    
    public void setName(String newName){
        if (newName != null)
            name = newName;
    }
    
    String getName(){
        return this.name;
    }
    
    public void setPrice(float newPrice){
        this.price = newPrice;
    }
    
    double getPrice(){
        return this.price;
    }
    
    public void setEstoque(int newEstoque){
        this.estoque = newEstoque;
    }
    
    int getEstoque(){
        return this.estoque;
    }
    
    public float calcularTotal(){
        return (float)getEstoque() * (float)getPrice();
    }
    
    public float calcularTotal(Produto p){
        return (float)p.getEstoque() * (float)p.getPrice();
    }
    
    public boolean compareProducts(Produto p){
        return this.name.equals(p.name) &&
               this.estoque == p.estoque &&
               this.price == p.price;
    }
    
    public Produto maiorEstoque(Produto p){
//        if (this.estoque >= p1.estoque){
//            return this;
//        }else{
//            return p1;
//        }
        return this.estoque >= p.estoque? this : p; //OPERADOR TERNÁRIO [condição] ? [retorno caso true] : [retorno caso false]
    }
    
    @Override
    public String toString(){
        return "Nome: " + name + 
                "\nPreço: " + price + 
                "\nEstoque: " + estoque;
    }

}
public class Veiculo {
    String marca;
    float km;
    float combustivel;
    boolean situacao; /*0 para inativo, 1 para ativo */
    float kmL;
    
//    void inicializarDados(String m, float q, float c, boolean s, float qL){
//        marca = m;
//        km = q;
//        combustivel = c;
//        situacao = s;
//        kmL = qL;   
//    }
    
    public Veiculo(String m, float q, float c, boolean s, float qL){
        marca = m;
        km = q;
        combustivel = c;
        situacao = s;
        kmL = qL;   
    }
    
    boolean andar(float dist){
        float i = (dist/kmL);
        boolean andou = false;
        
        if(i <= combustivel && situacao){
            andou = true;
            km += dist;
            combustivel -= i;
        }
        return andou;
    }
   
    String informarDados(){
        String s;
        
        s = "Marca: "+marca;
        s += "\nQuilometragem: "+km;
        s += "\nCombustivel: "+combustivel;
        s += "\nKM/L: "+kmL;
        s += "\nSituação: "+situacao;
        return s;
    }
    
    void manutencao(){
        if (situacao)
            situacao = false;
    }
    
    void sairManutencao(){
        if (!situacao)
            situacao = true;
    }
}

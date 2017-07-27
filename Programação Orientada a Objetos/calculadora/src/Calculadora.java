/*
 * @author 1610147
 */

public class Calculadora {
    
    public int maior(int a, int b){
        return a>b?a:b;
    }
    
    public int maior(int a, int b, int c){
        return maior(maior(a,b),c);
    }
    
    public int maior(int a, int b, int c, int d){
        return maior(maior(a,b,c),d);
    }
}

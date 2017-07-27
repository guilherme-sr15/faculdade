/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Principal {
    
    public static void main(String[] args) {
        ContaBancaria c1, c2; // variável de referência

        c1 = new ContaBancaria();
        c1.depositar(100.0); //argumento ou parâmetro real
        c1.sacar(40);
        c1.consultarDados();
        
        c2 = new ContaBancaria();
        c2.depositar(20);
        c2.consultarDados();
        
//String s;
//s = "Guilherme";
//s = new String("Guilherme");

//int x1 = 2, x2 = 4;
//boolean b; armazena valores true ou false
//b = x1 > x2;
//if (b) .. (!b)
//
//char c = 'a'; (valor default: '\u0000');
//int num = c;
//System.out.println(num);
//
//byte b; (represneta nros inteiros pequenos);
//
//short b; (entre int e byte); [de -32768 e 32767] 
//
//int 2^32 (entre negativos e positivos)
//
//long l; 64 bits
//
//l = 41447483648l; (colocar o 'l' no final do nro para mostrar que não é int);
//
//float f; 32 bits;(colocar o 'f' no final do nro para mostrar que não é int);
//
//double d; 64 bits;    
//
//coersão byte varByte = (byte)b
//
    }
}

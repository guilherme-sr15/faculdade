/*6) Elabore um conjunto de classes a serem utilizadas em uma ferramenta que 
gerencie figuras geométricas. Inicialmente, deve-se considerar apenas quadrados,
triângulos e losangos. Uma das capacidades que todas as figuras devem possuir é 
saber calcular sua área. Considere: a área do quadrado é dada por: lado*lado; a 
área do triângulo é dada por: base*altura/2; e a área do losango é dada por: 
D*d/2, onde D é a diagonal maior e d é a diagonal menor. Crie também uma classe 
que permita gerenciar uma lista de figuras. Essa classe deve realizar as 
seguintes operações: 1) Armazenar figuras em uma lista (array); 2) Retornar uma 
figura de acordo com a posição informada por classes clientes; e 3) Retornar, na
forma de uma string, o tipo e o valor da área de todas as figuras armazenadas em
sua lista. Observe que o código dessa classe deve ser projetado de tal maneira 
que ele não precise ser alterado para processar novos tipos de figuras (além dos
tipos existentes). Crie uma classe que instancie algumas figuras e utilize os 
serviços da classe de gerenciamento.*/

/*
 * @author Guilherme de Souza Rodrigues
 */

public class Main {
    public static void main(String[] args) {
        JanelaGrafica jg = new JanelaGrafica();
    }
}

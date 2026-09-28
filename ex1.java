/*
    Problema do Troco
    
    Suponha que tenhamos disponíveis moedas com certos valores (por exemplo, de 100, 25, 10, 5 e 1). O problema do
    troco consiste criar um algoritmo que para conseguir obter um determinado valor com o menor número de moedas possível.
    
    Por exemplo, para “dar um troco” de R$2,89, a melhor solução, isto é, o menor número de 
    moedas possível para obter o valor consiste em 10 moedas: 2 de valor 100, 3 de valor 25, 1 de valor 10
    e 4 de valor 1.

    1) **Objetivo:** contrua um algorítmo que recebe a lista das moedas disponíveis e um valor, e retorna uma 
    lista com a menor quantidade de moedas para este troco;
  * Defina uma assinatura adequada para este método;
  * Utiliza uma abordagem gulosa (se puder);
  * Contabilize e exiba o número de iterações para cada caso de teste;
  * O exercício pode ser feito em grupos de um, dois ou três elementos.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ex1 {
    public static void main(String[] args) {
        ArrayList<Double> moedas = new ArrayList<>(Arrays.asList(100.0, 25.0, 10.0, 5.0, 1.0));

        double valor = 0;
        System.out.println("digite o valor do troco:");
        valor = new java.util.Scanner(System.in).nextDouble();

        ArrayList<Double> troco = calcularTroco(moedas, valor);

        System.out.println("Troco: " + troco);
    }

    public static ArrayList<Double> calcularTroco(ArrayList<Double> moedas, double valor) {
            ArrayList<Double> troco = new ArrayList<>();
            int iteracoes = 0;

            for (double moeda : moedas) {
                while (valor >= moeda) {
                    valor -= moeda;
                    troco.add(moeda);
                    iteracoes++;
                }
            }

            System.out.println("Número de iterações: " + iteracoes);
            return troco;
        }
    }

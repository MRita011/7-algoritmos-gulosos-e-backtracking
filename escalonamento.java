import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    ### Problema do escalonamento de intervalos

    Dada uma coleção S de intervalos, encontrar uma subcoleção disjunta máxima de S.
    Uma subcoleção disjunta X de S é *máxima* se não existe outra maior.  Em outras palavras, se não 
    existe subcoleção disjunta *X′* de *S* tal que *|X′| > |X|*.
    
    Usaremos a abreviatura *SDM* para a expressão subcoleção disjunta máxima.  Nosso problema consiste, 
    portanto, em encontrar uma *SDM* de uma coleção de intervalos dada.  Se os intervalos são numerados de 1 a n, 
    uma *SDM* pode ser representada por um subconjunto de * *{1,2,…,n}*.

    Exemplo 
    A figura abaixo especifica uma coleção de intervalos e uma sdm da coleção.  A SDM é indicada pelos 1 do seu vetor característico X:

    s 4 6 13 4 2 6 7  9  1 3  9
    f 8 7 14 5 4 9 10 11 6 13 12
    X 0 1 1  0 1 0 0  1  0 0  0
    
    É fácil verificar que a coleção de 4 intervalos definida por x é disjunta. Mas não é óbvio que ela seja máxima. 
    Você tem certeza de que não existem 5 intervalos disjuntos dois a dois?
 */

public class escalonamento {
    public static void main(String[] args) {
        int[][] casosInicios = {
            {4, 6, 13, 4, 2, 6, 7, 9, 1, 3, 9},
            {1, 3, 5, 7},
            {1, 2, 3, 4},
            {}
        };
        int[][] casosFins = {
            {8, 7, 14, 5, 4, 9, 10, 11, 6, 13, 12},
            {2, 4, 6, 8},
            {10, 9, 8, 7},
            {}
        };

        for (int caso = 0; caso < casosInicios.length; caso++) {
            System.out.println("Caso de teste " + (caso + 1));
            List<Integer> sdm = sdmGuloso(casosInicios[caso], casosFins[caso]);
            System.out.println("Intervalos selecionados: " + sdm);
            System.out.println("Quantidade de intervalos: " + sdm.size());
            System.out.println();
        }
    }

    public static List<Integer> sdmGuloso(int[] inicios, int[] fins) {
        if (inicios == null || fins == null || inicios.length != fins.length) {
            throw new IllegalArgumentException("Os vetores de início e fim devem ter o mesmo tamanho.");
        }

        List<int[]> intervalos = new ArrayList<>();
        for (int indice = 0; indice < inicios.length; indice++) {
            if (inicios[indice] > fins[indice]) {
                throw new IllegalArgumentException("O início não pode ser maior que o fim.");
            }
            intervalos.add(new int[]{inicios[indice], fins[indice], indice + 1});
        }

        intervalos.sort(Comparator.comparingInt(intervalo -> intervalo[1]));

        List<Integer> selecionados = new ArrayList<>();
        int ultimoFim = Integer.MIN_VALUE;
        int iteracoes = 0;

        for (int[] intervalo : intervalos) {
            iteracoes++;
            if (intervalo[0] > ultimoFim) {
                selecionados.add(intervalo[2]);
                ultimoFim = intervalo[1];
            }
        }

        System.out.println("Número de iterações: " + iteracoes);
        return selecionados;
    }
}
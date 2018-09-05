
package model;

import util.FuncoesLista;

/******************************************************************************
 * @author marti                                                              *
 *  date: 19.08.2018                                                          * 
 ******************************************************************************/ 
public class CountingSort implements AlgoritmoDeOrdenacao{

    /***************************************************************************
     *  Algoritmo:      CountingSort                                           *
     *  Caso:           Melhor  	Médio           Pior                   *
     *  Complexidade:   O(n + k)	O(n + k)	O(n + k)               * 
     *      @param list                                                        *
     *      @return list ordenada                                              *
     **************************************************************************/
    @Override
    public long [] ordenar (long [] list) 
    {
        int i, f = list.length;
        int menor = Integer.MAX_VALUE, maior = Integer.MIN_VALUE;
        //encontrando o maior e o menor numero do array
        for(i = 0; i < f; i++)
        {
            if(list[i] < menor )
                menor = (int) list[i];
            if(list[i] > maior)
                maior = (int) list[i];
        }
        //calculando amplitude do vetor, do positivo ao negativo
        int amplitudeNegativa = (menor < 0) ? Math.abs(menor) : 0;
        //vetor de contagem de ocorrencias
        int [] countList = new int [ maior + amplitudeNegativa + 1];
        for(i = 0; i < f; i++)
            countList[ (int) list[i] + amplitudeNegativa ]++;
        //somando valores de ocorrencias para determinar a posicao do valor no vetor
        //comeca a incrementar uma posicao a frente da primeira ocorrencia
        for(i = menor + amplitudeNegativa + 1; i <= maior + amplitudeNegativa; i++)
            countList[i] = countList[i] + countList[i-1];
        //criando o vetor ordenado
        long [] vetorOrdenado = new long [f];
        for(i = f-1; i >= 0; --i)
        {   // de tras pra frente para manter algoritmo estavel ( 3 pode ser diferente de 3, quando se trata de Objetos)  
            int novaPosicao = --countList[ (int) list[i] + amplitudeNegativa ];
            vetorOrdenado[novaPosicao] = list[i];
        }
        FuncoesLista.copiarLista(vetorOrdenado, list);
        return list;
    }
    
}

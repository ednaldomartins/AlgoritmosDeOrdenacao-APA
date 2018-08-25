
package model;

import java.util.List;

/******************************************************************************
 * @author marti                                                              *
 *  date: 19.08.2018                                                          * 
 ******************************************************************************/ 
public class CountingSort implements AlgoritmoDeOrdenacao{

    /***************************************************************************
     *  Algoritmo                    Complexidade                              *             
     *                  Melhor  	Médio           Pior                   *
     *  Counting Sort	O(n + k)	O(n + k)	O(n + k)               *
     * @param list                                                             *
     * @return list ordenada                                                   *
     **************************************************************************/
    @Override
    public List ordenar (List<Long> list) 
    {
        int i, f = list.size();
        int menor = Integer.MAX_VALUE, maior = Integer.MIN_VALUE;
        //encontrando o maior e o menor numero do array
        for(i = 0; i < f; i++)
        {
            if(list.get(i) < menor )
                menor = list.get(i).intValue();
            if(list.get(i) > maior)
                maior = list.get(i).intValue();
        }
        //calculando amplitude do vetor, do positivo ao negativo
        int amplitudeNegativa = (menor < 0) ? Math.abs(menor) : 0;
        //vetor de contagem de ocorrencias
        int [] countList = new int [ maior + amplitudeNegativa + 1];
        for(i = 0; i < f; i++)
        {
            countList[ list.get(i).intValue() + amplitudeNegativa ]++;
        }
        //somando valores de ocorrencias para determinar a posicao do valor no vetor
        //comeca a incrementar uma posicao a frente da primeira ocorrencia
        for(i = menor + amplitudeNegativa + 1; i <= maior + amplitudeNegativa; i++)
        {   
            countList[i] = countList[i] + countList[i-1];
        }
        //criando o vetor ordenado
        long [] vetorOrdenado = new long [f];
        for(i = f-1; i >= 0; --i)
        {   // de tras pra frente
            int novaPosicao = --countList[ list.get(i).intValue() + amplitudeNegativa ];
            vetorOrdenado[novaPosicao] = list.get(i);
        }
        //atualizando a list
        list.clear();
        for(i = 0; i < f; i++)
            list.add(i, vetorOrdenado[i]);
        
        return list;
    }
    
}

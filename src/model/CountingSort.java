
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marti
 *  date: 19.08.2018
 */
public class CountingSort implements AlgoritmoDeOrdenacao{

    @Override
    public List<Long> ordenar(List<Long> list) 
    {
        int i, f = list.size();
        long menor = Long.MAX_VALUE, maior = Long.MIN_VALUE;
        List <Long> positiveList = new ArrayList();
        for(i = 0; i < f; i++)
        {
            //descobrindo o maior e o menor numero do array
            if (list.get(i) >= 0)
            {
                if(list.get(i) < menor)
                {
                    menor = list.get(i);
                }
                if(list.get(i) > maior)
                {
                    maior = list.get(i);
                }
                positiveList.add(list.get(i));
            }
        }
        //definindo o tamanho de acordo com o maior
        int [] countList = new int [(int)maior + 1];
        //atribuindo 0 aos indices
        for(i = 0; i < maior; i++)
        {
            countList[i] = 0;
        }
        //contando ocorrencias
        int tamanhoArrayPositivo = positiveList.size();
        for(i = 0; i < tamanhoArrayPositivo; i++)
        {
            countList[ positiveList.get(i).intValue() ]++;
        }
        //somando valores de ocorrencias
        for(i = (int) menor + 1; i <= maior; i++)
        {
            countList[i] = countList[i] + countList[i-1];
        }
        //criando lista ordenada
        List orderedList = new ArrayList<Long>();
        for(i = 0; i < f; i++)
        {
            orderedList.add(0);
        }
        for(i = 0; --tamanhoArrayPositivo >= i;)
        {
            int posicao = countList[ positiveList.get(tamanhoArrayPositivo).intValue() ] - 1;
            orderedList.remove( posicao );
            orderedList.add( posicao , positiveList.get(tamanhoArrayPositivo));
            
            //nao entendi pq decrementa
            countList[ positiveList.get(tamanhoArrayPositivo).intValue() ]--;
        }
        
        return orderedList;
    }
    
}

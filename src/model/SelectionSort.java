
package model;

import util.FuncoesLista;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 23.07.2018                                                           *
 ******************************************************************************/
public class SelectionSort implements AlgoritmoDeOrdenacao{
 
    /***************************************************************************
     *  Algoritmo:          Selecion Sort                                      *
     *  Caso:               Melhor          Médio           Pior               *
     *  Complexidade:       O(n^2)          O(n^2)          O(n^2)             *
     *      @param list                                                        *
     *      @return lista ordenada                                             *
     **************************************************************************/
    @Override
    public long [] ordenar(long [] list)
    {
        for(int i = 0; i < list.length ; i++) 
        {   //pivo inicial
            int pivo = i;
            for(int j = i+1; j < list.length; j++) 
            {   //se TRUE entao, pivo agora eh quem estah na posicao j atual
                if (list[j] < list[pivo])
                    pivo = j;       
            }
            //se TRUE entao, encontrou novo pivo menor que o inicial
            if (pivo != i)
                FuncoesLista.swap(list, i, pivo);
        }
        
        return list;
    }
    
}

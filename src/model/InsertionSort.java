
package model;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 21.07.2018                                                           *
 ******************************************************************************/
public class InsertionSort implements AlgoritmoDeOrdenacao{
 
    /***************************************************************************
     *  Algoritmo:      Insertion Sort                                         *
     *  Caso:           Melhor      Medio       Pior                           *
     *  Complexidade:   O(n)        O(n^2)	O(n^2)                         *
     *      @param list                                                        *
     *      @return lista ordenada                                             *
     **************************************************************************/
    @Override
    public long[] ordenar(long[] list)
    {
        for(int i = 1; i < list.length; i++)
        {   //1)j verifica para tras. 2)guardar o valor do pivo inicial.
            int j = i-1;
            long pivo = list[i];    
            //enquanto o pivo for menor que o valor anterior, volte...
            for(; j >= 0 && ( pivo < list[j] ); j-- )
                list[j+1] = list[j];
            list[j+1] = pivo;
        }
        return list;
    }
    
}

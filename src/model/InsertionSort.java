
package model;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 21.07.2018                                                           *
 ******************************************************************************/
public class InsertionSort implements AlgoritmoDeOrdenacao{
 
    /***************************************************************************
     *  Algoritmo           Complexidade                                       *
     *                  Melhor	Médio	Pior                                   *
     *  Insertion Sort	O(n)	O(n^2)	O(n^2)                                 *
     *      @param list                                                        *
     *      @return lista ordenada                                             *
     **************************************************************************/
    @Override
    public long[] ordenar(long[] list)
    {
        for(int i = 1; i < list.length; i++)
        {
            int j = i-1;
            long pivo = list[i];    //guardar o pivo
            //enquanto o pivo for menor que o valor anterior
            for(; j >= 0 && ( pivo < list[j] ); j-- )
                list[j+1] = list[j];
            list[j+1] = pivo;
        }
        return list;
    }
    
}


package control;

import java.util.LinkedList;
import model.AlgoritmoDeOrdenacao;

/**
 * @author marti
 *  date: 21.07.2018
 */
public class InsertionSort implements AlgoritmoDeOrdenacao{
 
    /***************************************************************************
     *  Algoritmo           Complexidade                                       *
     *                  Melhor	Médio	Pior                                   *
     *  Insertion sort	O(n)	O(n2)	O(n2)                                  *
     * @param lista                                                            *
     * @return lista ordenada                                                  *
     **************************************************************************/
    @Override
    public LinkedList ordenar(LinkedList<Integer> lista)
    {
        //busca enquanto nao chegar no fim da lista
        for(int i = 1; i < lista.size(); i++)
        {
            //pivo < anterior ?
            if( lista.get(i) < lista.get(i-1) ) 
            {
                int j = i-1;
                //colocar a verificacao do j>=0 antes, para nao dar NullPoint
                while(j>=0 && (lista.get(i) < lista.get(j))) 
                {
                    j--;
                }
                //de forma didatica, retira-se da posicao atual e depois adciona
                lista.add(j+1, lista.get(i));
                lista.remove(i+1);
            } 
        }
        return lista;
    }
}

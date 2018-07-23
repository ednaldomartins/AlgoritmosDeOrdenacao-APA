
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
     *  Insertion Sort	O(n)	O(n^2)	O(n^2)                                 *
     * @param lista                                                            *
     * @return lista ordenada                                                  *
     **************************************************************************/
    @Override
    public LinkedList ordenar(LinkedList<Integer> lista)
    {
        //busca enquanto nao chegar no fim da lista
        for(int i = 1; i < lista.size(); i++)
        {
            int j = i-1;
            //pivo < anterior ?
            if( lista.get(i) < lista.get(j) ) 
            {
                //colocar a verificacao do j>=0 antes, para nao dar NullPointer
                while(j>=0 && (lista.get(i) < lista.get(j))) 
                {
                    j--;
                }
                //retira o menor da posicao atual e adciona na posicao do pivo, empurrando o pivo pra frente.
                lista.add(j+1, lista.remove(i));
            } 
        }
        return lista;
    }
}

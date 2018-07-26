
package control;

import java.util.LinkedList;
import model.AlgoritmoDeOrdenacao;

/**
 * @author marti
 *  date: 23.07.2018
 */
public class SelectionSort implements AlgoritmoDeOrdenacao{
 
    /***************************************************************************
     *  Algoritmo           Complexidade                                       *
     *                  Melhor	Médio	Pior                                   *
     *  Selecion Sort	O(n^2)	O(n^2)	O(n^2)                                 *
     * @param lista                                                            *
     * @return lista ordenada                                                  *
     **************************************************************************/
    @Override
    public LinkedList ordenar(LinkedList<Integer> lista)
    {
        int tamanhoLista = lista.size();
        for(int i = 0; i < tamanhoLista ; i++) 
        {
            //caso tenha que haver troca, entao true pra o ultimo IF
            boolean troca = false;
            //k (pivo)
            int k = i;
            for(int j = i+1; j < tamanhoLista; j++) 
            {
                if (lista.get(j) < lista.get(k))
                {
                    //novo pivo eh quem estah na posicao j atual.
                    k = j;
                    troca = true;
                }
            }
            
            if (troca)
            {
                //adicionando na nova posicao, quem estou removendo da anterior
                lista.add(i, lista.remove(k));
                lista.add(k, lista.remove(i+1));
            }
        }
        
        return lista;
    }
    
}

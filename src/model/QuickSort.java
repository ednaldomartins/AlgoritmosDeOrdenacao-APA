
package model;

import util.FuncoesLista;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 12.08.2018                                                           *
 *******************************************************************************/
public class QuickSort implements AlgoritmoDeOrdenacao{

    /***************************************************************************
     *  Algoritmo:      QuickSort                                              *                                              
     *  Caso:           Melhor          Médio           Pior                   *
     *  Complexidade:   O(n log n)		O(n log n)		O(n ^ 2)               *
     *      @param list                                                        *
     *      @return list ordenada                                              *
     **************************************************************************/
    @Override
    public long [] ordenar(long [] list) {
        quickPivoFixo(list, list.length, 0, list.length - 1);
        return list;
    }

    private void quickPivoFixo(long [] list, int tamanhoLista, int inferior, int superior) {
        if(inferior < superior)
        {
            int i = inferior + 1, j = superior;
            int pivo = inferior;
            while(i <= j)
            {
                //enquanto nao chegar no fim da lista, e novo valor nao for menor que o pivo
                while(i <= superior && list[i] < list[pivo]) {i++;}
                while(j > inferior && list[j] > list[pivo]) {j--;}
                //chegou no ponto de troca
                if(i <= j)
                {
                    FuncoesLista.swap(list, i, j);
                    i++; j--;
                }
            }
            //se for diferente entao o pivo nao estah ordenado
            if(pivo != j)
                FuncoesLista.swap(list, j, pivo);
            //recursao para o lado direito e lado esquerdo
            quickPivoFixo(list, tamanhoLista, inferior, j - 1 );
            quickPivoFixo(list, tamanhoLista, j + 1, superior);
        }
    }
    
}

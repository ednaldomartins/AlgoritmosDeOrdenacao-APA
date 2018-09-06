
package model;

import util.FuncoesLista;

/*******************************************************************************
 * @author marti                                                               *
 *  date 29.08.2018                                                            *
 ******************************************************************************/
public class HeapSort implements AlgoritmoDeOrdenacao{
    
    /***************************************************************************
     *  Algoritmo:          HeapSort                                           *
     *  Caso:               Melhor          Médio           Pior               *         
     *  Complexidade:       O(n log n)      O(n log n)      O(n log n)         *
     *      @param list                                                        *
     *      @return list ordenada                                              *
     **************************************************************************/
    @Override
    public long [] ordenar(long [] list)
    {
        BuildMaxHeap(list, list.length);
        //trocando o primeiro(maior) pelo ultimo, retirando o maior do proximo MaxHeapify
        for(int indice = list.length-1; indice > 0; indice--)
        {   //swap de indice e pivo(0)
            FuncoesLista.swap(list, indice, 0);
            MaxHeapify(list, 0, indice);
        }
        return list;
    }
    
    private void BuildMaxHeap(long [] list, int tamanhoLista)
    {   //indice do primeiro NO (pai) eh (n-2)/2
        for(int indice = (tamanhoLista-2)/2; indice >= 0; indice--)
            MaxHeapify(list, indice, tamanhoLista);
    }
    
    private void MaxHeapify (long [] list, int pai, int tamanhoLista)
    {
        int filhoE = pai*2 + 1;
        int filhoD = pai*2 + 2;
        int indiceMaior = pai;
        //verificar se o filho esquerdo eh maior que o pai
        if( filhoE < tamanhoLista && list[filhoE] > list[indiceMaior] )
            indiceMaior = filhoE;
        //verificar se o filho direito eh maior que o pai ou filho esquerdo
        if( filhoD < tamanhoLista && list[filhoD] > list[indiceMaior] )
            indiceMaior = filhoD;
        //se for diferente, entao o pai nao eh o maior
        if( indiceMaior != pai)
        {   //swap de indiceMaior e o pivo(pai)
            FuncoesLista.swap(list, indiceMaior, pai);
            //reordena o heap a partir do pai que se tornou filho
            MaxHeapify(list, indiceMaior, tamanhoLista);
        }   
    }
 
}


package model;

import java.util.List;

/*******************************************************************************
 * @author marti                                                               *
 *  date 29.08.2018                                                            *
 ******************************************************************************/
public class HeapSort implements AlgoritmoDeOrdenacao{
    
    /***************************************************************************
     *  Algoritmo:          HeapSort                                           *
     *  Caso:               Melhor          Médio           Pior               *         
     *  Complexidade:       O(n log n)      O(n log n)      O(n log n)         *
     * @param list                                                             *
     * @return list ordenada                                                   *
     **************************************************************************/
    @Override
    public List<Long> ordenar(List<Long> list)
    {
        int tamanhoLista = list.size();
        Long [] lista = new Long[tamanhoLista];
        list.toArray(lista);
        BuildMaxHeap(lista, tamanhoLista);
        //trocando o primeiro(maior) pelo ultimo, retirando o maior do proximo MaxHeapify
        for(int indice = tamanhoLista-1; indice > 0; indice--)
        {
            long temp = lista[0];
            lista[0] = lista[indice];
            lista[indice] = temp;
            MaxHeapify(lista, 0, indice);
        }
        list.clear();
        for(int i = 0; i < tamanhoLista; i++)
            list.add(i, lista[i]);
                
        return list;
    }
    
    private void BuildMaxHeap(Long[] lista, int tamanhoLista)
    {
        //indice do primeiro NO (pai) eh (n-2)/2
        for(int indice = (tamanhoLista-2)/2; indice >= 0; indice--)
            MaxHeapify(lista, indice, tamanhoLista);
    }
    
    private void MaxHeapify (Long[] lista, int pai, int tamanhoLista)
    {
        int filhoE = pai*2 + 1;
        int filhoD = pai*2 + 2;
        int indiceMaior = pai;
        //verificar se o filho esquerdo eh maior que o pai
        if( filhoE < tamanhoLista && lista[filhoE] > lista[indiceMaior] )
            indiceMaior = filhoE;
        //verificar se o filho direito eh maior que o pai ou filho esquerdo
        if( filhoD < tamanhoLista && lista[filhoD] > lista[indiceMaior] )
            indiceMaior = filhoD;
        //se for diferente, entao o pai nao eh o maior
        if( indiceMaior != pai)
        {
            //adicionando na nova posicao, quem estou removendo da anterior
            long temp = lista[pai];
            lista[pai] = lista[indiceMaior];
            lista[indiceMaior] = temp;
            //reordena o heap a partir do pai que se tornou filho
            MaxHeapify(lista, indiceMaior, tamanhoLista);
        }   
    }
 
}

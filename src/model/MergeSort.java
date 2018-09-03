
package model;

/*******************************************************************************
 * @author marti                                                               * 
 *  date: 11.08.2018                                                           * 
 *******************************************************************************/
public class MergeSort implements AlgoritmoDeOrdenacao{

    /***************************************************************************
     *  Algoritmo:      MergeSort                                              *
     *  Caso:           Melhor          Médio           Pior                   *
     *  Complexidade:   O(n log n)	O(n log n)	O(n log n)             *
     *      @param list                                                        *
     *      @return list ordenada                                              *
     **************************************************************************/
    @Override
    public long [] ordenar(long [] list) 
    {
        dividir(list, 0, list.length - 1 );
        return list;
    }

    private void dividir(long[] list, int inferior, int superior) 
    {
        if(inferior < superior){
            int meio = (inferior + superior)/2;
            //divide a list do comeco para o meio
            dividir(list, inferior, meio);
            //divide a list do meio para o fim
            dividir(list, meio+1, superior);
            //apos voltar da recursao e nao dividir mais, entao devemos mesclar
            mesclar(list, inferior, superior, meio);
        }
    }

    private void mesclar(long[] list, int inferior, int superior, int meio) 
    {
        //criando listas auxiliares
        int tamanhoInferior = meio - inferior + 1;
        int tamanhoSuperior = superior - meio;
        Long [] listaInferior = new Long[tamanhoInferior];        
        Long [] listaSuperior = new Long[tamanhoSuperior];
        //atribuindo valores da parte inferior da list a listaInferior
        for(int j = 0; j < tamanhoInferior; j++)
            listaInferior[j] = list[inferior + j];
        //atribuindo valores da parte superior da list a listaSuperior
        for(int j = 0; j < tamanhoSuperior; j++)
            listaSuperior[j] = list[meio + j + 1];
        //i: posicao da listaInfeior, s: posicao da listaSuperior
        int i = 0, s = 0, n = inferior;
        while(i < tamanhoInferior && s < tamanhoSuperior)
        {   //comparando valores das duas listas para atribuir valores menores primeiro
            if(listaInferior[i] <= listaSuperior[s])
            {   
                list[n] = listaInferior[i];
                i++;
            }
            else 
            {
                list[n] = listaSuperior[s];
                s++;
            }
            n++;
        }
        //completando vetor com os valores restantes (maiores)
        while(i < tamanhoInferior)
        {
            list[n] = listaInferior[i];
            i++;
            n++;
        }
        while(s < tamanhoSuperior)
        {
            list[n] = listaSuperior[s];
            s++;
            n++;
        }
    }
    
}

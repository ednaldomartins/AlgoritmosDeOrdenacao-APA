
package model;

import java.util.List;

/*******************************************************************************
 * @author marti                                                               * 
 *  date: 11.08.2018                                                           * 
 *******************************************************************************/
public class MergeSort implements AlgoritmoDeOrdenacao{

    @Override
    public List<Long> ordenar(List<Long> list) 
    {
        int tamanhoLista = list.size();
        Long [] lista = new Long[tamanhoLista];
        list.toArray(lista);
        dividir(lista, 0, tamanhoLista - 1 );
        //alterando list
        list.clear();
        for(int i = 0; i < tamanhoLista; i++)
        {
            list.add(i, lista[i]);
        }
        return list;
    }

    private void dividir(Long[] lista, int inferior, int superior) 
    {
        if(inferior < superior){
            int meio = (inferior + superior)/2;
            //divide a lista do comeco para o meio
            dividir(lista, inferior, meio);
            //divide a lista do meio para o fim
            dividir(lista, meio+1, superior);
            //apos voltar da recursao e nao dividir mais, entao devemos mesclar
            mesclar(lista, inferior, superior, meio);
        }
    }

    private void mesclar(Long[] lista, int inferior, int superior, int meio) 
    {
        //criando listas auxiliares
        int tamanhoInferior = meio - inferior + 1;
        int tamanhoSuperior = superior - meio;
        Long [] listaInferior = new Long[tamanhoInferior];        
        Long [] listaSuperior = new Long[tamanhoSuperior];
        for(int j = 0; j < tamanhoInferior; j++)
        {
            listaInferior[j] = lista[inferior + j];
        }
        for(int j = 0; j < tamanhoSuperior; j++)
        {
            listaSuperior[j] = lista[meio + j + 1];
        }
        //i: posicao da listaInfeior, s: posicao da listaSuperior
        int i = 0, s = 0, n = inferior;
        while(i < tamanhoInferior && s < tamanhoSuperior)
        {
            if(listaInferior[i] <= listaSuperior[s])
            {
                lista[n] = listaInferior[i];
                i++;
            }
            else 
            {
                lista[n] = listaSuperior[s];
                s++;
            }
            n++;
        }
        //completando vetor com os valores maiores
        while(i < tamanhoInferior)
        {
            lista[n] = listaInferior[i];
            i++;
            n++;
        }
        while(s < tamanhoSuperior)
        {
            lista[n] = listaSuperior[s];
            s++;
            n++;
        }
    }
    
}

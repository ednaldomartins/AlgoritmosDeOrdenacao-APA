
package model;

import java.util.List;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 12.08.2018                                                           *
 *******************************************************************************/
public class QuickSort implements AlgoritmoDeOrdenacao{

    @Override
    public List<Long> ordenar(List<Long> list) {
        int tamanhoLista = list.size();
        quickPivoFixo(list, tamanhoLista, 0, tamanhoLista - 1);
        return list;
    }

    private void quickPivoFixo(List<Long> list, int tamanhoLista, int inferior, int superior) {
        if(inferior < superior)
        {
            int i = inferior + 1, j = superior;
            int pivo = inferior;
            while(i <= j)
            {
                //superior ou j
                while(i <= superior && list.get(i) < list.get(pivo)) {i++;}
                while(list.get(j) > list.get(pivo)) {j--;}
                //chegou no ponto de troca
                if(i < j)
                {
                    //sao diferentes, entao trocar
                    list.add(i, list.remove(j));
                    list.add(j, list.remove(i+1));
                    i++; j--;
                }
                //quando i=j pode ser um conteudo de mesmo valor do pivo, entao
                //o conteudo de j-1 pode ser colocado no lugar do pivo, pois e menor
                else if( i == j) {i++; j--;}
            }
            //se nao for diferente entao o pivo ja esta ordenado
            if(pivo != j)
            {
                list.add(pivo, list.remove(j));
                list.add(j, list.remove(pivo+1));
            }
            //recursao para o lado direito e lado esquerdo
            quickPivoFixo(list, tamanhoLista, inferior, j - 1 );
            quickPivoFixo(list, tamanhoLista, j + 1, superior);
        }
    }
    
}


package util;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 02.09.2018                                                           *
 ******************************************************************************/
public class FuncoesLista {
    
    public static void swap ( long [] list, int i, int pivo )
    {
        long temp = list[pivo];
        list[pivo] = list[i];
        list[i] = temp;
    }
    
    public static void copiarLista ( long [] original, long [] copia )
    {
        if(copia.length >= original.length)
        {
            for(int i = 0; i < original.length; i++)
                copia[i] = original[i];
        }
        else
            System.err.println("Nao foi possivel copiar o vetor original, pois o orginal eh maior do que a copia");
    }
}


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
}

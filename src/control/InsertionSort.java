
package control;

import java.util.List;
import model.AlgoritmoDeOrdenacao;
import model.Lista;
import model.No;

/**
 * @author marti
 *  date: 21.07.2018
 */
public class InsertionSort implements AlgoritmoDeOrdenacao{

    private List lista;
    
    public InsertionSort(List lista) 
    {
        this.lista = lista;
    }

    @Override
    public List ordenar()
    {
        
        return this.lista;
    }

    private void avancar(No auxiliar, No pivo)
    {
        auxiliar = pivo;
        pivo = pivo.getNoPosterior();
    }

    private void ordenarValor(No auxiliar, No pivo) 
    {
        
            
    }
    
    
}


package control;

import infra.Arquivo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlgoritmoDeOrdenacao;

/**
 * @author marti
 *  date: 21.07.2018
 */
public class ControllerOrdenacao {
    private LinkedList listaOrdenada;
    private LinkedList listaDesordenada;
    private final String ARQUIVO_ORIGEM = "..\\AlgoritmosDeOrdenacao\\listaDesordenada.txt";
    private final String ARQUIVO_DESTINO = "..\\AlgoritmosDeOrdenacao\\listaOrdenada.txt";

    public ControllerOrdenacao()
    {
        this.listaDesordenada = carregarListaArquivo();
    }

    /**************************************************************************
    *   Esse metodo usa a Interface AlgoritmoDeOrdenacao para receber um tipo *
    *   da dessa Interface e ordenar de acordo com o Objeto recebido.         *  
    ***************************************************************************/
    public void ordenarLista (AlgoritmoDeOrdenacao algoritmoDeOrdenacao)
    {
        listaOrdenada = new LinkedList<Integer>(listaDesordenada);
        algoritmoDeOrdenacao.ordenar(listaOrdenada);
    }
    
    public List getListaOrdenada() {
        return listaOrdenada;
    }
    
    
    /**************************************************************************
    *   Metodos para retornar Lista do Arquivo e para salvar Lista no Arquivo *
    *   Geralmente serão usados caso seja necessário fazer uma chamada direta *
    *   na main.                                                              *  
     * @return 
    ***************************************************************************/
    public LinkedList carregarListaArquivo ()  
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarLista();
        } catch (IOException ex) {
            Logger.getLogger(ControllerOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void salvarListaArquivo (List numeros)  
    {
        try {
            new Arquivo(ARQUIVO_DESTINO).salvarLista((LinkedList<Integer>) numeros);
        } catch (IOException ex) {
            Logger.getLogger(ControllerOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

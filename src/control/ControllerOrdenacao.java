
package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import infra.Arquivo;
import model.AlgoritmoDeOrdenacao;

/*******************************************************************************
 * @author marti                                                               *
 *  date: 21.07.2018                                                           *
 ******************************************************************************/
public class ControllerOrdenacao {
    private long [] listaOrdenada;
    private final long [] listaDesordenada;
    private double tempoDeOrdenacao;
    private final String ARQUIVO_ORIGEM = "..\\AlgoritmosDeOrdenacao\\listaDesordenada.txt";
    private final String ARQUIVO_DESTINO = "..\\AlgoritmosDeOrdenacao\\listaOrdenada.txt";

    public ControllerOrdenacao()
    {
        this.listaDesordenada = carregarListaArquivo();
    }

    /***************************************************************************
    *   Esse metodo usa a Interface AlgoritmoDeOrdenacao para receber um tipo  *
    *   dessa Interface e ordenar de acordo com o Objeto recebido.             *  
    *   @param algoritmoDeOrdenacao                                            *
    ***************************************************************************/
    public void ordenarLista (AlgoritmoDeOrdenacao algoritmoDeOrdenacao)
    {
        double tempoInicial = System.currentTimeMillis();
        algoritmoDeOrdenacao.ordenar(listaDesordenada);
        this.tempoDeOrdenacao = System.currentTimeMillis() - tempoInicial;
    }
    
    public long[] getListaOrdenada() {
        return this.listaDesordenada;
    }
    
    public double getTempoDeOrdenacao (){
        return this.tempoDeOrdenacao;
    }
    
    
    /***************************************************************************
    *   Metodos para retornar Lista do Arquivo e para salvar Lista no Arquivo  *
    *   Geralmente serão usados caso seja necessário fazer uma chamada direta  *
    *   na main.                                                               *  
    *   @return                                                                * 
    ***************************************************************************/
    public long [] carregarListaArquivo ()  
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarLista();
        } catch (IOException ex) {
            Logger.getLogger(ControllerOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void salvarListaArquivo (long [] list)  
    {
        try {
            new Arquivo(ARQUIVO_DESTINO).salvarLista(list);
        } catch (IOException ex) {
            Logger.getLogger(ControllerOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
}

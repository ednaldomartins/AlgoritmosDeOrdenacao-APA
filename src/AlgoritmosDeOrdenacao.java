
import control.ControllerOrdenacao;
import control.InsertionSort;
import control.SelectionSort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author marti
 */
public class AlgoritmosDeOrdenacao {

    public static void main(String[] args)  {
        // TODO code application logic here
        //Controladora
        ControllerOrdenacao control = new ControllerOrdenacao();        
        /*
         * Comparar tempo das ordenacoes e tambem tempo do tipo de Listas
         * -> LinkedList nesse tipo de situacao tem um desempenho pior do que
         * ArrayList.
         * -> O tempo medio de ordenacao do InsertionSort eh melhor do que o 
         * Selection Sort.
         */      
        control.ordenarLista( new InsertionSort(), new ArrayList() );
        System.out.println("o metodo executou em " + control.getTempoDeOrdenacao() /1000);      
        
        control.ordenarLista( new InsertionSort(), new LinkedList() );
        System.out.println("o metodo executou em " + control.getTempoDeOrdenacao() /1000);
        
        control.ordenarLista( new SelectionSort(), new ArrayList() );
        System.out.println("o metodo executou em " + control.getTempoDeOrdenacao() /1000);     
              
        control.ordenarLista( new SelectionSort(), new LinkedList() );
        System.out.println("o metodo executou em " + control.getTempoDeOrdenacao() /1000);
        
//        control.getListaOrdenada().forEach((numero) -> {
//            System.out.println(numero);
//        });
        
        control.salvarListaArquivo(control.getListaOrdenada());
    }
    
}

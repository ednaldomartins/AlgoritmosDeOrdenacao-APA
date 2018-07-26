
import control.ControllerOrdenacao;
import control.InsertionSort;
import control.SelectionSort;

/**
 * @author marti
 */
public class AlgoritmosDeOrdenacao {

    public static void main(String[] args)  {
        // TODO code application logic here
        ControllerOrdenacao control = new ControllerOrdenacao();
        //control.ordenarLista( new InsertionSort() );
        control.ordenarLista( new SelectionSort() );
        
        control.getListaOrdenada().forEach((numero) -> {
            System.out.println(numero);
        });
        
        control.salvarListaArquivo(control.getListaOrdenada());
    }
    
}

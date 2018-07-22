
import control.ControllerOrdenacao;
import control.InsertionSort;

/**
 * @author marti
 */
public class AlgoritmosDeOrdenacao {

    public static void main(String[] args)  {
        // TODO code application logic here
        ControllerOrdenacao control = new ControllerOrdenacao();
        control.ordenarLista( new InsertionSort() );
        
        control.getListaOrdenada().forEach((numero) -> {
            System.out.println(numero);
        });
        
        control.salvarListaArquivo(control.getListaOrdenada());
    }
    
}

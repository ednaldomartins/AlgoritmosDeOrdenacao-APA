
import control.ControllerOrdenacao;
import control.InsertionSort;
import model.No;

/**
 *
 * @author marti
 */
public class AlgoritmosDeOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        ControllerOrdenacao control = new ControllerOrdenacao();
        control.ordenarLista(new InsertionSort( control.carregarListaArquivo() ));
        
        control.getListaOrdenada().forEach((numero) -> {
            System.out.println(numero);
        });
        
        control.salvarListaArquivo(control.getListaOrdenada());
    }
    
}

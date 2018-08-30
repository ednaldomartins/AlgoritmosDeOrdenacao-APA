
import control.ControllerOrdenacao;
import model.InsertionSort;
import model.SelectionSort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import model.CountingSort;
import model.HeapSort;
import model.MergeSort;
import model.QuickSort;

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
        int opcao;
        do{
            System.out.println("Escolha a Opcao abaixo: \n"
                    + "1. Insertion Sort com ArrayList \n"
                    + "2. Insertion Sort com LinkedList \n"
                    + "3. Selection Sort com ArrayList \n"
                    + "4. Selection Sort com LinkedList \n"
                    + "5. Merge Sort \n"
                    + "6. Quick Sort \n"
                    + "7. Counting Sort \n"
                    + "8. Heap Sort \n"
                    + "9. Salvar Lista Ordenada \n"
                    + "0. Sair \n\n");
            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();
            switch(opcao) {
                case 1:
                    control.ordenarLista( new InsertionSort(), new ArrayList() );
                    System.out.println("o metodo InsertionSort executou em " + control.getTempoDeOrdenacao() /1000);   
                    break;
                case 2:
                    control.ordenarLista( new InsertionSort(), new LinkedList() );
                    System.out.println("o metodo InsertionSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;

                case 3:
                    control.ordenarLista( new SelectionSort(), new ArrayList() );
                    System.out.println("o metodo SelectionSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;

                case 4:
                    control.ordenarLista( new SelectionSort(), new LinkedList() );
                    System.out.println("o metodo SelectionSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                    
                case 5:
                    control.ordenarLista(new MergeSort(), new ArrayList());
                    System.out.println("o metodo MergeSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                    
                case 6:
                    control.ordenarLista(new QuickSort(), new ArrayList());
                    System.out.println("o metodo QuickSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                
                case 7:
                    control.ordenarLista(new CountingSort(), new ArrayList());
                    System.out.println("o metodo CountingSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                   
                case 8:
                    control.ordenarLista(new HeapSort(), new ArrayList());
                    System.out.println("o metodo HeapSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                    
                case 9:
                    control.salvarListaArquivo(control.getListaOrdenada());
                    break;
                    
                case 0:
                    return;

                default:
                    System.out.println("opcao invalida\n");
            }

        }while(opcao != 0);
        
    }
    
}

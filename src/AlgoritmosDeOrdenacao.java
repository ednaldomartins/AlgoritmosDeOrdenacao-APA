
import java.util.Scanner;

import control.ControllerOrdenacao;
import model.InsertionSort;
import model.SelectionSort;
import model.MergeSort;
import model.QuickSort;
import model.CountingSort;
import model.HeapSort;

/*******************************************************************************
 * @author marti                                                               *
 *  date 20.07.2018                                                            *
 ******************************************************************************/
public class AlgoritmosDeOrdenacao {

    public static void main(String[] args)  
    {
        // TODO code application logic here
        //Controlador
        ControllerOrdenacao control = new ControllerOrdenacao();
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Escolha a Opcao abaixo: \n"
                    + "1. InsertionSort \n"
                    + "2. SelectionSort \n"
                    + "3. MergeSort \n"
                    + "4. QuickSort \n"
                    + "5. CountingSort \n"
                    + "6. HeapSort \n"
                    + "7. Salvar Lista Ordenada \n"
                    + "0. Sair \n\n");
            switch( opcao = entrada.nextInt() ) {
                case 1:
                    control.ordenarLista( new InsertionSort() );
                    System.out.println("o metodo InsertionSort executou em " + control.getTempoDeOrdenacao() /1000);   
                    break;
                case 2:
                    control.ordenarLista( new SelectionSort() );
                    System.out.println("o metodo InsertionSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                    
                case 3:
                    control.ordenarLista( new MergeSort() );
                    System.out.println("o metodo MergeSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                    
                case 4:
                    control.ordenarLista( new QuickSort() );
                    System.out.println("o metodo QuickSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                
                case 5:
                    control.ordenarLista( new CountingSort() );
                    System.out.println("o metodo CountingSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                   
                case 6:
                    control.ordenarLista( new HeapSort() );
                    System.out.println("o metodo HeapSort executou em " + control.getTempoDeOrdenacao() /1000);
                    break;
                    
                case 7:
                    control.salvarListaArquivo( control.getListaOrdenada() );
                    break;
                    
                case 0:
                    return;

                default:
                    System.out.println("opcao invalida\n");
            }
        }while(opcao != 0);
    }
    
}

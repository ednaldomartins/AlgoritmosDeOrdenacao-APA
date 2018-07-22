
package model;

/**
 * @author marti
 *  date: 20.07.2018
 */
public class Lista {
    private No cabeca;
    private No calda;
    private int tamanho;
    
    public Lista () {
        this.cabeca = null;
        this.calda = null;
        this.tamanho = 0;
    }
    
    public Lista (No novoNo) {
        this.cabeca = novoNo;
        this.calda = novoNo;
        this.tamanho = 1;
    }
    
    public void criarLista (No novoNo) {
        this.cabeca = novoNo;
        this.calda = novoNo;
        this.tamanho = 1;
    }

    
    /**************************************************************************
    *   Esses metodos sao usados para adicionar um novo No a Lista.           *  
    ***************************************************************************/
    public void addNo(No novoNo) {
        this.calda.setNoPosterior(novoNo);
        novoNo.setNoAnterior(this.calda);
        this.setCalda(novoNo);
        this.incrementarTamanho();
    }
    
    private void incrementarTamanho() {
        this.tamanho++;
    }
        
        
    public No getCabeca() {
        return cabeca;
    }

    public No getCalda() {
        return calda;
    }

    public int getTamanho() {
        return tamanho;
    }
    

    public void setCabeca(No cabeca) {
        this.cabeca = cabeca;
    }

    public void setCalda(No calda) {
        this.calda = calda;
    }
}
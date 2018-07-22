
package model;

/**
 * @author marti
 *  date: 20.07.2018
 */
public class No {
    private int valor;
    private No noAnterior;
    private No noPosterior;
    
    public No (int valor) {
        this.valor = valor;
        this.noAnterior = null;
        this.noPosterior = null;
    }

    public No() {
       
    }
    
    

    public int getValor() {
        return valor;
    }

    public No getNoAnterior() {
        return noAnterior;
    }

    public No getNoPosterior() {
        return noPosterior;
    }

    
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setNoAnterior(No noAnterior) {
        this.noAnterior = noAnterior;
    }

    public void setNoPosterior(No noPosterior) {
        this.noPosterior = noPosterior;
    }
    
    
}

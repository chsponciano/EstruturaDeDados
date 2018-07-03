package lista;

/**
 *
 * @author Carlos Henrique Ponciano da Silva
 */

public abstract class ListaAbstract<T>{
     private T[] info;
    private int tamanho;

    public ListaAbstract() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    protected T[] redimencionar() {
        T[] novo = (T[]) new Object[tamanho + 10];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
        return info;
    }

    public abstract void inserir(T valor);

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public abstract int buscar(T valor);

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        String conteudo = "";
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                conteudo += ",";
            }
            conteudo += info[i];
        }
        return conteudo;
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            int pos = tamanho - 1 - i;
            T aux = info[i];
            info[i] = info[pos];
            info[pos] = aux;
        }
    }

    public boolean listaIgual(ListaAbstract objeto) {
        ListaAbstract outraLista = (ListaAbstract) objeto;
        if (this.getTamanho() != outraLista.getTamanho()) {
            return false;
        }
        for (int i = 0; i < this.getTamanho(); i++) {
            if (this.info[i].equals(outraLista.info[i])) {
                return false;
            }
        }
        return true;
    }

    protected T[] getInfo() {
        return info;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}

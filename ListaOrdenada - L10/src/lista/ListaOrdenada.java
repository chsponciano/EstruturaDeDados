package lista;

/**
 *
 * @author Carlos Henrique Ponciano da Silva
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T>{
   
    @Override
    public void inserir(T valor) {
        Object[] info = getInfo();
        if (info.length == getTamanho()) {
            info = redimencionar();
        }
        int posicao = procurarPosicaoInclusao(valor);
        if (posicao < getTamanho()) {
            deslocarDados(posicao);
        }
        info[posicao] = valor;
        setTamanho(getTamanho() + 1);
    }

    @Override
    public int buscar(T valor) {
        Object[] info = getInfo();
        int inicio = 0;
        int fim = getTamanho() - 1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            int comparacao = valor.compareTo((T) info[meio]);
            if (comparacao < 0) {
                fim = meio - 1;
            } else {
                if (comparacao > 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
        }
        return -1;
    }

    private void deslocarDados(int posicao) {
        Object[] info = getInfo();
        for (int i = getTamanho() - 1; i >= posicao; i--) {
            info[i + 1] = info[i];
        }
    }

    private int procurarPosicaoInclusao(T itemAdicionar) {
        Object[] info = getInfo();
        int i;
        for (i = 0; i < getTamanho(); i++) {
            if (((Comparable) info[i]).compareTo(itemAdicionar) > 0) {
                break;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
        ListaOrdenada<Integer> o = new ListaOrdenada();
        o.inserir(5);        
        o.inserir(2);      
        o.inserir(9);      
        o.inserir(1);      
        o.inserir(0);      
        o.inserir(10);      
        o.inserir(3);
        System.out.println(o);

    }
}

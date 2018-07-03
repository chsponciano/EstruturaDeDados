package lista;

/**
 *
 * @author Carlos Henrique Ponciano da Silva
 */
public class ListaEstatica<T> extends ListaAbstract<T>{
    
     public void inserir(T valor) {
        T[] info = getInfo();
        if (getTamanho() == info.length) {
            redimencionar();
        }
        info[getTamanho()] = valor;
        setTamanho(getTamanho() + 1);
    }

    public int buscar(T valor) {
        T[] info = getInfo();
        for (int i = 0; i < getTamanho(); i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}

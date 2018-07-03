
/**
 *
 * @author Carlos Henrique Ponciano da Silva
 */

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        } else if (no.getInfo().equals(info)) {
            return no;
        } else {
            NoArvoreBinaria<T> aux = buscar(no.getEsquerda(), info);
            if (aux == null) {
                aux = buscar(no.getDireita(), info);
            }
            return aux;
        }
    }
}

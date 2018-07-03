
/**
 * @author Carlos Henrique Ponciano da Silva
 */
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        boolean pulou;
        T[] arr = super.getInfo();
        int aux = arr.length;

        for (int i = aux - 1; i > 1; i--) {
            pulou = false;

            for (int j = 0; j <= i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    this.trocar(j, j + 1);
                    pulou = true;
                }
            }

            if (!pulou) {
                return;
            }
        }
    }
}

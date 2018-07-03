
/**
 * @author Carlos Henrique Ponciano da Silva
 */
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        mergeSort(0, super.getInfo().length - 1);
    }

    //Divide
    private void mergeSort(int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }

        int meio = (inicio + fim) / 2;
        mergeSort(inicio, meio);
        mergeSort(meio + 1, fim);
        merge(inicio, fim, meio);
    }

    //Intercalar
    private void merge(int inicio, int fim, int meio) {
        T[] data = super.getInfo();
        T[] temp = (T[]) new Comparable[data.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = data[i];
        }

        int auxInicio = inicio;
        int auxMeio = meio + 1;

        for (int i = inicio; i <= fim; i++) {
            if (auxInicio == meio + 1) {
                data[i] = temp[auxMeio++];
            } else if (auxMeio > fim) {
                data[i] = temp[auxInicio++];
            } else if (temp[auxInicio].compareTo(temp[auxMeio]) <= 0) {
                data[i] = temp[auxInicio++];
            } else {
                data[i] = temp[auxMeio++];
            }
        }

        super.setInfo(data);
    }
    
    public static void main(String[] args) {
        OrdenacaoMergeSort<Integer> o = new OrdenacaoMergeSort<>();
        o.setInfo(new Integer[]{5, 2, 1, 54, 78, 32, 20, 0, 51, 99, 63, 12, 4, 3});
        System.out.println("Não ordenada: " + o);        
        o.ordenar();
        System.out.println("Ordenada: " + o);
        
    }
}



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
//        Professor
        int tmEsq = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tmEsq];
        for(int i = 0; i < tmEsq; i++){
            esquerda[i] = this.getInfo()[i];
        }
        
        int tmDir = fim - meio;
        T[] direita = (T[]) new Comparable[tmDir];
        for(int i = 0; i < tmDir; i++){
            direita[i] = this.getInfo()[meio+1+i];
        }
        
        int cEsq = 0, cDir = 0;
        int i = 0;
        for(i = inicio; i <= fim; i++){
            if((cEsq < tmEsq) && (cDir < tmDir)){
                if(esquerda[cEsq].compareTo(direita[cDir]) < 0){
                    this.getInfo()[i] = esquerda[cEsq++];
                }else{
                    this.getInfo()[i] = direita[cDir++];
                }
            }else{
                break;
            }
        }
        
        while(cEsq < tmEsq){
            this.getInfo()[i++] = esquerda[cEsq++];
        }
        while(cDir < tmDir){
            this.getInfo()[i++] = direita[cDir++];
        }
        
        
//        Codigo antigo
//        T[] data = super.getInfo();
//        T[] temp = (T[]) new Comparable[data.length];
//
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = data[i];
//        }
//
//        int auxInicio = inicio;
//        int auxMeio = meio + 1;
//
//        for (int i = inicio; i <= fim; i++) {
//            if (auxInicio == meio + 1) {
//                data[i] = temp[auxMeio++];
//            } else if (auxMeio > fim) {
//                data[i] = temp[auxInicio++];
//            } else if (temp[auxInicio].compareTo(temp[auxMeio]) <= 0) {
//                data[i] = temp[auxInicio++];
//            } else {
//                data[i] = temp[auxMeio++];
//            }
//        }
//
//        super.setInfo(data);
    }
    
    public static void main(String[] args) {
        OrdenacaoMergeSort<Integer> o = new OrdenacaoMergeSort<>();
        o.setInfo(new Integer[]{5, 2, 1, 54, 78, 32, 20, 0, 51, 99, 63, 12, 4, 3});
        System.out.println("Não ordenada: " + o);        
        o.ordenar();
        System.out.println("Ordenada: " + o);
        
    }
}


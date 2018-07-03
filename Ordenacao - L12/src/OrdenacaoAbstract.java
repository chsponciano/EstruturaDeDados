/**
 * @author Carlos Henrique Ponciano da Silva
 */
public abstract class OrdenacaoAbstract<T extends Comparable<T>> {
    
    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }
    
    public void trocar(int a, int b) {
        T t = this.info[a];
        this.info[a] = this.info[b];
        this.info[b] = t;
    }
    
    public abstract void ordenar();

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.info.length; i++) {
            str += this.info[i] + " ";
        }
        return str;
    }
    
}

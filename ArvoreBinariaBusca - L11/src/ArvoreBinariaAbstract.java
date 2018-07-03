
public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public Boolean estaVazia() {
        return this.raiz == null;
    }

    public Boolean pertence(T info) {
        return buscar(info) != null;
    }

    public Integer contarNos() {
        return contarNos(this.raiz);
    }

    @Override
    public String toString() {
        return arvorePre(this.raiz);
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    private Integer contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }

        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }

        StringBuilder builder = new StringBuilder();

        builder.append("<")
                .append(no.getInfo())
                .append(arvorePre(no.getEsquerda()))
                .append(arvorePre(no.getDireita()))
                .append(">");

        return builder.toString();
    }
}

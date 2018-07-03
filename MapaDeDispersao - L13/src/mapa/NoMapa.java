package mapa;

/**
 *
 * @author Carlos Henrique Ponciano da Silva
 */

public class NoMapa<T> {
    private int chave;
    private T dado;

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NoMapa<?> other = (NoMapa<?>) obj;
        if (this.chave != other.chave) {
            return false;
        }
        return true;
    }
    
    
}


public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);

        if (estaVazia()) {
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> pai = null;
            NoArvoreBinaria<T> p = getRaiz();

            while (true) {
                pai = p;

                if (info.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();

                    if (p == null) {
                        pai.setEsquerda(novo);
                        break;
                    }
                } else {
                    p = pai.getDireita();

                    if (p == null) {
                        pai.setDireita(novo);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T valor) {
        if (no == null) {
            return null;
        }

        if (valor.equals(no.getInfo())) {
            return no;
        } else {
            if (valor.compareTo(no.getInfo()) < 0) {
                return buscar(no.getEsquerda(), valor);
            } else {
                return buscar(no.getDireita(), valor);
            }
        }
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        while ((p != null) && (!p.getInfo().equals(info))) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }

        }

        if (p != null) {
            if ((p.getEsquerda() == null) && p.getDireita() == null) {
                if (p.equals(getRaiz())) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            } else if (p.getDireita() == null) {
                if (p.equals(getRaiz())) {
                    setRaiz(p.getEsquerda());
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(p.getEsquerda());
                    } else {
                        pai.setDireita(p.getEsquerda());
                    }
                }
            } else if (p.getEsquerda() == null) {
                if (p.equals(getRaiz())) {
                    setRaiz(p.getDireita());
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(p.getDireita());
                    } else {
                        pai.setDireita(p.getDireita());
                    }
                }
            } else {
                NoArvoreBinaria<T> sucessor = extrairSucessor(p);

                if (p.equals(getRaiz())) {
                    setRaiz(sucessor);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(sucessor);
                    } else {
                        pai.setDireita(sucessor);
                    }
                }

                sucessor.setEsquerda(p.getEsquerda());
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir) {
        NoArvoreBinaria<T> p = excluir.getDireita();
        NoArvoreBinaria<T> paiSucessor = excluir;
        NoArvoreBinaria<T> sucessor = excluir;

        while (p != null) {
            paiSucessor = sucessor;
            sucessor = p;
            p = p.getEsquerda();
        }

        if (!sucessor.equals(excluir.getDireita())) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }

        return sucessor;
    }
}

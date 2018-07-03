package mapa;

import listaEncadeada.ListaEncadeada;
import listaEncadeada.NoLista;

/**
 *
 * @author Carlos Henrique Ponciano da Silva
 */
public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] dados;

    public MapaDispersao(int tamanho) {
        this.dados = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        return chave % dados.length;
    }

    public void inserir(int chave, T dado) {
        int local = calcularHash(chave);

        if (this.dados[local] == null) {
            this.dados[local] = new ListaEncadeada<>();
        }

        NoMapa no = new NoMapa();
        no.setChave(chave);
        no.setDado(dado);

        this.dados[local].inserir(no);
    }

    public void retirar(int chave) {
        int local = calcularHash(chave);

        if (this.dados[local] == null) {
            return;
        }

        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);

        this.dados[local].retirar(no);
    }

    public T buscar(int chave) {
        int local = calcularHash(chave);
        if (this.dados[local] != null) {
            NoMapa<T> auxMapa = new NoMapa();
            auxMapa.setChave(chave);

            NoLista<NoMapa<T>> auxLista = this.dados[local].buscar(auxMapa);

            if (auxLista != null) {
                return auxLista.getInfo().getDado();
            }
        }
        return null;
    }

    public int calcularQtdObjetos() {
        int qtdObjetos = 0;
        for (int i = 0; i < this.dados.length; i++) {
            if (this.dados[i] != null) {
                qtdObjetos += this.dados[i].obterComprimento();
            }
        }
        return qtdObjetos;
    }

    public void realocarMapa(int tamanho) {
        ListaEncadeada<NoMapa<T>>[] aux = new ListaEncadeada[tamanho];
        NoLista<NoMapa<T>> no;
        int posicaoRealocada;

        for (int i = 0; i < this.dados.length; i++) {
            if (this.dados[i] != null) {
                no = this.dados[i].getPrimeiro();
                while (no != null) {
                    posicaoRealocada = no.getInfo().getChave() % tamanho;
                    if (aux[posicaoRealocada] == null) {
                        aux[posicaoRealocada] = new ListaEncadeada<>();
                    }
                    aux[posicaoRealocada].inserir(no.getInfo());
                    no = no.getProximo();
                }
            }
        }
        this.dados = aux;
    }

    private int calcularProximoPrimo() {
        int tamanho = this.dados.length;
        int contador, meio;
        boolean ehPrimo;
        do{
            tamanho++;
            ehPrimo = true;
            meio = (int)(tamanho/2);
            for (contador = 2; contador < meio; contador++) {
                if(tamanho % contador == 0){
                    ehPrimo = false;
                }
            }
            
        }while(!ehPrimo);
        
        return tamanho;
    }
    
    public ListaEncadeada<T> converterTabelaParaLista() {
        ListaEncadeada<T> list = new ListaEncadeada<>();
        NoLista<NoMapa<T>> no;
        for (int i = 0; i < this.dados.length; i++) {
            if (dados[i] != null) {
                no = dados[i].getPrimeiro();
                while (no != null) {
                    list.inserir(no.getInfo().getDado());
                    no = no.getProximo();
                }
            }
        }
        return list;
    }

    public double getFatorCarga() {
        return ((Integer) this.calcularQtdObjetos()).doubleValue() / this.dados.length;
    }

    public static void main(String[] args) {
        MapaDispersao<Integer> mapa = new MapaDispersao<>(13);
        mapa.inserir(123, 5);
        mapa.inserir(658, 15);
        mapa.inserir(98, 4);
        mapa.inserir(6548, 123);
        mapa.inserir(1, 98);
        mapa.inserir(9875, 7);
        System.out.println(mapa.calcularQtdObjetos());
        mapa.retirar(6548);
        System.out.println(mapa.calcularQtdObjetos());
        System.out.println(mapa.calcularProximoPrimo());
    }
}

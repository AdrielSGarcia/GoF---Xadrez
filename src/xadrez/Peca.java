package xadrez;

public abstract class Peca {

    private Cor cor;
    private Posicao posicao;
    private MovimentoStrategy estrategia;

    public Peca(Cor cor, Posicao posicao, MovimentoStrategy estrategia) {
        this.cor = cor;
        this.posicao = posicao;
        this.estrategia = estrategia;
    }

    public Cor getCor() {
        return cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public boolean movimentoValido(Posicao destino) {
        return estrategia.valido(this, destino);
    }

    public abstract String getSimbolo();
}
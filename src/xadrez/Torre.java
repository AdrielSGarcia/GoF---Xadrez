package xadrez;

public class Torre extends Peca {

    public Torre(Cor cor, Posicao posicao) {
        super(cor, posicao, new MovimentoRetoStrategy());
    }

    @Override
    public String getSimbolo() {
        return getCor() == Cor.BRANCA ? "T" : "t";
    }
}
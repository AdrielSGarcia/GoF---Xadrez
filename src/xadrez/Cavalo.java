package xadrez;

public class Cavalo extends Peca {

    public Cavalo(Cor cor, Posicao posicao) {
        super(cor, posicao, new MovimentoCavaloStrategy());
    }

    @Override
    public String getSimbolo() {
        return getCor() == Cor.BRANCA ? "C" : "c";
    }
}
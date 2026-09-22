package xadrez;

public class Bispo extends Peca {

    public Bispo(Cor cor, Posicao posicao) {
        super(cor, posicao, new MovimentoDiagonalStrategy());
    }

    @Override
    public String getSimbolo() {
        return getCor() == Cor.BRANCA ? "B" : "b";
    }
}
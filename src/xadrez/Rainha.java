package xadrez;

public class Rainha extends Peca {

    public Rainha(Cor cor, Posicao posicao) {
        super(cor, posicao, new MovimentoRainhaStrategy());
    }

    @Override
    public String getSimbolo() {
        return getCor() == Cor.BRANCA ? "Q" : "q";
    }
}
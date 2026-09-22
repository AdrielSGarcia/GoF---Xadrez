package xadrez;

public class Peao extends Peca {

    public Peao(Cor cor, Posicao posicao) {
        super(cor, posicao, new MovimentoPeaoStrategy());
    }

    @Override
    public String getSimbolo() {
        return getCor() == Cor.BRANCA ? "P" : "p";
    }
}
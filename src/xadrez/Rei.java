package xadrez;

public class Rei extends Peca {

    public Rei(Cor cor, Posicao posicao) {
        super(cor, posicao, new MovimentoReiStrategy());
    }

    @Override
    public String getSimbolo() {
        return getCor() == Cor.BRANCA ? "R" : "r";
    }
}
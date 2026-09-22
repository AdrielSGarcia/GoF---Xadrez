package xadrez;

public class MovimentoRetoStrategy implements MovimentoStrategy {

    @Override
    public boolean valido(Peca peca, Posicao destino) {
        Posicao origem = peca.getPosicao();
        return destino != null
            && destino.dentroDoTabuleiro()
            && (origem.getLinha() == destino.getLinha()
            || origem.getColuna() == destino.getColuna())
            && (origem.getLinha() != destino.getLinha()
            || origem.getColuna() != destino.getColuna());
    }
}

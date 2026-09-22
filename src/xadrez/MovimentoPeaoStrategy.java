package xadrez;

public class MovimentoPeaoStrategy implements MovimentoStrategy {

    @Override
    public boolean valido(Peca peca, Posicao destino) {
        if (destino == null || !destino.dentroDoTabuleiro()) {
            return false;
        }

        Posicao origem = peca.getPosicao();
        int direcao = peca.getCor() == Cor.BRANCA ? 1 : -1;
        int deltaLinha = destino.getLinha() - origem.getLinha();
        int deltaColuna = Math.abs(destino.getColuna() - origem.getColuna());

        if (deltaColuna == 0 && deltaLinha == direcao) {
            return true;
        }

        if (deltaColuna == 0 && deltaLinha == 2 * direcao) {
            int linhaInicial = peca.getCor() == Cor.BRANCA ? 1 : 6;
            return origem.getLinha() == linhaInicial;
        }

        return deltaColuna == 1 && deltaLinha == direcao;
    }
}

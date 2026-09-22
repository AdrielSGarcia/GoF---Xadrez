package xadrez;

public class MovimentoReiStrategy implements MovimentoStrategy {

    @Override
    public boolean valido(Peca peca, Posicao destino) {
        if (destino == null || !destino.dentroDoTabuleiro()) {
            return false;
        }

        Posicao origem = peca.getPosicao();
        int linhas = Math.abs(origem.getLinha() - destino.getLinha());
        int colunas = Math.abs(origem.getColuna() - destino.getColuna());
        return linhas <= 1 && colunas <= 1 && (linhas != 0 || colunas != 0);
    }
}

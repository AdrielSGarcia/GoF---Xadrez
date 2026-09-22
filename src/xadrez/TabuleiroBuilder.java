package xadrez;

public class TabuleiroBuilder {

    private Tabuleiro tabuleiro;

    public TabuleiroBuilder() {
        tabuleiro = new Tabuleiro();
    }

    public TabuleiroBuilder comPecasIniciais() {
        adicionarLinhaBranca();
        adicionarPeoes(Cor.BRANCA, 1);
        adicionarLinhaPreta();
        adicionarPeoes(Cor.PRETA, 6);
        return this;
    }

    public Tabuleiro construir() {
        return tabuleiro;
    }

    private void adicionarLinhaBranca() {
        tabuleiro.colocarPeca(new Torre(Cor.BRANCA, new Posicao(0, 0)));
        tabuleiro.colocarPeca(new Cavalo(Cor.BRANCA, new Posicao(0, 1)));
        tabuleiro.colocarPeca(new Bispo(Cor.BRANCA, new Posicao(0, 2)));
        tabuleiro.colocarPeca(new Rainha(Cor.BRANCA, new Posicao(0, 3)));
        tabuleiro.colocarPeca(new Rei(Cor.BRANCA, new Posicao(0, 4)));
        tabuleiro.colocarPeca(new Bispo(Cor.BRANCA, new Posicao(0, 5)));
        tabuleiro.colocarPeca(new Cavalo(Cor.BRANCA, new Posicao(0, 6)));
        tabuleiro.colocarPeca(new Torre(Cor.BRANCA, new Posicao(0, 7)));
    }

    private void adicionarLinhaPreta() {
        tabuleiro.colocarPeca(new Torre(Cor.PRETA, new Posicao(7, 0)));
        tabuleiro.colocarPeca(new Cavalo(Cor.PRETA, new Posicao(7, 1)));
        tabuleiro.colocarPeca(new Bispo(Cor.PRETA, new Posicao(7, 2)));
        tabuleiro.colocarPeca(new Rainha(Cor.PRETA, new Posicao(7, 3)));
        tabuleiro.colocarPeca(new Rei(Cor.PRETA, new Posicao(7, 4)));
        tabuleiro.colocarPeca(new Bispo(Cor.PRETA, new Posicao(7, 5)));
        tabuleiro.colocarPeca(new Cavalo(Cor.PRETA, new Posicao(7, 6)));
        tabuleiro.colocarPeca(new Torre(Cor.PRETA, new Posicao(7, 7)));
    }

    private void adicionarPeoes(Cor cor, int linha) {
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro.colocarPeca(new Peao(cor, new Posicao(linha, coluna)));
        }
    }
}

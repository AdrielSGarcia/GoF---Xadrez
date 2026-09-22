package xadrez;

public class Posicao {

    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean dentroDoTabuleiro() {
        return linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8;
    }

    @Override
    public String toString() {
        char colunaLetra = (char) ('A' + coluna);
        return "" + colunaLetra + (linha + 1);
    }
}
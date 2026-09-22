package xadrez;

public class Tabuleiro {

    private Peca[][] casas;

    public Tabuleiro() {
        casas = new Peca[8][8];
    }

    public boolean posicaoValida(Posicao posicao) {
        return posicao != null && posicao.dentroDoTabuleiro();
    }

    public void colocarPeca(Peca peca) {
        if (peca == null) {
            return;
        }

        Posicao posicao = peca.getPosicao();

        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição inválida para peça: " + posicao);
        }

        casas[posicao.getLinha()][posicao.getColuna()] = peca;
    }

    public Peca getPeca(Posicao posicao) {
        if (!posicaoValida(posicao)) {
            return null;
        }

        return casas[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean caminhoLivre(Posicao origem, Posicao destino) {
        if (!posicaoValida(origem) || !posicaoValida(destino)) {
            return false;
        }

        int deltaLinha = Integer.compare(destino.getLinha(), origem.getLinha());
        int deltaColuna = Integer.compare(destino.getColuna(), origem.getColuna());

        int linhaAtual = origem.getLinha() + deltaLinha;
        int colunaAtual = origem.getColuna() + deltaColuna;

        while (linhaAtual != destino.getLinha() || colunaAtual != destino.getColuna()) {
            if (casas[linhaAtual][colunaAtual] != null) {
                return false;
            }
            linhaAtual += deltaLinha;
            colunaAtual += deltaColuna;
        }

        return true;
    }

    public boolean movimentoPossivel(Peca peca, Posicao origem, Posicao destino) {
        if (peca == null || !posicaoValida(origem) || !posicaoValida(destino)) {
            return false;
        }

        if (!peca.movimentoValido(destino)) {
            return false;
        }

        Peca pecaDestino = getPeca(destino);
        if (pecaDestino != null && pecaDestino.getCor() == peca.getCor()) {
            return false;
        }

        if (peca instanceof Torre || peca instanceof Bispo || peca instanceof Rainha) {
            return caminhoLivre(origem, destino);
        }

        return true;
    }

    public Posicao localizarRei(Cor cor) {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = casas[linha][coluna];
                if (peca instanceof Rei && peca.getCor() == cor) {
                    return new Posicao(linha, coluna);
                }
            }
        }
        return null;
    }

    public boolean posicaoAtacadaPor(Posicao alvo, Cor atacante) {
        if (alvo == null || !posicaoValida(alvo)) {
            return false;
        }

        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = casas[linha][coluna];
                if (peca == null || peca.getCor() != atacante) {
                    continue;
                }

                Posicao origem = new Posicao(linha, coluna);

                if (peca instanceof Peao) {
                    int direcao = peca.getCor() == Cor.BRANCA ? 1 : -1;
                    int deltaLinha = alvo.getLinha() - linha;
                    int deltaColuna = Math.abs(alvo.getColuna() - coluna);

                    if (deltaLinha == direcao && deltaColuna == 1) {
                        return true;
                    }
                    continue;
                }

                if (!peca.movimentoValido(alvo)) {
                    continue;
                }

                if (peca instanceof Torre || peca instanceof Bispo || peca instanceof Rainha) {
                    if (!caminhoLivre(origem, alvo)) {
                        continue;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public boolean reiEmXeque(Cor cor) {
        Posicao rei = localizarRei(cor);
        if (rei == null) {
            return false;
        }

        Cor adversario = (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
        return posicaoAtacadaPor(rei, adversario);
    }

    public boolean movimentoLegal(Peca peca, Posicao origem, Posicao destino) {
        if (!movimentoPossivel(peca, origem, destino)) {
            return false;
        }

        Peca pecaCapturada = getPeca(destino);
        Cor corDaPeca = peca.getCor();

        casas[origem.getLinha()][origem.getColuna()] = null;
        casas[destino.getLinha()][destino.getColuna()] = peca;
        peca.setPosicao(destino);

        boolean legal = !reiEmXeque(corDaPeca);

        casas[origem.getLinha()][origem.getColuna()] = peca;
        casas[destino.getLinha()][destino.getColuna()] = pecaCapturada;
        peca.setPosicao(origem);

        return legal;
    }

    public void mover(Posicao origem, Posicao destino) {
        Peca peca = getPeca(origem);

        if (peca == null) {
            System.out.println("Não existe peça na posição " + origem);
            return;
        }

        if (!posicaoValida(destino)) {
            System.out.println("Destino inválido: " + destino);
            return;
        }

        if (!movimentoLegal(peca, origem, destino)) {
            System.out.println("Movimento inválido para " + peca.getClass().getSimpleName() + ". O rei ficaria em xeque.");
            return;
        }

        Peca pecaDestino = getPeca(destino);
        if (pecaDestino != null && pecaDestino.getCor() == peca.getCor()) {
            System.out.println("Já existe uma peça da mesma cor no destino.");
            return;
        }

        casas[origem.getLinha()][origem.getColuna()] = null;
        casas[destino.getLinha()][destino.getColuna()] = peca;
        peca.setPosicao(destino);

        System.out.println("Movimento realizado: " + origem + " -> " + destino);
    }

    public void executarMovimento(Posicao origem, Posicao destino) {
        Peca peca = getPeca(origem);
        casas[origem.getLinha()][origem.getColuna()] = null;
        casas[destino.getLinha()][destino.getColuna()] = peca;
        peca.setPosicao(destino);
    }

    public void restaurarCaptura(Posicao posicao, Peca peca) {
        casas[posicao.getLinha()][posicao.getColuna()] = peca;
        if (peca != null) {
            peca.setPosicao(posicao);
        }
    }

    public void imprimir() {
        System.out.println();

        for (int linha = 7; linha >= 0; linha--) {
            System.out.print((linha + 1) + " ");

            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = casas[linha][coluna];

                if (peca == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(peca.getSimbolo() + " ");
                }
            }

            System.out.println();
        }

        System.out.println("  A B C D E F G H");
        System.out.println();
    }
}
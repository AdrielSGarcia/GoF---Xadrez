package xadrez;

public class Partida {

    private Tabuleiro tabuleiro;
    private Cor jogadorAtual;
    private boolean xeque;
    private boolean xequeMate;

    public Partida() {
        this(new TabuleiroBuilder().comPecasIniciais().construir());
    }

    public Partida(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        jogadorAtual = Cor.BRANCA;
        xeque = false;
        xequeMate = false;
    }

    public void jogar(Posicao origem, Posicao destino) {
        Peca peca = tabuleiro.getPeca(origem);

        if (peca == null) {
            System.out.println("Não existe peça na posição " + origem);
            return;
        }

        if (peca.getCor() != jogadorAtual) {
            System.out.println("Não é a vez das peças de cor " + jogadorAtual + ".");
            return;
        }

        if (!tabuleiro.movimentoLegal(peca, origem, destino)) {
            System.out.println("Movimento inválido para " + peca.getClass().getSimpleName() + ".");
            return;
        }

        tabuleiro.mover(origem, destino);

        Cor proximoJogador = (jogadorAtual == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
        xeque = tabuleiro.reiEmXeque(proximoJogador);

        if (xeque) {
            System.out.println("Xeque em " + proximoJogador + ".");
        }

        jogadorAtual = proximoJogador;
        tabuleiro.imprimir();
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
    }

    public void mostrarTabuleiro() {
        tabuleiro.imprimir();
    }
}
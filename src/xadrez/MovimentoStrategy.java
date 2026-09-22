package xadrez;

public interface MovimentoStrategy {
    boolean valido(Peca peca, Posicao destino);
}

package xadrez;

public class JogoFacade {

    private Partida partida;

    public JogoFacade() {
        partida = new Partida();
    }

    public void mostrarTabuleiro() {
        partida.mostrarTabuleiro();
    }

    public Partida getPartida() {
        return partida;
    }

    public void jogar(String origem, String destino) {
        partida.jogar(converter(origem), converter(destino));
    }

    private Posicao converter(String casa) {
        if (casa == null || casa.length() != 2) {
            throw new IllegalArgumentException("Casa inválida: " + casa);
        }

        int coluna = Character.toUpperCase(casa.charAt(0)) - 'A';
        int linha = casa.charAt(1) - '1';
        Posicao posicao = new Posicao(linha, coluna);

        if (!posicao.dentroDoTabuleiro()) {
            throw new IllegalArgumentException("Casa inválida: " + casa);
        }
        return posicao;
    }
}

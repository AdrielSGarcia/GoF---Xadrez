package xadrez;

public class Main {

    public static void main(String[] args) {
        JogoFacade jogo = new JogoFacade();

        System.out.println("Simulacao de partida em xadrez");
        System.out.println("Formato das jogadas: E2 E4 | G1 F3 | E7 E5");
        System.out.println();

        jogo.mostrarTabuleiro();

        String[] jogadas = {
            "E2 E4",
            "E7 E5",
            "G1 F3",
            "B8 C6",
            "F1 C4",
            "G8 F6",
            "E1 G1"
        };

        for (String jogada : jogadas) {
            String[] casas = jogada.split(" ");

            System.out.println("Jogada: " + jogada);
            jogo.jogar(casas[0], casas[1]);
        }

    }
}
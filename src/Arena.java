import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1 = new Carta[2][5];
    private Carta[][] campoJogador2 = new Carta[2][5];
    private int pontosVidaJogador1 = 20;
    private int pontosVidaJogador2 = 20;
    private Carta[] maoJogador1 = new Carta[10];
    private Carta[] maoJogador2 = new Carta[10];
    private int manaMaximaJogador1 = 0;
    private int manaMaximaJogador2 = 0;
    private Carta[] cemiterioJogador1 = new Carta[100];
    private Carta[] cemiterioJogador2 = new Carta[100];

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Deck deckJogador2, Carta[][] campoJogador1,
            Carta[][] campoJogador2, int pontosVidaJogador1, int pontosVidaJogador2, Carta[] maoJogador1,
            Carta[] maoJogador2, int manaMaximaJogador1, int manaMaximaJogador2, Carta[] cemiterioJogador1,
            Carta[] cemiterioJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = campoJogador1;
        this.campoJogador2 = campoJogador2;
        this.pontosVidaJogador1 = pontosVidaJogador1;
        this.pontosVidaJogador2 = pontosVidaJogador2;
        this.maoJogador1 = maoJogador1;
        this.maoJogador2 = maoJogador2;
        this.manaMaximaJogador1 = manaMaximaJogador1;
        this.manaMaximaJogador2 = manaMaximaJogador2;
        this.cemiterioJogador1 = cemiterioJogador1;
        this.cemiterioJogador2 = cemiterioJogador2;
    }

    public Arena(Usuario jogador1, Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }


    public void comecoDeJogo() {
        System.out.println("Começando o Card Game!");
        System.out.println("Os jogadores têm 20 pontos de vida cada.");
        System.out.println("Iniciando o jogo...");
        inicio();
    }

    public void inicio() {
        Random rand = new Random();
        int num = rand.nextInt(2);
        Usuario jogadorAtual = (num == 0) ? jogador1 : jogador2;

        while (pontosVidaJogador1 > 0 && pontosVidaJogador2 > 0) {
            System.out.println("\nÉ a vez de " + jogadorAtual.getUser() + "!");

            saque(jogadorAtual);
            compra(jogadorAtual);
            posicionamento(jogadorAtual);
            ataque(jogadorAtual, (jogadorAtual == jogador1) ? jogador2 : jogador1);

            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }

        finalDoJogo();
    }

    public void saque(Usuario jogador) {
        System.out.println(jogador.getUser() + " está sacando cartas...");
        // Implemente o saque de cartas aleatórias aqui

        // Mostrar as cartas sacadas ao jogador

        // Permita que o jogador devolva até 5 cartas, se desejar
    }

    public void compra(Usuario jogador) {
        System.out.println(jogador.getUser() + " está comprando uma carta...");
        // Compre uma carta do deck do jogador

        // Atualize a mana máxima do jogador

        // Mostre a carta comprada ao jogador
    }

    public void posicionamento(Usuario jogador) {
        System.out.println(jogador.getUser() + " está posicionando uma carta no campo...");
        // Implemente a lógica para posicionar uma carta no campo ou uma mana

        // Reduza a mana máxima do jogador, se uma carta for posicionada

        // Atualize o campo do jogador
    }

    public void ataque(Usuario jogador1, Usuario jogador2) {
        System.out.println(jogador1.getUser() + " está atacando " + jogador2.getUser() + "...");
        // Implemente a lógica para o ataque entre as cartas nos campos dos jogadores

        // Atualize os pontos de vida com base nos resultados dos ataques

        // Mostre o resultado do ataque
    }

    public void finalDoJogo() {
        if (pontosVidaJogador1 <= 0 && pontosVidaJogador2 <= 0) {
            System.out.println("O jogo terminou em empate.");
        } else if (pontosVidaJogador1 <= 0) {
            System.out.println(jogador2.getUser() + " é o vencedor!");
        } else if (pontosVidaJogador2 <= 0) {
            System.out.println(jogador1.getUser() + " é o vencedor!");
        }
    }
}

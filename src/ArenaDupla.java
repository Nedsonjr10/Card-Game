import java.util.Random;

public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Carta[] aliadoJogador3;
    private Carta[] aliadoJogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4,
            Deck deckJogador1, Deck deckJogador2, Carta[][] campoJogador1, Carta[][] campoJogador2,
            int pontosVidaJogador1, int pontosVidaJogador2, Carta[] maoJogador1, Carta[] maoJogador2,
            int manaMaximaJogador1, int manaMaximaJogador2, Carta[] cemiterioJogador1,
            Carta[] cemiterioJogador2) {
        super(jogador1, jogador2, deckJogador1, deckJogador2, campoJogador1, campoJogador2, pontosVidaJogador1,
                pontosVidaJogador2, maoJogador1, maoJogador2, manaMaximaJogador1, manaMaximaJogador2,
                cemiterioJogador1, cemiterioJogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.aliadoJogador3 = new Carta[10];
        this.aliadoJogador4 = new Carta[10];
    }

    @Override
    public void saque(Usuario jogador) {
        System.out.println(jogador.getUser() + " está sacando cartas...");

        Carta[] inventario = (jogador == getJogador1()) ? getMaoJogador1() : (jogador == getJogador2()) ? getMaoJogador2() :
                            (jogador == jogador3) ? aliadoJogador3 : aliadoJogador4;

        if (inventario != null) {
            Random rand = new Random();
            int indiceCartaSaque = rand.nextInt(inventario.length);

            Carta cartaSaque = inventario[indiceCartaSaque];

            adicionarCartaNaMao(jogador, cartaSaque);

            inventario[indiceCartaSaque] = null;

            System.out.println(jogador.getUser() + " sacou a carta: " + cartaSaque.getNome());
        } else {
            System.out.println(jogador.getUser() + " não possui mais cartas no inventário.");
        }
    }
    @Override
    public void inicio() {
        Random rand = new Random();
        int num = rand.nextInt(4);
        Usuario jogadorAtual = (num == 0) ? getJogador1() : (num == 1) ? getJogador2() : (num == 2) ? jogador3 : jogador4;

        while (getPontosVidaJogador1() > 0 && getPontosVidaJogador2() > 0) {
            System.out.println("\nÉ a vez de " + jogadorAtual.getUser() + "!");

            saque(jogadorAtual);
            compra(jogadorAtual);
            posicionamento(jogadorAtual);
            ataque(jogadorAtual, (jogadorAtual == getJogador1()) ? getJogador2()
                    : (jogadorAtual == getJogador2()) ? getJogador1() : (jogadorAtual == jogador3) ? jogador4 : jogador3);

            jogadorAtual = (jogadorAtual == getJogador1()) ? getJogador2()
                    : (jogadorAtual == getJogador2()) ? getJogador1() : (jogadorAtual == jogador3) ? jogador4 : jogador3;
        }

        finalDoJogo();
    }

    public void turno(Usuario jogador, Carta[] aliado, Carta[][] inimigo) {
        System.out.println("É o turno de " + jogador.getUser());

        compra(jogador);
        posicionamento(jogador);
        ataque(jogador, aliado, inimigo);
    }

    public void ataque(Usuario jogadorAtacante, Carta[] aliado, Carta[][] inimigo) {
        System.out.println(jogadorAtacante.getUser() + " está atacando...");

        Carta[][] campoAtacante = (jogadorAtacante == getJogador1()) ? getCampoJogador1()
                : (jogadorAtacante == getJogador2()) ? getCampoJogador2()
                        : (jogadorAtacante == jogador3) ? getCampoJogador1() : getCampoJogador2();

        for (int linha = 0; linha < campoAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoAtacante[linha].length; coluna++) {
                Carta cartaAtacante = campoAtacante[linha][coluna];

                if (cartaAtacante != null) {
                    if (aliado != null) {
                        // Adicione as cartas aliadas ao vetor de ataque
                        aliado = adicionarCartasAoAtaque(aliado, cartaAtacante);
                    }

                    for (int i = 0; i < inimigo.length; i++) {
                        for (int j = 0; j < inimigo[i].length; j++) {
                            Carta cartaDefensor = inimigo[i][j];

                            if (cartaDefensor != null) {
                                double ataqueAtacante = cartaAtacante.getAtaque();
                                double defesaDefensor = cartaDefensor.getDefesa();

                                if (ataqueAtacante > defesaDefensor) {
                                    System.out.println(cartaAtacante.getNome() + " ataca " + cartaDefensor.getNome());
                                    System.out.println(cartaAtacante.getNome() + " inflige "
                                            + (ataqueAtacante - defesaDefensor) + " de dano!");

                                    int dano = (int) (ataqueAtacante - defesaDefensor);
                                    int pontosVidaDefensor = (jogadorAtacante == getJogador1()) ? getPontosVidaJogador1()
                                            : (jogadorAtacante == getJogador2()) ? getPontosVidaJogador2()
                                                    : (jogadorAtacante == jogador3) ? getPontosVidaJogador1()
                                                            : getPontosVidaJogador2();

                                    pontosVidaDefensor -= dano;

                                    if (jogadorAtacante == getJogador1()) {
                                        setPontosVidaJogador1(pontosVidaDefensor);
                                    } else if (jogadorAtacante == getJogador2()) {
                                        setPontosVidaJogador2(pontosVidaDefensor);
                                    } else if (jogadorAtacante == jogador3) {
                                        setPontosVidaJogador1(pontosVidaDefensor);
                                    } else {
                                        setPontosVidaJogador2(pontosVidaDefensor);
                                    }

                                    System.out.println("Pontos de vida do defensor: " + pontosVidaDefensor);
                                } else {
                                    System.out.println(cartaAtacante.getNome() + " ataca " + cartaDefensor.getNome());
                                    System.out.println(cartaDefensor.getNome() + " bloqueia o ataque!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Carta[] adicionarCartasAoAtaque(Carta[] aliado, Carta carta) {
        for (int i = 0; i < aliado.length; i++) {
            if (aliado[i] == null) {
                aliado[i] = carta;
                break;
            }
        }
        return aliado;
    }
}

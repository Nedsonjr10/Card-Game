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

    

    public Usuario getJogador1() {
        return jogador1;
    }

    public void setJogador1(Usuario jogador1) {
        this.jogador1 = jogador1;
    }

    public Usuario getJogador2() {
        return jogador2;
    }

    public void setJogador2(Usuario jogador2) {
        this.jogador2 = jogador2;
    }

    public Deck getDeckJogador1() {
        return deckJogador1;
    }

    public void setDeckJogador1(Deck deckJogador1) {
        this.deckJogador1 = deckJogador1;
    }

    public Deck getDeckJogador2() {
        return deckJogador2;
    }

    public void setDeckJogador2(Deck deckJogador2) {
        this.deckJogador2 = deckJogador2;
    }

    public Carta[][] getCampoJogador1() {
        return campoJogador1;
    }

    public void setCampoJogador1(Carta[][] campoJogador1) {
        this.campoJogador1 = campoJogador1;
    }

    public Carta[][] getCampoJogador2() {
        return campoJogador2;
    }

    public void setCampoJogador2(Carta[][] campoJogador2) {
        this.campoJogador2 = campoJogador2;
    }

    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }

    public void setPontosVidaJogador1(int pontosVidaJogador1) {
        this.pontosVidaJogador1 = pontosVidaJogador1;
    }

    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }

    public void setPontosVidaJogador2(int pontosVidaJogador2) {
        this.pontosVidaJogador2 = pontosVidaJogador2;
    }

    public Carta[] getMaoJogador1() {
        return maoJogador1;
    }

    public void setMaoJogador1(Carta[] maoJogador1) {
        this.maoJogador1 = maoJogador1;
    }

    public Carta[] getMaoJogador2() {
        return maoJogador2;
    }

    public void setMaoJogador2(Carta[] maoJogador2) {
        this.maoJogador2 = maoJogador2;
    }

    public int getManaMaximaJogador1() {
        return manaMaximaJogador1;
    }

    public void setManaMaximaJogador1(int manaMaximaJogador1) {
        this.manaMaximaJogador1 = manaMaximaJogador1;
    }

    public int getManaMaximaJogador2() {
        return manaMaximaJogador2;
    }

    public void setManaMaximaJogador2(int manaMaximaJogador2) {
        this.manaMaximaJogador2 = manaMaximaJogador2;
    }

    public Carta[] getCemiterioJogador1() {
        return cemiterioJogador1;
    }

    public void setCemiterioJogador1(Carta[] cemiterioJogador1) {
        this.cemiterioJogador1 = cemiterioJogador1;
    }

    public Carta[] getCemiterioJogador2() {
        return cemiterioJogador2;
    }

    public void setCemiterioJogador2(Carta[] cemiterioJogador2) {
        this.cemiterioJogador2 = cemiterioJogador2;
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

    public void turno(Usuario jogador) {
        System.out.println("É o turno de " + jogador.getUser());
    
        compra(jogador);
        posicionamento(jogador);
        ataque(jogador, (jogador == jogador1) ? jogador2 : jogador1);
    }

    public void compra(Usuario jogador) {
        System.out.println(jogador.getUser() + " está comprando uma carta...");
    
        Deck deckJogador = (jogador == jogador1) ? deckJogador1 : deckJogador2;
    
        if (deckJogador.getQuantidadeDeCartas() > 0) {
            // Gere um índice aleatório para escolher uma carta do deck
            Random rand = new Random();
            int cartaIndex = rand.nextInt(deckJogador.getQuantidadeDeCartas());
            Carta cartaComprada = deckJogador.getCartas_no_deck()[cartaIndex];
    
            // Mostre a carta comprada ao jogador
            System.out.println(jogador.getUser() + " comprou a carta: " + cartaComprada.getNome());
    
            // Remova a carta comprada do deck
            deckJogador.setQuantidadeDeCartas(deckJogador.getQuantidadeDeCartas() - 1);
    
            // Atualize a mana máxima do jogador
            if (jogador == jogador1) {
                manaMaximaJogador1++;
            } else if (jogador == jogador2) {
                manaMaximaJogador2++;
            }
        } else {
            System.out.println(jogador.getUser() + " não tem mais cartas no deck.");
        }
    }
    
    
    
    public void posicionamento(Usuario jogador) {
        System.out.println(jogador.getUser() + " está posicionando uma carta no campo...");
        Deck deckJogador = (jogador == jogador1) ? deckJogador1 : deckJogador2;
        Carta[][] campoJogador = (jogador == jogador1) ? campoJogador1 : campoJogador2;
        int manaMaximaJogador = (jogador == jogador1) ? manaMaximaJogador1 : manaMaximaJogador2;
    
        if (manaMaximaJogador > 0) {
            // O jogador tem mana para posicionar uma carta
            Carta cartaPosicionada = null;
    
            // Tente encontrar uma carta no inventário do jogador para posicionar
            for (int i = 0; i < jogador.getInventario().length; i++) {
                if (jogador.getInventario()[i] != null) {
                    cartaPosicionada = jogador.getInventario()[i];
                    jogador.getInventario()[i] = null; // Remova a carta do inventário
                    break;
                }
            }
    
            if (cartaPosicionada != null) {
                // Posicione a carta no campo
                for (int i = 0; i < campoJogador[1].length; i++) {
                    if (campoJogador[1][i] == null) {
                        campoJogador[1][i] = cartaPosicionada;
                        System.out.println(jogador.getUser() + " posicionou a carta: " + cartaPosicionada.getNome());
                        manaMaximaJogador--; // Reduza a mana máxima
    
                        if (jogador == jogador1) {
                            manaMaximaJogador1 = manaMaximaJogador;
                        } else {
                            manaMaximaJogador2 = manaMaximaJogador;
                        }
                        break;
                    }
                }
            } else {
                System.out.println(jogador.getUser() + " não tem cartas para posicionar.");
            }
        } else {
            System.out.println(jogador.getUser() + " não tem mana suficiente para posicionar uma carta.");
        }
    }
    

    public void ataque(Usuario jogadorAtacante, Usuario jogadorDefensor) {
        System.out.println(jogadorAtacante.getUser() + " está atacando " + jogadorDefensor.getUser() + "...");
    
        // Obtenha os campos de batalha dos jogadores
        Carta[][] campoAtacante = (jogadorAtacante == jogador1) ? campoJogador1 : campoJogador2;
        Carta[][] campoDefensor = (jogadorAtacante == jogador1) ? campoJogador2 : campoJogador1;
    
        // Percorra as cartas no campo de ataque
        for (int linha = 0; linha < campoAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoAtacante[linha].length; coluna++) {
                Carta cartaAtacante = campoAtacante[linha][coluna];
    
                if (cartaAtacante != null) {
                    // Verifique se a posição correspondente no campo defensor tem uma carta
                    Carta cartaDefensor = campoDefensor[linha][coluna];
    
                    if (cartaDefensor != null) {
                        // Compare os valores de ataque e defesa
                        double ataqueAtacante = cartaAtacante.getAtaque();
                        double defesaDefensor = cartaDefensor.getDefesa();
    
                        if (ataqueAtacante > defesaDefensor) {
                            // O atacante vence o combate
                            System.out.println(cartaAtacante.getNome() + " ataca " + cartaDefensor.getNome());
                            System.out.println(cartaAtacante.getNome() + " inflige " + (ataqueAtacante - defesaDefensor) + " de dano!");
    
                            // Reduza os pontos de vida do jogador defensor
                            int dano = (int) (ataqueAtacante - defesaDefensor);
                            int pontosVidaDefensor = (jogadorDefensor == jogador1) ? pontosVidaJogador1 : pontosVidaJogador2;
                            pontosVidaDefensor -= dano;
    
                            if (jogadorDefensor == jogador1) {
                                pontosVidaJogador1 = pontosVidaDefensor;
                            } else {
                                pontosVidaJogador2 = pontosVidaDefensor;
                            }
                            System.out.println(jogadorDefensor.getUser() + " tem agora " + pontosVidaDefensor + " pontos de vida.");
                        } else {
                            // O defensor vence o combate
                            System.out.println(cartaAtacante.getNome() + " ataca " + cartaDefensor.getNome());
                            System.out.println(cartaDefensor.getNome() + " bloqueia o ataque!");
                        }
                    }
                }
            }
        }
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

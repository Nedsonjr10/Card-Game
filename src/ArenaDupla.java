public class ArenaDupla extends Arena {
    private Usuario player3;
    private Usuario player4;

    public ArenaDupla( Usuario player1,  Usuario player2,  Usuario player3,  Usuario player4) {
        super(player1, player2);
        this.player3 = player3;
        this.player4 = player4;
    }

    @Override
    public void saqueEInicio() {
        super.saqueEInicio();
        player3.saqueEInicio();
        player4.saqueEInicio();
    }

    public void turno( Usuario player, List<Ataque> aliado) {
        List<Jogador> inimigos = new ArrayList<>();

        if (player == player1) {
            inimigos.add(player2);
            inimigos.add(player3);
            inimigos.add(player4);
        } else if (player == player2) {
            inimigos.add(player1);
            inimigos.add(player3);
            inimigos.add(player4);
        } else if (player == player3) {
            inimigos.add(player1);
            inimigos.add(player2);
            inimigos.add(player4);
        } else if (player == player4) {
            inimigos.add(player1);
            inimigos.add(player2);
            inimigos.add(player3);
        }

        // Concatena o vetor aliado ao vetor de ataque do jogador
        if (aliado != null) {
            player.getAtaque().addAll(aliado);
        }

        // Implemente a lógica do turno com base no jogador e inimigos
        for (Jogador inimigo : inimigos) {
            int danoCausado = player.calcularDano(); // Lógica de cálculo de dano
            inimigo.sofrerDano(danoCausado); // Lógica para causar dano ao inimigo
        }

        // Atualize a lógica para os pontos de vida compartilhados, se aplicável

        // Atualize outros aspectos do jogo conforme necessário
    }
}
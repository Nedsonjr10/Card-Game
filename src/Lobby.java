import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lobby {

    private List<Usuario> usu = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    

    public Lobby(List<Usuario> usu, List<Lobby.Team> teams) {
        this.usu = usu;
        this.teams = teams;
    }

    public List<Usuario> getUsu() {
        return usu;
    }

    public void addJogador(Usuario usuario) {
        usu.add(usuario);
    }

    public void buscarAdversario(Usuario usuario) throws TimeOutException, IrregularDeckException {
        boolean adversarioEncontrado = false;
        long startTime = System.currentTimeMillis();

        while (!adversarioEncontrado) {
            for (Usuario adversario : usu) {
                if (adversario != usuario && adversario.getNivel() == usuario.getNivel()
                        && adversario.getModalidade().equals(usuario.getModalidade())) {
                    System.out.println("Adversário encontrado, a partida em breve será iniciada.");
                    comecarJogo(adversario, usuario);
                    adversarioEncontrado = true;
                    break;
                }
            }

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            long timeOutThreshold = 30000; // 30 segundos

            if (elapsedTime > timeOutThreshold) {
                throw new TimeOutException("Tempo esgotado. Não foi possível encontrar um adversário.");
            }
        }
    }

    public void comecarJogo(Usuario jogador1, Usuario jogador2) {
        if (jogador1 != null && jogador2 != null) {
            if (jogador1.getDecks() != null && jogador2.getDecks() != null) {
                Arena arena = new Arena(jogador1, jogador2);
                arena.comecoDeJogo();
            }
        }
    }

    private boolean isDeckValido(Deck[] decks) {
    for (Deck deck : decks) {
        if (deck != null && deck.getQuantidadeDeCartas() > 0 && !temRepeticoes(deck)) {
            return true; // Deck é válido
        }
    }
    return false; // Nenhum deck válido foi encontrado
}

private boolean temRepeticoes(Deck deck) {
    Carta[] cartas = deck.getCartas_no_deck();
    for (int i = 0; i < deck.getQuantidadeDeCartas(); i++) {
        for (int j = i + 1; j < deck.getQuantidadeDeCartas(); j++) {
            if (cartas[i] != null && cartas[j] != null && cartas[i].equals(cartas[j])) {
                return true; // Encontrou repetição
            }
        }
    }
    return false; // Não há repetições
}


    public void adicionarModoDupla() {
        List<Usuario> usuariosDisponiveis = new ArrayList<>(usu);
        Random random = new Random();

        while (usuariosDisponiveis.size() >= 4) {
            int indiceTime1Jogador1 = random.nextInt(usuariosDisponiveis.size());
            Usuario jogador1Time1 = usuariosDisponiveis.remove(indiceTime1Jogador1);

            int indiceTime1Jogador2 = random.nextInt(usuariosDisponiveis.size());
            Usuario jogador2Time1 = usuariosDisponiveis.remove(indiceTime1Jogador2);

            int indiceTime2Jogador1 = random.nextInt(usuariosDisponiveis.size());
            Usuario jogador1Time2 = usuariosDisponiveis.remove(indiceTime2Jogador1);

            int indiceTime2Jogador2 = random.nextInt(usuariosDisponiveis.size());
            Usuario jogador2Time2 = usuariosDisponiveis.remove(indiceTime2Jogador2);

            Team time1 = new Team(jogador1Time1, jogador2Time1);
            Team time2 = new Team(jogador1Time2, jogador2Time2);

            teams.add(time1);
            teams.add(time2);

            System.out.println("Times formados:");
            System.out.println("Time 1: " + time1);
            System.out.println("Time 2: " + time2);
        }
    }

    public class Team {
        private Usuario jogador1;
        private Usuario jogador2;

        public Team(Usuario jogador1, Usuario jogador2) {
            this.jogador1 = jogador1;
            this.jogador2 = jogador2;
        }

        public Usuario getJogador1() {
            return jogador1;
        }

        public Usuario getJogador2() {
            return jogador2;
        }
    }
}

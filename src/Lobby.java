import java.util.ArrayList;
import java.util.List;

public class Lobby {

    private List<Usuario> usu = new ArrayList<>();


    public Lobby(List<Usuario> usu) {
        this.usu = usu;
    }

    public List<Usuario> getUsu() {
        return usu;
    }

    public void addjogador(Usuario usuario) {
         usu.add(usuario);
    }

    public void buscarAdversario(Usuario usuario) {
        for (Usuario adversario : usu) {
            if (adversario != usuario && adversario.getNivel() == usuario.getNivel() && adversario.getModalidade() == usuario.getModalidade()) {  
              System.out.println("Adversário encontrado, A partida em breve será iniciada.");
              comecarJogo(adversario, usuario);
            }
        }

    }

    public void comecarJogo(Usuario jogador1, Usuario jogador2) {
        if (jogador1 != null  && jogador2 != null ) {
            if (jogador1.getDecks() != null && jogador2.getDecks() != null) {  
                Arena arena = new Arena(jogador1, jogador2);
                arena.comecoDeJogo();
            }
        }
    
    }
}


public class Arena {

    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1 = new Carta[2][5];
    private Carta[][] campoJogador2 = new Carta[2][5];
    private int pontosVidaJogador1 = 20;
    private int pontosVidaJogador2 = 20;
    
    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Deck deckJogador2, Carta[][] campoJogador1,Carta[][] campoJogador2, int pontosVidaJogador1, int pontosVidaJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = campoJogador1;
        this.campoJogador2 = campoJogador2;
        this.pontosVidaJogador1 = pontosVidaJogador1;
        this.pontosVidaJogador2 = pontosVidaJogador2;
    }

    public Arena(Usuario jogador1, Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public Usuario getJogador1() {
        return jogador1;
    }

    public Usuario getJogador2() {
        return jogador2;
    }

    public Deck getDeckJogador1() {
        return deckJogador1;
    }

    public Deck getDeckJogador2() {
        return deckJogador2;
    }

    public Carta[][] getCampoJogador1() {
        return campoJogador1;
    }

    public Carta[][] getCampoJogador2() {
        return campoJogador2;
    }

    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }

    public void comecoDeJogo(){
         System.out.println("Começando o Card Game!");
         if(pontosVidaJogador1 != 0  || pontosVidaJogador2 != 0){
            System.out.println("Segue o jogo!");
         }
         else {
            System.out.println("O jogo acabou!");
         }
    }

    public Usuario Vencedor(){
        if (pontosVidaJogador1 == 0 && pontosVidaJogador2 != 0) {
           return jogador2;
        }
         else{
           return jogador1;
        }
    }

    public void finalDoJogo(){
        System.out.println("O Grande Vencedor é .... " + Vencedor());
    }
    
}

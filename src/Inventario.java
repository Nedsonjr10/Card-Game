public class Inventario {
    private Carta[] todas_as_cartas; 
    private int nivel_atual;
    private int card_coins;

    //construtor
    public Inventario() {
        this.todas_as_cartas = new Carta[200];  // vetor com 200 cartas como foi solicitado
        this.nivel_atual = 1;
        this.card_coins = 0;
    }

    // Gets e sets
    public int getNivel_atual() {
        return nivel_atual;
    }

    public void setNivel_atual(int nivel_atual) {
        this.nivel_atual = nivel_atual;
    }

    public int getCard_coins() {
        return card_coins;
    }

    public void setCard_coins(int card_coins) {
        this.card_coins = card_coins;
    }

    public Carta[] getTodas_as_cartas() {
        return todas_as_cartas;
    }

    public void setTodas_as_cartas(Carta[] todas_as_cartas) {
        this.todas_as_cartas = todas_as_cartas;
    }

}
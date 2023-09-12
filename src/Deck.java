public class Deck {
    private String nome;
    private int quantidadeDeCartas;
    private boolean disponibilidade;
    private Carta[] cartas_no_deck;

    // construtor
    public Deck(String nome) {
        this.nome = nome;
        this.quantidadeDeCartas = 0;
        this.disponibilidade = false;
        this.cartas_no_deck = new Carta[60]; // "60" é o tamanho máx
    }

    // gets e sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeCartas() {
        return quantidadeDeCartas;
    }

    public void setQuantidadeDeCartas(int quantidadeDeCartas) {
        this.quantidadeDeCartas = quantidadeDeCartas;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Carta[] getCartas_no_deck() {
        return cartas_no_deck;
    }

    public void setCartas_no_deck(Carta[] cartas_no_deck) {
        this.cartas_no_deck = cartas_no_deck;
    }
}
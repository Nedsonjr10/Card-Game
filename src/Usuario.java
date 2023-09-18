public class Usuario {
    private String user;
    private int cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private int nivel;
    private int saldo_card_coins;
    private Carta[] inventario;
    private Deck[] decks;
    private String modalidade;

    // construtor
    public Usuario(String user, int cpf, String senha, int idade, String sexo, String email){
        this.user = user;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = 1;
        this.inventario = new Carta[1]; // numero aleatorio, falar com o prof para saber o numero certo a colocar  
        this.decks = new Deck[5]; 
        this.saldo_card_coins = 0;
    }

    // gets e sets
    public String getUser() {
        return user;
    }

    public int getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSaldo_card_coins() {
        return saldo_card_coins;
    }

    public Carta[] getInventario() {
        return inventario;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setSaldo_card_coins(int saldo_card_coins) {
        this.saldo_card_coins = saldo_card_coins;
    }

    public void setInventario(Carta[] inventario) {
        this.inventario = inventario;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
}
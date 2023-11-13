import java.util.Arrays;

public abstract class Progresso {
    private String[] vetorDePremiacoes = new String[60]; // Vetor de premiações com 60 posições
    private int premiacaoAtual = 0; // Premiação atual, inicialmente definida como 0

    public Progresso(String[] vetorDePremiacoes, int premiacaoAtual) {
        this.vetorDePremiacoes = vetorDePremiacoes;
        this.premiacaoAtual = premiacaoAtual;
    }

    public String[] getVetorDePremiacoes() {
        return vetorDePremiacoes;
    }


    public void setVetorDePremiacoes(String[] vetorDePremiacoes) {
        this.vetorDePremiacoes = vetorDePremiacoes;
    }


    public int getPremiacaoAtual() {
        return premiacaoAtual;
    }


    public void setPremiacaoAtual(int premiacaoAtual) {
        this.premiacaoAtual = premiacaoAtual;
    }
    
    public abstract void entregarPremiacao(); // Método abstrato para entregar premiação
    public abstract void progresso(); // Método abstrato para o progresso
}

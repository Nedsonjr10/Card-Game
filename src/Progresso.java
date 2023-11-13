import java.util.Arrays;

public abstract class Progresso {
    private Object[] premiacoes = new Object[60]; // Vetor de premiações com 60 posições
    private int premiacaoAtual = 0; // Premiação atual, inicialmente definida como 0

    public abstract void entregarPremiacao(); // Método abstrato para entregar premiação
    public abstract void progresso(); // Método abstrato para o progresso
}

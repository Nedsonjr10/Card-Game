import java.util.Random;

public class CartaUnique extends Carta {
    private String habilidadeExtra;

    public CartaUnique(String nome, String imagem, String tipo, String raridade, double ataque, double defesa, double custo, String habilidade, int quantidade) {
        super(nome, imagem, tipo, raridade, ataque + 1, defesa + 1, custo, habilidade, quantidade);
        this.habilidadeExtra = gerarHabilidadeExtraAleatoria();
    }

    public String getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(String habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

    private String gerarHabilidadeExtraAleatoria() {
        String[] habilidadesPadrao = {"Amedrontar", "Atropelar", "Unir", "Voar", "Força", "Teleporte"};

        Random random = new Random();
        int indice = random.nextInt(habilidadesPadrao.length);
        return habilidadesPadrao[indice];
    }
}
public class PassePremium extends Progresso {

    public PassePremium(String[] vetorDePremiacoes, int premiacaoAtual) {
        super(vetorDePremiacoes, premiacaoAtual);
    }

    @Override
    public void entregarPremiacao() {
        int premiacaoAtual = getPremiacaoAtual();
        int niveisGanhos = 2; // Uma vitória são dois níveis no passe de batalha

        while (niveisGanhos > 0) {
            if (premiacaoAtual < getVetorDePremiacoes().length) {
                if ((premiacaoAtual + 1) % 5 == 0) {
                    System.out.println("Uma vitória! Dois níveis no passe de batalha ganhos.");
                    System.out.println("Premiação: Booster especial aberto.");
                } else {
                    System.out.println("Uma vitória! Dois níveis no passe de batalha ganhos.");
                    System.out.println("Premiação: Booster comum aberto.");
                }
                setPremiacaoAtual(premiacaoAtual + 1);
                niveisGanhos--;
            } else {
                System.out.println("Passe de batalha chegou ao fim. Reiniciando o passe.");
                setPremiacaoAtual(0); // Zera as premiações
                premiacaoAtual = 0;
            }
        }
    }

    @Override
    public void progresso() {
        if (getPremiacaoAtual() >= getVetorDePremiacoes().length) {
            System.out.println("Passe de batalha chegou ao fim. O passe foi reiniciado.");
        } else {
            System.out.println("Passe de batalha em andamento. Progresso disponível.");
        }
    }
}

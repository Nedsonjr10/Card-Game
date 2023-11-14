public class PasseComum extends Progresso {

    public PasseComum(String[] vetorDePremiacoes, int premiacaoAtual) {
        super(vetorDePremiacoes, premiacaoAtual);
    }

    @Override
    public void entregarPremiacao() {
        if (getPremiacaoAtual() < getVetorDePremiacoes().length) {
            setPremiacaoAtual(getPremiacaoAtual() + 1);
            System.out.println("Uma vitória! Nível no passe de batalha ganho.");
            System.out.println("Premiação: Booster comum aberto.");
        } else {
            System.out.println("Passe de batalha chegou ao fim. Não há mais premiações a ganhar.");
        }
    }

    @Override
    public void progresso() {
        if (getPremiacaoAtual() >= getVetorDePremiacoes().length) {
            System.out.println("Passe de batalha chegou ao fim. Não é possível mais progredir.");
        } else {
            System.out.println("Passe de batalha em andamento. Progresso disponível.");
        }
    }
}





import java.util.Random;

public class Enumerate {
    private String nome;
    private double probabilidade;

    private Enumerate(String nome, double probabilidade) {
        this.nome = nome;
        this.probabilidade = probabilidade;
    }

    public String getNome() {
        return nome;
    }

    public double getProbabilidade() {
        return probabilidade;
    }

    public static Enumerate comum() {
        return new Enumerate("Comum", 0.80);
    }

    public static Enumerate incomum() {
        return new Enumerate("Incomum", 0.15);
    }

    public static Enumerate rara() {
        return new Enumerate("Rara", 0.04);
    }

    public static Enumerate muitoRara() {
        return new Enumerate("Muito Rara", 0.008);
    }

    public static Enumerate epica() {
        return new Enumerate("Épica", 0.002);
    }

    public static Enumerate obterRaridadeAleatoria() {
        Random random = new Random();
        double chance = random.nextDouble();

        if (chance <= comum().getProbabilidade()) {
            return comum();
        } else if (chance <= comum().getProbabilidade() + incomum().getProbabilidade()) {
            return incomum();
        } else if (chance <= comum().getProbabilidade() + incomum().getProbabilidade() + rara().getProbabilidade()) {
            return rara();
        } else if (chance <= comum().getProbabilidade() + incomum().getProbabilidade() + rara().getProbabilidade() + muitoRara().getProbabilidade()) {
            return muitoRara();
        } else {
            return epica();
        }
    }
}

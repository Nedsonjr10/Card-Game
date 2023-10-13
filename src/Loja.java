import java.util.Random;

public class Loja {
    private String numCartao;
    private String codVerificador;
    private boolean promocao;

    public Loja(String numCartao, String codVerificador) {
        this.numCartao = numCartao;
        this.codVerificador = codVerificador;
        this.promocao = false;
    }

    public void ativarPromocao() {
        promocao = true;
    }

    public void desativarPromocao() {
        promocao = false;
    }

    public void comprarBooster(Usuario usuario) {
        int precoBooster = promocao ? 15 : 10; // Preço do booster (comum ou especial)
        int probabilidadeCartaUnica = promocao ? 1 : 0; // Probabilidade de receber uma carta única (em porcentagem)

        if (usuario.getSaldo_card_coins() >= precoBooster) {
            usuario.setSaldo_card_coins(usuario.getSaldo_card_coins() - precoBooster);

            Carta[] inventario = usuario.getInventario();
            for (int i = 0; i < 12; i++) {
                Carta cartaAleatoria = gerarCartaAleatoria(probabilidadeCartaUnica);
                adicionarCartaInventario(inventario, cartaAleatoria);
            }

            System.out.println("COMPRA REALIZADA COM SUCESSO");
        } else {
            System.out.println("VOCÊ NÃO POSSUI SALDO SUFICIENTE");
        }
    }

public void comprarBoosterEspecial(Usuario usuario) {
    int precoBoosterEspecial = 15; // Preço do booster especial
    int probabilidadeCartaUnica = 1; // Probabilidade de receber uma carta única (em porcentagem)

    if (usuario.getSaldo_card_coins() >= precoBoosterEspecial) {
        usuario.setSaldo_card_coins(usuario.getSaldo_card_coins() - precoBoosterEspecial);

        Carta[] inventario = usuario.getInventario();
        for (int i = 0; i < 12; i++) {
            Carta cartaAleatoria = gerarCartaAleatoria(probabilidadeCartaUnica);
            adicionarCartaInventario(inventario, cartaAleatoria);
        }

        System.out.println("Compra realizada com sucesso!");
    } else {
        System.out.println("Sem saldo suficiente");
    }
}

    public Carta gerarCartaAleatoria(int probabilidadeCartaUnica) {
        Random aleatorio = new Random();

        String nome = "Nome Qualquer";
        String imagem = "Imagem Qualquer";
        String tipo = "Tipo Qualquer";

        String[] vet_raridade = {"comum", "incomum", "rara", "muito rara", "epica"};
        String raridade = vet_raridade[aleatorio.nextInt(vet_raridade.length)];

        double ataque = aleatorio.nextDouble();
        double defesa = aleatorio.nextDouble();
        double custo = aleatorio.nextDouble();
        String habilidade = "Habilidade Qualquer";
        int quantidade = 1;

        if (aleatorio.nextInt(100) < probabilidadeCartaUnica) {
            nome = "Carta Única";
            raridade = "única";
        }

        return new Carta(nome, imagem, tipo, raridade, ataque, defesa, custo, habilidade, quantidade);
    }

    public void adicionarCartaInventario(Carta Inventario[], Carta carta) {
        for (int i = 0; i < Inventario.length; i++) {
            if (Inventario[i] == null) {
                Inventario[i] = carta;
                return; 
            }
        }
        System.out.println("Inventário lotado");
    }
}
import java.util.Random;

public class Loja {
	
	//atributos
	private String numCartao;
	private String codVerificador;
	
	
	
	//construtor
	public Loja(String numCartao,String codVerificador) {
		
		this.numCartao=numCartao;
		this.codVerificador=codVerificador;
	}
	
	
	//get and set 
	
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao=numCartao;
	}
	
	public String getCodVerificador() {
		return codVerificador;
	}


	public void setCodVerificador(String codVerificador) {
		this.codVerificador = codVerificador;
	}

     
	//metodos
	public void comprarBooster(Usuario usuario) { // ACESSO A CLASSE USUARIO PARA PODER PEGAR AS INFORMAÇOES DO JOGADOR
		
		int precoBooster=10; // defini o preço do booster para ficar me basear
		
		if(usuario.getSaldo_card_coins()>=precoBooster) {
			usuario.setSaldo_card_coins(usuario.getSaldo_card_coins()-precoBooster); // mudo o saldo de card coin, pegando o valor que já existia e tirando o preço do booster
			
			Carta[] inventario=usuario.getInventario();
			for(int i=0;i<12;i++) {
				Carta cartaAleatoria= gerarCartaAleatoria();
				int retorno = analiseRepetida(cartaAleatoria,usuario);
				if(retorno == 1) {
					System.out.println("VOCÊ JÁ POSSUI ESSA CARTA. SERA DEPOSITADO 10 BOOSTER´S NO SEU SALDO PARA TENTAR TIRAR OUTRA CARTA.--BOA SORTE--");
					usuario.setSaldo_card_coins(usuario.getSaldo_card_coins()+10);
					
				} else {
					System.out.println("COMPRA REALIZADA COM SUCESSO");
					System.out.println("CARTA ADICIONADO NO INVENTARIO. USE COM SABEDORIA");
					adicionarCartaInventario(inventario,cartaAleatoria);
				}
					
				}
				
			}else {
				System.out.println("VOCE NÃO POSSUI SALDO SUFICIENTE. TENTE NOVAMENTE EM OUTRA OPORTUNIDADE");
			}
			
			
		}
	
   public Carta gerarCartaAleatoria() {
	   
	   Random aleatorio = new Random();
	  
	   String nome="nome qualquer";//mesma situacao do tipo
	   String imagem="imagem qualquer";//??????
	   String tipo = "tipo qualquer"; // ajustar depois com um vetor com os tipos de cartas que vamos definir 
	   String vet_raridade[] = {"comum","incomum","rara","muito rara","epica"};	   
	   String raridade = vet_raridade[aleatorio.nextInt(vet_raridade.length)];// basicamente é criado um numero aleatorio entre 0 e 4 que vai sortear o tipo de raridade da carta
	   double ataque = aleatorio.nextDouble();// gera um numero qualquer para o ataque
	   double defesa = aleatorio.nextDouble();// gera um numero qualquer para a defesa
	   double custo = aleatorio.nextDouble();// gera um numero qualquer para o custo da carta
	   String habilidade = "habilidade qualquer";// mesma situação do tipo
	   int quantidade = 1;// o metodo so vai me dar uma carata
	   
	   
	   return new Carta(nome,imagem,tipo,raridade,ataque,defesa,custo,habilidade,quantidade);
	   
   }
   
   
   public void adicionarCartaInventario(Carta Inventario[],Carta carta) {
	   
	   
	   for(int i=0;i<Inventario.length;i++) {
		   if(Inventario[i]==null) {
			   Inventario[i]= carta;
		   }
		   else {
			   System.out.println("Inventario lotado");
		   }
		   
	   }
   }
   
   public int analiseRepetida(Carta cartaAleatoria,Usuario usuario) {
	   
	   Carta[] inventario=usuario.getInventario();
	   
	   
	   for( Carta carta : inventario) {
		   if( carta != null && carta.equals(cartaAleatoria)) {
			   return 1;
		   }
		  
	   }
	   return 0;
	   

   }
}
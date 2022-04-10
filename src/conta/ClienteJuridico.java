package conta;

import java.sql.Date;
import java.util.Scanner;

public class ClienteJuridico extends Conta {

		Scanner leitor = new Scanner(System.in);
		private String cnpj;
		
		public ClienteJuridico(Pessoa cliente, int agencia, int numeroDaConta, double saldo, String senha, String cnpj) {
			super(cliente, agencia, numeroDaConta, saldo, senha);
			this.cnpj = cnpj;
		}
		
		@Override
		public void solicitarDesbloqueio(){
			Gerente.alterarStatus();
		}

		@Override
		public void transferir(double valor, Conta favorecido, String senha) {
			
			if(senha != getSenha()) {
				for (int i = 2; i < 4; i++){
					System.out.println("Senha Inválida.");
					System.out.println("");
					System.out.println(i + "° Tentativa");
					System.out.println("Digite a Senha:");
					
					senha = leitor.next();
					if(senha == getSenha()) break;
					if(i == 3) System.out.println("Senha Inválida. Conta Bloqueada");
					System.out.println("");
				}
			}

			if(senha == getSenha()){
				if(favorecido.isStatus() == false) System.out.println("TransferÃªncia nÃ£o realizada. A conta do/a foverecido/a estÃ¡ bloqueada.");
						else if(getSaldo() < valor) System.out.println("Saldo Insuficiente");
							else{	
								setTentativasErradas(0);
								favorecido.receberValor(valor);
								
								setExtrato().add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
								setextrato().add("TransferÃªncia de " + valor + " R$ feita para " + Pessoa.getNome() 
								+  ".\n\t\t\t\t\t\tSaldo: " + getSaldo() + " R$ \n");
								favorecido.setExtrato().add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
								favorecido.setExtrato().add("TransferÃªncia de " + valor + " R$ recebida de " + Pessoa.getNome() 
								+  ".\n\t\t\t\t\t\tSaldo: " + favorecido.getSaldo() + " R$ \n");
								
								System.out.println("A sua tranferÃªncia para  " + favorecido.getNome() + " foi realizada com sucesso.");
								System.out.println("");
							}
			}
			
			if(getTentativasErradas() == 3){
				System.out.println("Deseja solicitar o desbloqueio da conta? (S / N)");
				char opcao = leitor.next().toUpperCase().charAt(0);

				if(opcao == 'S') {
					System.out.println("Confirme seu endereco:");
					String endereco = leitor.next();
					if(endereco == Pessoa.getEndereco()) {

						solicitarDesbloqueio();
						System.out.println("Desbloqueio solicitado, aguarde 1 minuto e faça um novo acesso.");
						System.out.println("");
					}
				}
			}else{System.out.println("Acesso encerrado");
			System.out.println("");
			leitor.close();
		}
	}
}
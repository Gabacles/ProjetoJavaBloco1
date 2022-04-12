package programa;

import conta.*;
import pessoa.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaBanco {

	public static void main(String[] args) {
		List<PessoaFisica> clientesF = new ArrayList<PessoaFisica>();
		List<PessoaJuridica> clientesJ = new ArrayList<PessoaJuridica>();
		Scanner ler = new Scanner(System.in);
		Conta usuarioLogado;
		int login=0;
		String senha;
		boolean usuario=false;
		
		PessoaFisica cliente1 = new PessoaFisica("Ares", "3456", "35598806", "poupanca", 1000.00, "1234");
		
		PessoaFisica cliente2 = new PessoaFisica("Someria", "3457", "35598807", "poupanca", 2000.00, "1235");
		
		PessoaFisica cliente3 = new PessoaFisica("Moris", "3457", "35598807", "corrente", 5000.00, "senha12");
		
		PessoaJuridica cliente4 = new PessoaJuridica("Capilar", "3458", "838388383", "corrente", 100000.00, "hdamsm12");
		
		PessoaGerente gerente1 = new PessoaGerente("Almar", "345678", "345678");
		
		Conta.imprimirContasAbertas();
		
		while(usuario == false) {
			int opcao = 0;
			int opcaoLogin = 0;
			System.out.println("============================BANCO JP============================");
			System.out.println("1 - Login\n2 - Cadastro");
			boolean continueLoop=true;
			do {
				try {
					System.out.print("Digite a opção: ");
					opcaoLogin = ler.nextInt();
					continueLoop = false;
				}catch(java.util.InputMismatchException e){
					ler.next();
					System.out.println("Erro! Digite apenas números.\n");
				}
			}while(continueLoop);
			continueLoop=true;
			if (opcaoLogin == 2) {
				System.out.println("===========================CADASTRAR============================");
				System.out.println("1 - Cadastro de pessoa física\n2 - Cadastro de pessoa jurídica");
				do {
					try {
						System.out.print("Digite a opção: ");
						opcaoLogin = ler.nextInt();
						continueLoop = false;
					}catch(java.util.InputMismatchException e){
						ler.next();
						System.out.println("Erro! Digite apenas números.\n");
					}
				}while(continueLoop);
				continueLoop=true;
				if (opcaoLogin == 1) {
					System.out.println("Digite o nome: ");
					String nome = ler.next();
					System.out.println("Digite o telefone: ");
					String telefone = ler.next();
					System.out.println("Digite o CPF: ");
					String cpf = ler.next();
					for (int i = 0; i < clientesF.size(); i++) {
						while (clientesF.get(i).getCpf().equals(cpf)) {
							System.out.println("O CPF "+clientesF.get(i).getCpf()+" já possui conta corrente.");
							System.out.println("Digite o CPF: ");
							cpf = ler.next();
						}
					}
					System.out.println("Digite o tipo da conta: ");
					String tipo = ler.next();
					while (!tipo.equals("corrente") && !tipo.equals("poupanca")) {
						System.out.println("Tipo de conta inválida! Digite 'poupanca' ou 'corrente'.");
						System.out.println("Digite o tipo da conta: ");
						tipo = ler.next();
					}
					int saldo = 0;
					do {
						try {
							System.out.println("Digite o saldo inicial: ");
							saldo = ler.nextInt();
							continueLoop = false;
						}catch(java.util.InputMismatchException e){
							ler.next();
							System.out.println("Erro! Digite apenas números.\n");
						}
					}while(continueLoop);
					continueLoop=true;
					System.out.println("Digite a senha: ");
					String senha1 = ler.next();
					clientesF.add(new PessoaFisica(nome, telefone, cpf, tipo, saldo, senha1));
					System.out.println("Cliente cadastrado com sucesso!");
					Conta.imprimirContasAbertas();
					opcaoLogin=0;
				}
				else if (opcaoLogin == 2) {
					System.out.println("Digite o nome da empresa: ");
					String nome = ler.next();
					System.out.println("Digite o telefone: ");
					String telefone = ler.next();
					System.out.println("Digite o CNPJ: ");
					String cpf = ler.next();
					System.out.println("Digite o tipo da conta: ");
					String tipo = ler.next();
					while (!tipo.equals("corrente") && !tipo.equals("poupanca")) {
						System.out.println("Tipo de conta inválida! Digite 'poupanca' ou 'corrente'.");
						System.out.println("Digite o tipo da conta: ");
						tipo = ler.next();
					}
					int saldo = 0;
					do {
						try {
							System.out.println("Digite o saldo inicial: ");
							saldo = ler.nextInt();
							continueLoop = false;
						}catch(java.util.InputMismatchException e){
							ler.next();
							System.out.println("Erro! Digite apenas números.\n");
						}
					}while(continueLoop);
					continueLoop=true;
					System.out.println("Digite a senha: ");
					String senha1 = ler.next();
					clientesJ.add(new PessoaJuridica(nome, telefone, cpf, tipo, saldo, senha1));
					System.out.println(clientesJ.get(0).getNome());
					System.out.println("Cliente cadastrado com sucesso!");
					Conta.imprimirContasAbertas();
					opcaoLogin=0;
				}
			}
			else if (opcaoLogin == 1) {
				//System.out.println(programa.Fontes.textoLogin);
				//System.out.println("=============================LOGIN==============================");
				
				do {
					try {
						System.out.print("Digite o número da conta: ");
						login = ler.nextInt();
						ler.nextLine();
						continueLoop = false;
					}catch(java.util.InputMismatchException e){
						ler.next();
						System.out.println("Erro! Digite apenas números.\n");
					}
				}while(continueLoop);
				continueLoop=true;
				System.out.print("Digite sua senha: ");
				senha = ler.next();
				for (Conta conta : Conta.getContasAbertas()) {
			    	if (conta.getNumeroDaConta() == login && conta.getSenha().equals(senha)) {
			    		usuarioLogado = conta;
			    		usuario=true;
			    		while(opcao != 7) {
			    			System.out.println("============================BEM-VINDO===========================");
			    			System.out.println("1 - Depósito\n2 - Saque\n3 - Transferência\n4 - Extrato\n5 - Redefinir senha\n6 - Sair\n7 - Encerrar programa");
			    			System.out.println("================================================================");
			    			do {
								try {
									System.out.println("Digite o tipo de operação: ");
					    			opcao = ler.nextInt();
									continueLoop = false;
								}catch(java.util.InputMismatchException e){
									ler.next();
									System.out.println("Erro! Digite apenas números.\n");
								}
							}while(continueLoop);
							continueLoop=true;
			    			if (opcao == 1) {
			    				continueLoop=true;
			    				do {
			    					try {
			    						System.out.println("============================DEPOSITAR===========================");
			    						System.out.println("Digite o valor para depósito: ");
			    						double valor = ler.nextDouble();
			    						while(valor <= 0) {
			    							System.out.println("Valor inválido! Digite um valor maior que 0.");
			    							System.out.println("Digite o valor para depósito: ");
				    						valor = ler.nextDouble();
			    						}
			    						usuarioLogado.depositar(valor);
			    						continueLoop = false;
			    					}catch(java.util.InputMismatchException e){
			    						ler.next();
		    							System.out.println("Erro! Digite apenas números.\n");
		    						}
			    				}while(continueLoop);
			    			}
			    			else if (opcao == 2) {
			    				continueLoop=true;
			    				do {
			    					try {
			    						System.out.print("Digite o valor para saque: ");
					    				double valor = ler.nextDouble();
					    				while(valor <= 0) {
			    							System.out.println("Valor inválido! Digite um valor maior que 0.");
			    							System.out.println("Digite o valor para depósito: ");
				    						valor = ler.nextDouble();
			    						}
					    				System.out.print("Digite sua senha: ");
					    				String pin = ler.next();
					    				usuarioLogado.sacar(valor, pin);
			    						continueLoop = false;
			    					}catch(java.util.InputMismatchException e){
			    						ler.next();
		    							System.out.println("Erro! Digite apenas números.\n");
		    						}
			    				}while(continueLoop);
			    			}
			    			else if (opcao == 3) {
			    				int tipoTransferencia=0;
			    				System.out.println("===========================TRANSFERIR===========================");
			    				do {
			    					try {
			    						System.out.println("1 - TED\n2 - Pix");
					    				System.out.println("================================================================");
					    				System.out.print("Digite a opção: ");
					    				tipoTransferencia = ler.nextInt();
					    				continueLoop=false;
					    				while (tipoTransferencia != 1 && tipoTransferencia != 2) {
					    					System.out.println("Opção inválida!");
					    					System.out.println("================================================================");
						    				System.out.print("Digite a opção: ");
						    				tipoTransferencia = ler.nextInt();
					    				}
			    					}catch(java.util.InputMismatchException e){
			    						ler.next();
		    							System.out.println("Erro! Digite apenas números.\n");
		    						}
			    				}while(continueLoop);
			    				continueLoop=true;
			    				do {
			    					try {
			    						System.out.print("Digite o valor da transferência: ");
					    				double valor = ler.nextDouble();
					    				while(valor <= 0) {
			    							System.out.println("Valor inválido! Digite um valor maior que 0.");
			    							System.out.println("Digite o valor para depósito: ");
				    						valor = ler.nextDouble();
			    						}
					    				System.out.print("Digite a conta favorecida: ");
					    				int favorecido = ler.nextInt();
					    				System.out.print("Digite sua senha: ");
					    				String pin = ler.next();
					    				if (tipoTransferencia == 1) {
					    					usuarioLogado.transferir(valor, favorecido, pin);
					    				}
					    				else if (tipoTransferencia == 2) {
					    					usuarioLogado.transferir(valor, favorecido, pin, "PIX");
					    				}
			    						continueLoop = false;
			    					}catch(java.util.InputMismatchException e){
			    						ler.next();
		    							System.out.println("Erro! Digite apenas números.\n");
		    						}
			    				}while(continueLoop);
			    			}
			    			else if (opcao == 4) {
			    				continueLoop=true;
			    				usuarioLogado.imprimirExtrato();
			    			}
			    			else if (opcao == 5) {
			    				continueLoop=true;
			    				String tel;
			    				String pin;
			    				System.out.print("Digite seu telefone: ");
			    				tel = ler.next();
			    				System.out.print("Digite sua nova senha: ");
			    				pin = ler.next();
			    				usuarioLogado.redefinirSenha(tel, pin);
			    			}
			    			else if (opcao == 6) {
			    				usuario=false;
			    				opcao=7;
			    			}
			    			else if (opcao != 7){
			    				System.out.println("Opção inválida!");
			    			}
			    		}
			    	}
			    }
			}
			else if (opcaoLogin != 1 && opcaoLogin != 2) {
				System.out.println("Opção inválida!");
			}
			if (usuario == false && opcao != 7 && opcao == 0)
	    		System.out.println("\nAgência ou senha inválidas!");
		}
	}
}

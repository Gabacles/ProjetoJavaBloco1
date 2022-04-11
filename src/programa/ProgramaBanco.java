package programa;

import conta.*;
import pessoa.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProgramaBanco {

	public static void main(String[] args) {
		List<PessoaFisica> clientesF = new ArrayList<PessoaFisica>();
		List<PessoaJuridica> clientesJ = new ArrayList<PessoaJuridica>();
		Scanner ler = new Scanner(System.in);
		Conta usuarioLogado;
		int login;
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
			System.out.println("============Banco JP============");
			System.out.println("1 - Login\n2 - Cadastro");
			System.out.print("Digite a opção: ");
			opcao = ler.nextInt();
			if (opcao == 2) {
				System.out.println("==============CADASTRAR============");
				System.out.println("\n1 - Cadastro de pessoa física\n2 - Cadastro de pessoa jurídica");
				System.out.print("Digite a opção: ");
				opcao = ler.nextInt();
				if (opcao == 1) {
					System.out.println("Digite o nome: ");
					String nome = ler.next();
					System.out.println("Digite o telefone: ");
					String telefone = ler.next();
					System.out.println("Digite o CPF: ");
					String cpf = ler.next();
					System.out.println("Digite o tipo da conta: ");
					String tipo = ler.next();
					System.out.println("Digite o saldo inicial: ");
					int saldo = ler.nextInt();
					System.out.println("Digite a senha: ");
					String senha1 = ler.next();
					clientesF.add(new PessoaFisica(nome, telefone, cpf, tipo, saldo, senha1));
					System.out.println(clientesF.get(0).getNome());
					System.out.println("Cliente cadastrado com sucesso!");
					Conta.imprimirContasAbertas();
					opcao=0;
				}
				else if (opcao == 2) {
					System.out.println("Digite o nome da empresa: ");
					String nome = ler.next();
					System.out.println("Digite o telefone: ");
					String telefone = ler.next();
					System.out.println("Digite o CNPJ: ");
					String cpf = ler.next();
					System.out.println("Digite o tipo da conta: ");
					String tipo = ler.next();
					System.out.println("Digite o saldo inicial: ");
					int saldo = ler.nextInt();
					System.out.println("Digite a senha: ");
					String senha1 = ler.next();
					clientesJ.add(new PessoaJuridica(nome, telefone, cpf, tipo, saldo, senha1));
					System.out.println(clientesJ.get(0).getNome());
					System.out.println("Cliente cadastrado com sucesso!");
					Conta.imprimirContasAbertas();
					opcao=0;
				}
			}
			else if (opcao == 1) {
				System.out.println("==============LOGIN==============");
				System.out.print("Digite o número da conta: ");
				login = ler.nextInt();
				ler.nextLine(); 
				System.out.print("Digite sua senha: ");
				senha = ler.next();
				for (Conta conta : Conta.getContasAbertas()) {
			    	if (conta.getNumeroDaConta() == login && conta.getSenha().equals(senha)) {
			    		usuarioLogado = conta;
			    		usuario=true;
			    		while(opcao != 7) {
			    			System.out.println("=============Bem-vindo============");
			    			System.out.println("1 - Depósito\n2 - Saque\n3 - Transferência\n4 - Extrato\n5 - Redefinir senha\n6 - Sair\n7 - Encerrar");
			    			System.out.println("Digite o tipo de operação: ");
			    			opcao = ler.nextInt();
			    			if (opcao == 1) {
			    				boolean continueLoop=true;
			    				do {
			    					try {
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
			    				boolean continueLoop=true;
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
			    				boolean continueLoop=true;
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
					    				usuarioLogado.transferir(valor, favorecido, pin);
			    						continueLoop = false;
			    					}catch(java.util.InputMismatchException e){
			    						ler.next();
		    							System.out.println("Erro! Digite apenas números.\n");
		    						}
			    				}while(continueLoop);
			    			}
			    			else if (opcao == 4) {
			    				usuarioLogado.imprimirExtrato();
			    			}
			    			else if (opcao == 5) {
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
			    			else {
			    				System.out.println("Opção inválida!");
			    			}
			    		}
			    	}
			    }
			}
			if (usuario == false && opcao != 7 && opcao != 0)
	    		System.out.println("\nAgência ou senha inválidas!");
		}
	}
}

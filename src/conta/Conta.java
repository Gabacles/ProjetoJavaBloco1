package conta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class Conta {
	
	private Cliente cliente;
	private int agencia;
	private int numeroDaConta;
	private double saldo;
	private String senha;
	private boolean status;
	private int tentativasErradas;
	private List<String> extrato;
	
	public Conta(Cliente cliente, int agencia, int numeroDaConta, double saldo, String senha) {
		this.cliente = cliente; // Ainda sem uso 
		this.agencia = agencia; // Ainda sem uso
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.senha = senha;
		this.status = true;
		this.tentativasErradas = 0;
		this.extrato = new ArrayList<>(Arrays.asList("========================EXTRATO BANCÁRIO========================\n"));
																							
	}

	public void sacar(double valor, String senha) {
		
		if (valor < saldo & this.senha == senha) {
			saldo -= valor;
			tentativasErradas = 0;
			extrato.add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
			extrato.add("Saque de " + valor + " R$." +  "\n\t\t\t\t\t\tSaldo: " + saldo + " R$ \n");
			System.out.println("Seu saque foi realizado com sucesso.");
		} else if (valor > saldo) {
			System.out.println("Seu saldo é insuficiente");
		} else {
			System.out.println("Sua senha está incorreta. Você pode redefini-la, caso precise. "
					+ "Três tentativas erradas seguidas bloqueiam a conta.");		
			if(tentativasErradas == 3) {
				status = false;
			} else {
				tentativasErradas++;
				System.out.println("Você ainda tem " + (3 - tentativasErradas) + " tentativas restantes.");
			}
		}
		
	}
	
	public void depositar(double valor) {
			saldo += valor;
			System.out.println("Seu depósito foi realizado com sucesso.");
			extrato.add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
			extrato.add("Depósito de " + valor + " R$." +  "\n\t\t\t\t\t\tSaldo: " + saldo + " R$ \n");
	}
	
	public void transferir(double valor, Conta favorecido, String senha) {
		
		if (favorecido.isStatus() == false) {
			System.out.println("Transferência não realizada. A conta do/a foverecido/a está bloqueada.");
		} else if (valor <= saldo & this.senha == senha) {
			saldo -= valor;
			tentativasErradas = 0;
			favorecido.receberValor(valor);
			extrato.add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
			extrato.add("Transferência de " + valor + " R$ feita para " + favorecido.cliente.getNome() 
			        +  ".\n\t\t\t\t\t\tSaldo: " + saldo + " R$ \n");
			favorecido.extrato.add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
			favorecido.extrato.add("Transferência de " + valor + " R$ recebida de " + cliente.getNome() 
			        +  ".\n\t\t\t\t\t\tSaldo: " + favorecido.getSaldo() + " R$ \n");
			System.out.println("A sua tranferência para  " + favorecido.cliente.getNome() + " foi realizada com sucesso.");
		} else if (valor > saldo) {
			System.out.println("Seu saldo é insuficiente.");
		} else {
			System.out.println("Sua senha está incorreta. Você pode redefini-la, caso precise. "
					+ "Três tentativas erradas bloqueiam a conta.");
			if(tentativasErradas == 3) {
				status = false;
			} else {
				tentativasErradas++;
				System.out.println("Você ainda tem " + (3 - tentativasErradas) + " tentativas restantes.");
			}
		}
	}
	
	public void redefinirSenha(String telefone, String novaSenha) {
		if (cliente.telefone == telefone) {
			senha = novaSenha;
			tentativasErradas = 0;
			System.out.println("Sua senha foi modificada com sucesso.");
		} else {
			System.out.println("Telefone incorreto. Três tentativas erradas bloqueiam a conta.");
			if (tentativasErradas == 3) {
				status = false;
			} else {
				tentativasErradas++;
				System.out.println("Você ainda tem " + (3 - tentativasErradas) + " tentativas restantes.");
			}
		}
		
	} 
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void receberValor(double valor) {
		this.saldo += valor; 
	}

	public void consultarSaldo() {
		System.out.println("Olá, " + cliente.getNome() + ", seu saldo é: " + saldo + " R$.");
	}
	
	public void imprimirExtrato() {
		extrato.forEach(System.out::println);
		System.out.println("================================================================\n");
	}
}
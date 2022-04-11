package conta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import pessoa.Pessoa;

public abstract class Conta {
	
	private Pessoa cliente;
	private int agencia;
	private int numeroDaConta;
	private double saldo;
	private String senha;
	private boolean status;
	private int tentativasErradas;
	private List<String> extrato;
	static List<Conta> contasAbertas = new ArrayList<>();
	private Random rand = new Random();
	
	public Conta(Pessoa cliente, double saldo, String senha) {
		this.cliente = cliente;
		this.agencia = rand.nextInt((400 - 200) + 1) + 200;
		this.numeroDaConta = rand.nextInt((40000 - 20000) + 1) + 20000;
		this.saldo = saldo;
		this.senha = senha;
		this.status = true;
		this.tentativasErradas = 0;
		this.extrato = new ArrayList<>(Arrays.asList("========================EXTRATO BANCÁRIO========================\n"));																	
	}
	
	{
		getContasAbertas().add(this);
	}

	public void sacar(double valor, String senha) {
		
		if (valor <= saldo & this.getSenha().equals(senha)) {
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
	
	public void transferir(double valor, int numeroDaConta, String senha) {
		
		List<Integer> numeroDeContas = new ArrayList<>();
		for (Conta conta : contasAbertas) {	
			if (conta.getNumeroDaConta() == numeroDaConta) {
				numeroDeContas.add(conta.getNumeroDaConta());
				if (conta.isStatus() == false) {
					System.out.println("Transferência não realizada. A conta do/a foverecido/a está bloqueada.");
				} else if (valor <= saldo & this.getSenha().equals(senha)) {
					saldo -= valor;
					tentativasErradas = 0;
					conta.receberValor(valor);
					extrato.add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
					extrato.add("Transferência de " + valor + " R$ feita para " + conta.cliente.getNome()
							+ ".\n\t\t\t\t\t\tSaldo: " + saldo + " R$ \n");
					conta.extrato.add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
					conta.extrato.add("Transferência de " + valor + " R$ recebida de " + cliente.getNome()
							+ ".\n\t\t\t\t\t\tSaldo: " + conta.getSaldo() + " R$ \n");
					System.out.println(
							"A sua tranferência para " + conta.cliente.getNome() + " foi realizada com sucesso.");
				} else if (valor > saldo) {
					System.out.println("Seu saldo é insuficiente.");
				} else {
					System.out.println("Sua senha está incorreta. Você pode redefini-la, caso precise. "
							+ "Três tentativas erradas bloqueiam a conta.");
					if (tentativasErradas == 3) {
						status = false;
					} else {
						tentativasErradas++;
						System.out.println("Você ainda tem " + (3 - tentativasErradas) + " tentativas restantes.");
					}
				} 
			}
		}
		
		if (!numeroDeContas.contains(numeroDaConta)) {
			System.out.println("O número da conta informada não existe.");
		}
		
	}
	
	public void redefinirSenha(String telefone, String novaSenha) {
		if (cliente.getTelefone().equals(telefone)) {
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(int numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public void receberValor(double valor) {
		this.saldo += valor; 
	}

	public void consultarSaldo() {
		System.out.println("Olá, " + cliente.getNome() + ", seu saldo é: " + saldo + " R$.\n");
	}
	
	public void imprimirExtrato() {
		extrato.forEach(System.out::println);
		System.out.println("================================================================\n");
	}
	
	public static void imprimirContasAbertas() {
		System.out.println("=========================CONTAS ABERTAS=========================");
		for(Conta conta: Conta.getContasAbertas()){			
			System.out.println("Cliente: " +  conta.cliente.getNome() + " Número da conta: " + conta.numeroDaConta);
			}
		}

	public static List<Conta> getContasAbertas() {
		return contasAbertas;
	}

	public static void setContasAbertas(List<Conta> contasAbertas) {
		Conta.contasAbertas = contasAbertas;
	}
	
}
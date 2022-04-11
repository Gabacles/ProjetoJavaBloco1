package pessoa;

import conta.*;

public class PessoaFisica extends Pessoa {
	
	private Conta conta;
	private String cpf;
	
	public PessoaFisica(String nome, String telefone, String cpf, String tipoConta, double saldo, String senha) {
		super(nome, telefone);
		this.cpf = cpf;
		if (tipoConta == "poupanca") {
			this.conta = new ContaPoupanca(this, saldo, senha); 
		}
		if (tipoConta == "corrente") {
			this.conta = new ContaCorrente(this, saldo, senha);
		}
	}
	
	public void solicitarDesbloqueio(PessoaGerente gerente, String telefone) {
		gerente.alterarStatus(telefone);
	}

	public Conta getConta() {
		return conta;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

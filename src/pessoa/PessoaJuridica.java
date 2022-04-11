package pessoa;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private Conta conta;
	
	public PessoaJuridica(String nome, String telefone, String cnpj, String tipoConta, double saldo, String senha) {
		super(nome, telefone);
		this.cnpj = cnpj;
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
	
	public String getCnpj() {
		return cnpj;
	}

	public Conta getConta() {
		return conta;
	}
	
	
	

}
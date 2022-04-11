package conta;

import pessoa.Pessoa;

public class ContaCorrente extends Conta{
	
	private double taxa = 1.5;
	
	public ContaCorrente(Pessoa cliente, double saldo, String senha) {
		super(cliente, saldo, senha);
	}

	public double getTaxa() {
		return taxa;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

}
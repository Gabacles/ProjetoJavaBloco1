package conta;

import pessoa.Pessoa;

public class ContaPoupanca extends Conta{

	private double rendimento = 3.5;
	

	public ContaPoupanca(Pessoa cliente, double saldo, String senha) {
		super(cliente, saldo, senha);
	}
	
	public double getPoupanca() {
		return rendimento;
	}
	
	public void setPoupanca(double rendimento) {
		this.rendimento = rendimento;
	}
	
}
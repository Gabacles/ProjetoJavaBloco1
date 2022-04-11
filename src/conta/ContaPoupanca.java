package ContaBanco;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Pessoa ClienteFisco, ClienteJurido, Gerente, int agencia, int numeroConta, int senha) {
		super(ClienteFisico, ClienteJuridico, numeroConta, agencia, senha);
	}
	
	private double rendimento = 0.25;
	
	public double getPoupanca() {
		return rendimento;
	}
	
	public void setPoupanca(double rendimento) {
		this.rendimento = (getSaldo()*rendimento);
	}
	
}

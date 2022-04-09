package ContaBanco;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Pessoa ClienteFisco, ClienteJurido, Gerente, int agencia, numeroConta, int senha) {
		super(ClienteFisico, ClienteJuridico, numeroConta, agencia, senha);
	}
	
	private double rendimento = 3.5;
	
	public double getPoupanca() {
		return rendimento;
	}
	
	public void setPoupanca(double rendimento) {
		this.rendimento = rendimento;
	}
	
}

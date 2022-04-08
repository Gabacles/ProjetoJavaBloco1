
public class ContaCorrente extends Conta{
	
	public ContaCorrente(Pessoa ClienteFisco, ClienteJurido, Gerente, int agencia, numeroConta, int senha) {
		super(ClienteFisico, ClienteJuridico, numeroConta, agencia, senha);
	}
	
	private double taxa = 1.5;
	
	public double getTaxa() {
		return taxa;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

}

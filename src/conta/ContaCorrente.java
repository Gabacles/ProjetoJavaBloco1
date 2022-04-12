package conta;

import java.util.Date;

import pessoa.Pessoa;

public class ContaCorrente extends Conta{
	
	private double taxa = 5;
	
	public ContaCorrente(Pessoa cliente, double saldo, String senha) {
		super(cliente, saldo, senha);
	}

	public double getTaxa() {
		return taxa;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public void sacar(double valor, String senha) {
		
		if (valor <= this.getSaldo() & this.getSenha().equals(senha)) {
			setSaldo(getSaldo() - (valor + taxa));
			setTentativasErradas(0);
			getExtrato().add("+++++++++++++++++ " + new Date() + " +++++++++++++++++\n");
			getExtrato().add("Saque de " + valor + " R$." +  "\n\t\t\t\t\t\tSaldo: " + getSaldo() + " R$ \n");
			System.out.println("Seu saque foi realizado com sucesso.");
		} else if (valor > getSaldo()) {
			System.out.println("Seu saldo é insuficiente");
		} else {
			System.out.println("Sua senha está incorreta. Você pode redefini-la, caso precise. "
					+ "Três tentativas erradas seguidas bloqueiam a conta.");		
			if(getTentativasErradas() == 3) {
				setStatus(false);
			} else {
				setTentativasErradas(getTentativasErradas() +1);
				System.out.println("Você ainda tem " + (3 - getTentativasErradas()) + " tentativas restantes.");
			}
		}	

	}

		
}
package conta;

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
		
		if (valor <= saldo & this.getSenha().equals(senha)) {
			saldo -= (valor + taxa);
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
}
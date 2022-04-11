package conta;

import pessoa.Pessoa;
import java.util.*;

public class ContaPoupanca extends Conta{
	
	private double rendimento = 0.25;
	
	public ContaPoupanca(Pessoa cliente, double saldo, String senha) {
		super(cliente, saldo, senha);
	}

	public double getRendimento() {
		return rendimento;
	}
	
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	@Override
		public void sacar(double valor, String senha) {
		
		if (valor <= this.getSaldo() & this.getSenha().equals(senha)) {
			setSaldo((getSaldo()* rendimento) - valor);
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
				setStatus (false);
			} else {
				setTentativasErradas(getTentativasErradas() + 1);
				System.out.println("Você ainda tem " + (3 - getTentativasErradas()) + " tentativas restantes.");
			}
		}	

	}
}
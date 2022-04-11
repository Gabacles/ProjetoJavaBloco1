package programa;

import pessoa.*;
import conta.*;

public class Testes {

	public static void main(String[] args) {
		
		
		String textoInicial = """
												

						██████╗  █████╗ ███╗   ██╗ ██████╗ ██████╗                                        
						██╔══██╗██╔══██╗████╗  ██║██╔════╝██╔═══██╗                                       
						██████╔╝███████║██╔██╗ ██║██║     ██║   ██║                                       
						██╔══██╗██╔══██║██║╚██╗██║██║     ██║   ██║                                       
						██████╔╝██║  ██║██║ ╚████║╚██████╗╚██████╔╝                                       
						╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═════╝                                        
						                                                                                  
						 ██████╗ ███████╗███╗   ██╗███████╗██████╗  █████╗ ████████╗██╗ ██████╗ ███╗   ██╗
						██╔════╝ ██╔════╝████╗  ██║██╔════╝██╔══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
						██║  ███╗█████╗  ██╔██╗ ██║█████╗  ██████╔╝███████║   ██║   ██║██║   ██║██╔██╗ ██║
						██║   ██║██╔══╝  ██║╚██╗██║██╔══╝  ██╔══██╗██╔══██║   ██║   ██║██║   ██║██║╚██╗██║
						╚██████╔╝███████╗██║ ╚████║███████╗██║  ██║██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║
						 ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
						                                                                                  							                                                                          
												
										
				""";
		
		System.out.print(textoInicial);
		
		PessoaFisica cliente1 = new PessoaFisica("Ares", "3456", "35598806", "poupanca", 1000.00, "1234");
		
		PessoaFisica cliente2 = new PessoaFisica("Someria", "3457", "35598807", "poupanca", 2000.00, "1235");
		
		PessoaFisica cliente3 = new PessoaFisica("Moris", "3457", "35598807", "corrente", 5000.00, "senha12");
		
		PessoaJuridica cliente4 = new PessoaJuridica("Capilar", "3458", "838388383", "corrente", 100000.00, "hdamsm12");
		
		PessoaGerente gerente1 = new PessoaGerente("Almar", "345678", "345678");
		
		
	
		cliente1.getConta().depositar(700.00);
		cliente1.getConta().sacar(500.00, "1234");
		cliente1.getConta().sacar(500.00, "12345");
		cliente1.getConta().sacar(5000.00, "1234");
		cliente1.getConta().transferir(100.00, cliente2.getConta().getNumeroDaConta(), "1234");
		cliente3.getConta().transferir(1500.00, cliente1.getConta().getNumeroDaConta(), "senha12");
		cliente3.getConta().transferir(1500.00, 888888888, "senha12");
		cliente4.getConta().depositar(8000);
		cliente4.getConta().transferir(9000, cliente3.getConta().getNumeroDaConta(), "hdamsm12");
		
		cliente1.getConta().imprimirExtrato();
		cliente2.getConta().consultarSaldo();
		cliente4.getConta().imprimirExtrato();
		
		// bloquear conta com senhas erradas
		
		cliente1.getConta().sacar(500.00, "123");
		cliente1.getConta().sacar(500.00, "123");
		cliente1.getConta().sacar(500.00, "123");
		
		// se a conta for bloqueada, ainda falta implementar um condição que impeça novas tenativas
		//e exiba a mensagem de bloqueio
		
		cliente1.getConta().sacar(500.00, "123");
		cliente1.getConta().sacar(500.00, "123");
		
		
		
		// gerente desbloqueia
		/* A melhor maneira seria relacionar um cliente com um gerente, toda vez que uma pessoa é criada.
		* Se tivermos um único gerente, é fácil, mas se for criar mais de um gerete as coisas começam a complicar... 
		* Então, acho que vale a pena manter assim, passando o gerente como parâmetro. 
		* */
		
		cliente1.solicitarDesbloqueio(gerente1, "3456");  // Nova maneira de solicitar o desbloqueio
	
		
		
		
		//gerente1.alterarStatus("3456"); // falta criar um método em conta para solicitar para o gerente 
		
		// nova tentativa de saque
		
		cliente1.getConta().sacar(500.00, "123");
		
		cliente1.getConta().imprimirExtrato();

		Conta.imprimirContasAbertas();
		
	}
	
}

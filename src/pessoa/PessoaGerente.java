package pessoa;
import conta.*;

public class PessoaGerente extends Pessoa {

	private String cpf;

	public PessoaGerente(String nome, String telefone, String cpf) {
        super(nome, telefone);
        this.cpf = cpf;
    }

    public void alterarStatus(String telefone) {
        for (Conta conta : Conta.getContasAbertas()) {
            if (conta.getCliente().getTelefone().equals(telefone)) {
                conta.setStatus(true);
                System.out.println("Conta desbloqueada com sucesso");
            } else {
                System.out.println("Telefone inválido");
            }
        }
    }
    

    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

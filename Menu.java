import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	private ArrayList<Cliente> clientes;
	
	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
		clientes = new ArrayList<Cliente>();
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
		clientes = new ArrayList<Cliente>();
	}

	public int getSelection() {
		int op = 0;
		Scanner s = new Scanner(System.in);
		while (op==0){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("\nInforme a opcao desejada.");
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			}
			catch (NumberFormatException e) {
				op =0;
			}
			if (op>=i){
				System.out.println("znOpcao errada!");
				op=0;
			}
			if(op == 1) {
				cadastrarConta();
			}
			else if (op == 2) {
				this.cadastrarCliente();
			}

		}
		return op;
	}

	public void cadastrarConta() {
		Scanner scanner = new Scanner(System.in);
		int resposta;

		do {
			System.out.println("\nMenu Conta\n");
			System.out.println("1 - Contas ja cadastradas\n2 - Cadastar conta\n");
			resposta = scanner.nextInt();
		} while(resposta != 1 && resposta != 2);

		String nome, senha;
		boolean flag = true;

		nome = scanner.nextLine();
		System.out.print("\nDigite seu nome: ");
		nome = scanner.nextLine();

		System.out.print("Digite sua senha: ");
		senha = scanner.nextLine();

		for(Cliente cliente : clientes) {
			if(cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)) {
				if(resposta == 1) {
					boolean achou = false;
					System.out.print("\n");

					for(Conta conta : cliente.getContas()) {
						System.out.println("- Conta: " + conta.getConta() + " Agencia: " + conta.getAgencia());
						achou = true;
					}
					
					if(achou) {
						System.out.print("\n");
					}
					else {
						System.out.println("\nO cliente nao possui contas cadastradas.\n");
					}
				}
				else {
					Conta conta = new Conta();
					cliente.abrirConta(conta);
					System.out.println("\nConta criada.\nConta: " + conta.getConta() + " Agencia: " + conta.getAgencia() + "\n");
				}

				flag = false;
			}
		}

		if(flag) {
			System.out.println("\nInformacoes de cliente invalidas.\n");
		}
	}
	
	public void cadastrarCliente() {
		Cliente c1 = new Cliente();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Informe o seu nome: ");
		String nome = s.nextLine();
		if(procuraCliente(nome) != null) {
			System.out.println("Usu�rio J� Cadastrado !!\n");
			
			return;
		}else {
			System.out.println("Informe a sua senha: ");
			String senha = s.nextLine();
			
			c1.setNome(nome);
			c1.setSenha(senha);
			
			clientes.add(c1);
			
			System.out.println("Cliente " + nome + " cadastrado com sucesso !!\n");
			
		}
	}
	
	public Cliente procuraCliente(String nome) {
		for(Cliente i: this.clientes) {
			if(i.getNome().equals(nome)) {
				return i;
			}
		}
		return null;
	}
	
	public void exibir_todos_clientes(){
		for(Cliente i: this.clientes) {
			System.out.println(i.getNome());
		}
	}
}

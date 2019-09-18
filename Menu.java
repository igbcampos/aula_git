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

			System.out.println("Informe a opcao desejada. ");
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			}
			catch (NumberFormatException e) {
				op =0;
			}
			if (op>=i){
				System.out.println("Opcao errada!");
				op=0;
			}
			if (op == 2) {
				this.cadastrarCliente();
			}

		}
		return op;
	}
	
	public void cadastrarCliente() {
		Cliente c1 = new Cliente();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Informe o seu nome: ");
		String nome = s.nextLine();
		if(procuraCliente(nome) != null) {
			System.out.println("Usuário Já Cadastrado !!\n");
			
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

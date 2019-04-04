import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		int op=0;
		do {
			op = mainMenu.getSelection();
			System.out.println( op + "foi selecionada");
		} while(op!=4);
		System.out.println("Fim");
	}

}

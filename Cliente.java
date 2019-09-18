import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String senha;
	private ArrayList<Conta> lista_de_contas;
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setSenha(String s) {
		this.senha = s;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void abrirConta(Conta c) {
		this.lista_de_contas.add(c);
	}
	

}

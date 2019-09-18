import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Operacao {
    private List<String> options;
    private Double valor;

    public Operacao(Double valor, List<String> options){
        this.options = options;
        this.valor = valor;
    }
    
    public void imprimirMenu(){
        int opcaoDoMenu = 1;
        for(String option: options){
            System.out.println(opcaoDoMenu++ + " - " + option);
        }
    }

    public String pegaEscolhaDoUsuario(){
        System.out.println("Informe a opcao desejada. ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        return str;
    }

    public int validaEscolhaDoUsuario(){
        int escolhaDoUsuario = 0;
        try{
            escolhaDoUsuario = Integer.parseInt(this.pegaEscolhaDoUsuario());
        }catch(NumberFormatException e){
            System.out.println("Opcao errada!");
        }
        return escolhaDoUsuario;
    }

    //Estou usando a main para testar as funções
    // public static void main(String[] args){
    //     Operacao op = new Operacao(45.4, Arrays.asList("Transferência","Saldo","Depósito"));
    //     op.imprimirMenu();
    //     System.out.println(op.validaEscolhaDoUsuario());
    // }

}
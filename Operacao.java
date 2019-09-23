import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Operacao {
    
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;
    private int tipoDaOperacao;

    public Operacao(Conta contaOrigem,Conta contaDestino,double valor,int tipoDaOperacao){
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.tipoDaOperacao = tipoDaOperacao;
        this.valor = valor;
    }

    public Operacao(Conta contaOrigem,double valor,int tipoDaOperacao){
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.tipoDaOperacao = tipoDaOperacao;
        this.valor = valor;
    }

    public String pegarNomeDaOperacao(){
        switch(this.tipoDaOperacao){
            case 1:
                return "Saque";
            case 2: 
                return "Depósito";
            case 3: 
                return "Transferência";
        }
    }

    public int pegarValorDaOperacao(){
        return this.valor;
    }

    public Conta pegarContaDeOrigem(){
        return this.contaOrigem;
    }

    public Conta pegarContaDeDestino(){
        return this.contaDestino;
    }

}
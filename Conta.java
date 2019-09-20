import java.util.ArrayList;
import java.util.Random;

public class Conta {
    private String agencia;
    private String conta;
    private double saldo;
    private ArrayList<Operacao> extrato;

    public Conta() {
	    Random gerador = new Random();

        this.agencia = Integer.toString(gerador.nextInt(10000));
        this.conta = Integer.toString(gerador.nextInt(10000));
        this.saldo = 0;
        this.extrato = new ArrayList<Operacao>();
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta() {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if(saldo >= valor) {
            this.saldo -= valor;
        }
        else {
            System.out.println("O saldo disponível em conta é menor que o valor de saque desejado.");
        }
    }

    public ArrayList<Operacao> getExtrato() {
        return extrato;
    }

    public void addOperacao(Operacao operacao) {
        extrato.add(operacao);
    }
}
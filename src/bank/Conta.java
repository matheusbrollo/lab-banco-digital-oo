package bank;

import java.util.Scanner;

public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected String nome;
    protected String email;
    protected int agencia;
    protected int numero;
    protected double saldo;

    Scanner scanner = new Scanner(System.in);

    public Conta(Client client) {
        this.nome = client.getNome();
        this.email = client.getEmail();
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
    }

    public void sacar(double valor) {
        saldo -= valor;
        System.out.printf("\nSaldo atual: R$%.2f", saldo);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("\nSaldo atual: R$%.2f", saldo);
    }

    public void transferir(double valor, String contaDestino) {
        saldo -= valor;
        System.out.printf("\nR$%.2f transferido para a conta de: %s", valor, contaDestino);
        System.out.printf("\nSaldo atual: R$%.2f", saldo);
    }

    public void obterSaldo() {
        System.out.printf("Seu saldo é de R$%.2f", getSaldo());
    }

    public void obterDadosDaConta() {
        System.out.printf("\nNome do usuário: %s", getNome());
        System.out.printf("\nEmail: %s", getEmail());
        System.out.printf("\nNumero da conta: %d", getNumero());
        System.out.printf("\nAgência: %d", getAgencia());
    }

    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

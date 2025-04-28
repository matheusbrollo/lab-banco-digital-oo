package bank;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "usuario='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}

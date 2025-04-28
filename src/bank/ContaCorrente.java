package bank;

public class ContaCorrente extends Conta{
    public ContaCorrente(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "usuario='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }


}

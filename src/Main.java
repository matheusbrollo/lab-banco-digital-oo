import bank.Client;
import bank.Conta;
import bank.ContaCorrente;
import bank.ContaPoupanca;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Client newCLient;
    private static Conta newAccount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean creationMenu = true;
        boolean userMenu = false;

        while (creationMenu){
            System.out.println("\n===  Menu ===");
            System.out.println("1 - Criar uma nova conta.");
            System.out.println("2 - Sair.");
            System.out.println("Escolha uma opção!");

            String opcao = scanner.nextLine().trim();
            if (opcao.isEmpty()) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            switch (opcao) {
                case "1":
                    criarNovaConta(scanner);
                    System.out.println("\nAperte Enter para continuar...");
                    scanner.nextLine();
                    creationMenu = false;
                    userMenu = true;
                    break;
                case "2":
                    creationMenu = false;
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        while (userMenu) {
            System.out.println("\nMenu");
            System.out.println("1 - Consultar saldo.");
            System.out.println("2 - Depositar dinheiro.");
            System.out.println("3 - Sacar dinheiro.");
            System.out.println("4 - Realizar Tranferência.");
            System.out.println("5 - Dados da conta.");
            System.out.println("6 - Sair.");
            System.out.println("Escolha uma opção!");

            String opcao2 = scanner.nextLine().trim();
            if (opcao2.isEmpty()) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            switch (opcao2) {
                case "1":
                    newAccount.obterSaldo();
                    scanner.nextLine();
                    break;
                case "2":
                    newAccount.depositar(lerValor(scanner));
                    System.out.println("\nAperte Enter para continuar...");
                    scanner.nextLine();
                    break;
                case "3":
                    newAccount.sacar(lerValor(scanner));
                    System.out.println("\nAperte Enter para continuar...");
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Por favor, informe a quantia que deseja tranferir:");
                    newAccount.transferir(lerValor(scanner), lerNome(scanner));
                    System.out.println("\nAperte Enter para continuar...");
                    scanner.nextLine();
                    break;
                case "5":
                    newAccount.obterDadosDaConta();
                    System.out.println("\nAperte Enter para continuar...");
                    scanner.nextLine();
                    break;
                case "6":
                    userMenu = false;
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static String lerNome(Scanner scanner) {
        System.out.println("Digite o nome do destinatário:");
        return scanner.nextLine().trim(); // Apenas uma leitura
    }

    private static double lerValor(Scanner scanner) {
        System.out.println("Digite o valor:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer
        return valor;
    }

    private static void criarNovaConta(Scanner scanner) {
        String nome;
        String email;
        do {
            System.out.println("\nDigite o seu nome: ");
            nome = scanner.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro: O nome não pode ser vazio. Por favor, digite um nome válido.");
            }
        } while (nome.isEmpty());

        do {
            System.out.println("\nDigite o seu email: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Erro: O email não pode ser vazio. Por favor, digite um email válido.");
            }
        } while (email.isEmpty());

        Client newCLient = new Client(nome, email);

        boolean creationAccount = true;
        while (creationAccount){
            System.out.println("\n=== Menu ===");
            System.out.println("Qual tipo de conta você deseja criar?");
            System.out.println("1 - Conta Corrente.");
            System.out.println("2 - Conta Poupança.");
            System.out.println("Escolha uma opção!");

            String opcao = scanner.nextLine().trim();
            if (opcao.isEmpty()) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            switch (opcao) {
                case "1":
                    creationAccount = false;
                    newAccount = new ContaCorrente(newCLient);
                    System.out.println("\n=== CONTA CORRENTE CRIADA COM SUCESSO ===");
                    System.out.println("Nome: " + newAccount.getNome());
                    System.out.println("Agência: " + newAccount.getAgencia());
                    System.out.println("Número da Conta: " + newAccount.getNumero());
                    System.out.println("Saldo inicial: R$" + String.format("%.2f", newAccount.getSaldo()));
                    break;
                case "2":
                    creationAccount = false;
                    newAccount = new ContaPoupanca(newCLient);
                    System.out.println("\n=== CONTA POUPANÇA CRIADA COM SUCESSO ===");
                    System.out.println("Nome: " + newAccount.getNome());
                    System.out.println("Agência: " + newAccount.getAgencia());
                    System.out.println("Número da Conta: " + newAccount.getNumero());
                    System.out.println("Saldo inicial: R$" + String.format("%.2f", newAccount.getSaldo()));
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
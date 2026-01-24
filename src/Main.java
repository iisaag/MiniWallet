import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Olá, Isabelli!");
        System.out.println("Entre com o seu salário: ");
        double salario = Double.parseDouble(scan.nextLine());

        Carteira wallet = new Carteira(salario);

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Adicionar gasto");
            System.out.println("2 - Listar gastos");
            System.out.println("3 - Ver saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1 -> {
                    Gasto gasto = criarGasto(scan);
                    wallet.adicionarGasto(gasto);
                    System.out.println("Gasto adicionado com sucesso!");
                }
                case 2 -> wallet.listarGastos();
                case 3 -> System.out.println("Saldo atual: R$ " + wallet.getSaldoDisponivel());
                case 4 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }

        scan.close();
    }

    private static Gasto criarGasto(Scanner scan) {
        System.out.print("* Valor: ");
        float valor = Float.parseFloat(scan.nextLine());

        System.out.println("* Escolha uma categoria:");
        System.out.println("1 - Alimentação");
        System.out.println("2 - Contas");
        System.out.println("3 - Lazer");
        System.out.println("4 - Transporte");
        System.out.println("5 - Farmácia");
        System.out.println("6 - Investimentos");
        System.out.println("7 - Outros");

        int categoria = scan.nextInt();
        scan.nextLine();

        String nomeCategoria = switch (categoria) {
            case 1 -> "Alimentação";
            case 2 -> "Contas";
            case 3 -> "Lazer";
            case 4 -> "Transporte";
            case 5 -> "Farmácia";
            case 6 -> "Investimentos";
            default -> "Outros";
        };

        System.out.print("Descrição: ");
        String descricao = scan.nextLine();

        return new Gasto(valor, nomeCategoria, descricao);
    }
}

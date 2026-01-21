import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Olá, Isabelli!");
        System.out.println("Entre com o seu salário: ");
        double salario = Double.parseDouble(scan.nextLine());

        Carteira carteira = new Carteira(salario);

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
                    carteira.adicionarGasto(gasto);
                    System.out.println("Gasto adicionado com sucesso!");
                }
                case 2 -> carteira.listarGastos();
                case 3 -> System.out.println("Saldo atual: R$ " + carteira.getSaldoDisponivel());
                case 4 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }

        scan.close();
    }

    private static Gasto criarGasto(Scanner scan) {
        System.out.print("* Valor:");
        float valor = Float.parseFloat(scan.nextLine());

        System.out.println("* Escolha uma categoria: \n 1 - Alimentação \n 2 - Contas \n 3 - Lazer \n 4 - Transporte \n 5 - Farmácia \n 6 - Investimentos \n 7 - Outros");
        int categoria = scan.nextInt();
        String nomeCategoria = switch (categoria) {
            case 1 -> "Alimentação";
            case 2 -> "Contas";
            case 3 -> "Lazer";
            case 4 -> "Transporte";
            case 5 -> "Farmácia";
            case 6 -> "Investimentos";
            default -> "Outros";
        };

        scan.nextLine(); // consumir quebra de linha
        System.out.println("Descrição:");
        String descricao = scan.nextLine();

        System.out.println("Novo gasto criado!");
        return new Gasto(valor, nomeCategoria, descricao);
    }
}

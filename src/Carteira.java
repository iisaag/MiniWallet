import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private double salario;
    private List<Gasto> gastos;

    public Carteira(double salario) {
        this.salario = salario;
        this.gastos = new ArrayList<>();
    }

    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public double calcularTotalGastos() {
        double total = 0;
        for (Gasto gasto : gastos) {
            total += gasto.getValor();
        }
        return total;
    }

    public double getSaldoDisponivel() {
        return salario - calcularTotalGastos();
    }

    public void listarGastos() {
        if (gastos.isEmpty()) {
            System.out.println("Nenhum gasto registrado.");
        } else {
            System.out.println("Lista de Gastos:");
            for (Gasto gasto : gastos) {
                System.out.println("- " + gasto.getDescricao() + ": R$ " + gasto.getValor());
            }
        }
    }
}

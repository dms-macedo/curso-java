package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionaisExercicio {
    public static void main(String[] args) {
        //Exercicio decidindo quanto de taxa deve ser aplicado ao produto.

        double salarioAnual = 40000;
        double taxa;

        if (salarioAnual <= 34712){
            taxa = 9.70 / 100;
        } else if (salarioAnual <= 68507) {
            taxa = 37.35 / 100;
        } else {
            taxa = 49.50 / 100;
        }

        double salarioComTaxa = salarioAnual - (salarioAnual * taxa);
        String taxaPorcentagem = (taxa * 100) + "%";
        String relatorioSeMaiorQueZero = "Salário Anual sem Taxa: R$" + (float) salarioAnual + " | Taxa Aplicada: " + taxaPorcentagem + " | Salário Anual com Taxas: R$" + (float) salarioComTaxa;
        String relatorio = salarioAnual < 0 || salarioAnual == 0 ? "Salário Inválido! (salário menor ou igual a 0)" : relatorioSeMaiorQueZero;

        System.out.println(relatorio);

    }
}

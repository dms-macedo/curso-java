package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao04 {
    public static void main(String[] args) {
        // Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado
        // Condição ValorParcela >= 1000

        double valorCarro = 50000;

        for (int parcela = 1; parcela <= valorCarro; parcela++) {
            double valorParcela = valorCarro / parcela;

            if (valorParcela >= 1000) {
                System.out.println("Parcelas: " + parcela + " | Valor da Parcela: R$" + valorParcela);
            } else {
                break;
            }
        }
    }
}

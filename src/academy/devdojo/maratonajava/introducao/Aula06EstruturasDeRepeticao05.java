package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao05 {
    public static void main(String[] args) {
        double valorCarro = 50000;
        for (int parcela = 50000; parcela >= 1; parcela--) {
            double valorParcela = valorCarro / parcela;

            if(valorParcela < 1000) {
                continue; // volta para o comeco do for até que a condição for false. logo após continua o for inteiro
            }

            System.out.println("Parcela: " + parcela + " | Valor da Parcela: R$" + valorParcela);
        }
    }
}

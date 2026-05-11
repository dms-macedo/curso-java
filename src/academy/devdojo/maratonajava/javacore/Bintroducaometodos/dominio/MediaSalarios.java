package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class MediaSalarios {
    public void media(Funcionario funcionario) {
        double[] salariosCalc = funcionario.getSalarios();

        if (salariosCalc.length == 0){
            System.out.println("Sem salários para calcular média!");
        } else {
            double soma = 0;
            for (double salario : salariosCalc) {
                soma += salario;
            }

            double media = soma / salariosCalc.length;

            System.out.println("Média dos Salários: " + "R$" + media);
            System.out.println("====================");
        }
    }
}

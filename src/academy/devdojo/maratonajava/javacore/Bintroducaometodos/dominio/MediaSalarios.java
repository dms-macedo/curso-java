package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class MediaSalarios {
    public void media(Funcionario funcionario) {
        if (funcionario.salarios == null){
            System.out.println("Sem salários para calcular média!");
        } else {
            double soma = 0;
            for (double salario : funcionario.salarios) {
                soma += salario;
            }

            double media = soma / funcionario.salarios.length;

            System.out.println("Média dos Salários: " + "R$" + media);
            System.out.println("====================");
        }
    }
}

package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.MediaSalarios;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        MediaSalarios mediaSalario =  new MediaSalarios();

        funcionario.nome = "Davi";
        funcionario.idade = 18;
        funcionario.salarios = new double[]{1515, 1800, 2100};

        funcionario.imprimir();
        mediaSalario.media(funcionario);

    }

}

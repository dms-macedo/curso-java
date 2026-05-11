package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.MediaSalarios;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        MediaSalarios mediaSalario =  new MediaSalarios();

        funcionario.setNome("Davi");
        funcionario.setIdade(18);
        funcionario.setSalarios(new double []{1512, 1800, 2590, 3400});

        funcionario.imprimir();
        mediaSalario.media(funcionario);

    }

}

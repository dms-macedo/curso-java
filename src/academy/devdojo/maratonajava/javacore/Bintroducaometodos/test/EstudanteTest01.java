package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        Estudante estudante02 = new Estudante();

        ImpressoraEstudante impressoraEstudante = new ImpressoraEstudante();

        estudante.nome = "Pedro";
        estudante.sexo = 'M';
        estudante.idade = 17;

        estudante02.nome = "Rafaela";
        estudante02.sexo = 'F';
        estudante02.idade = 29;

        impressoraEstudante.Imprime(estudante);
        impressoraEstudante.Imprime(estudante02);

        System.out.println("Nome: " + estudante.nome);
        System.out.println("Idade: " + estudante.idade);
        System.out.println("Sexo: " + estudante.sexo);

        System.out.println("=============================");

        System.out.println("Nome: " + estudante02.nome);
        System.out.println("Idade: " + estudante02.idade);
        System.out.println("Sexo: " + estudante02.sexo);


    }
}

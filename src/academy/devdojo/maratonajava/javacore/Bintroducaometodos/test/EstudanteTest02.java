package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        Estudante estudante02 = new Estudante();

        estudante.nome = "Pedro";
        estudante.sexo = 'M';
        estudante.idade = 17;

        estudante02.nome = "Rafaela";
        estudante02.sexo = 'F';
        estudante02.idade = 29;

        estudante.imprime();
        estudante02.imprime();
    }
}

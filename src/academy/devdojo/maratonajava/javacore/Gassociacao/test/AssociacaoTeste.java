package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominioExercicio.Aluno;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominioExercicio.Local;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominioExercicio.Professor;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominioExercicio.Seminario;

public class AssociacaoTeste {
    public static void main(String[] args) {
        Local local = new Local("Centro - MG");
        Aluno aluno = new Aluno("Luffy", 17);
        Aluno[] alunos = {};
        Professor professor = new Professor("Barba Branca", "pirata");
        Seminario seminario = new Seminario("Onde achar o One Piece", alunos, local);

        Seminario[] seminarios = {seminario};
        professor.setSeminarios(seminarios);

        professor.imprime();
    }
}

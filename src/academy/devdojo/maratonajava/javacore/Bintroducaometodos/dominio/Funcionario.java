package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Funcionario {
    public String nome;
    public int idade;
    public double[] salarios;

    public void imprimir(){
        System.out.println("====================");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("====================");
        if (salarios == null) {
            System.out.println("Sem Salários!");
        } else {
            for (int i = 0; i < salarios.length; i++) {
                System.out.println("Salario: " + "R$" + salarios[i]);
            }
        }
        System.out.println("====================");
    }
}

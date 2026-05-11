package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Funcionario {
    private String nome;
    private int idade;
    private double[] salarios;

    public void imprimir(){
        System.out.println("====================");
        if (this.nome == null && this.idade >= 18) {
            System.out.println("Nome não declarado.");
            System.out.println("Idade: " + this.idade);
        } else if (this.nome != null && this.idade < 18){
            System.out.println("Nome: " + this.nome);
            System.out.println("Idade não declarada.");
        } else if (this.nome == null){
            System.out.println("Nome não declarado.");
            System.out.println("Idade não declarada.");
        } else {
            System.out.println("Nome: " + this.nome);
            System.out.println("Idade: " + this.idade);  
        }
        System.out.println("====================");
        if (salarios == null) {
            System.out.println("Sem Salários!");
        } else {
            for (int i = 0; i < salarios.length; i++) {
                int salariosOrder = i + 1;
                System.out.println("Salario " + salariosOrder + ": " + "R$" + this.salarios[i]);
            }
        }
        System.out.println("====================");
    }

    public void setIdade(int idade) {
        if (idade < 0){
            System.out.println("Erro: A idade não pode ser negativa.");
            return;
        } else if (idade < 18){
            System.out.println("Erro: Menor de Idade.");
            return;
        }

        this.idade = idade;
    }

    public void setSalarios(double[] salarios) {
        if (salarios == null){
            System.out.println("Erro: Salários não podem ser nulos.");
            return;
        }

        for (double salario : salarios){
            if (salario < 0){
                System.out.println("Erro: Salários não podem ser negativos.");
                return;
            }
        }

        this.salarios = salarios.clone();
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            System.out.println("Erro: Nome em branco ou é nulo.");
            return;
        }

        this.nome = nome;
    }

    public String getNome() {
        if (nome == null) {
            return "Nome não declarado.";
        }

        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public double[] getSalarios() {
        if (this.salarios == null){
            return new double[0];
        }

        return this.salarios.clone();
    }
}

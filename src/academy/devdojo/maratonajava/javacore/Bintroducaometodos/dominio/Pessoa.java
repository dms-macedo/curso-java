package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Pessoa {
    private String nome;
    private int idade;

    public void imprime(){
        if (this.idade == 0 && this.nome == null){
            System.out.println("Nome e idade não declarados");
            return;
        } else if (this.idade == 0 && this.nome != null){
            System.out.println("Nome: " + this.nome);
            System.out.println("Idade não declarada.");
            return;
        } else if (this.idade != 0 && this.nome == null){
            System.out.println("Idade: " + this.idade);
            System.out.println("Nome não declarado.");
            return;
        }
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        if (idade < 0){
            System.out.println("Idade Inválida.");
            return;
        }
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }
}

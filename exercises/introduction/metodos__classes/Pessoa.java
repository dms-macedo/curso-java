package introduction.metodos__classes;

public class Pessoa {
    private String nome;
    private int idade;
    private char sexo;
    private int pontos;
    private String status;
    private int salario;

    //Setters:

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()){
            this.nome = nome;
            return;
        }
        System.out.println("O nome está vazio ou em branco.");
    }

    public void setIdade(int idade) {
        if (idade == 0){
            System.out.println("Idade Inválida! (É zero!)");
            return;
        } else if (idade < 0){
            System.out.println("Idade Inválida! (Idade Negativa!)");
            return;
        }
        this.idade = idade;
    }

    public void setSexo(char sexo) {
        if (sexo != 'M' || sexo != 'F'){
            System.out.println("Sexo inválido!");
            return;
        }

        this.sexo = sexo;
    }

    public void setPontos(int pontos) {
        if (pontos < 0){
            System.out.println("Quantidade de pontos inválida! (Pontos Negativos)");
            return;
        }

        this.pontos = pontos;
    }

    public void setStatus(int pontos) {
        if (pontos == 0){
            this.status = "Desempregado";
            return;
        } else if (pontos < 0){
            System.out.println("Pontos Inválidos! (Pontos negativos)");
            return;
        } else if (pontos == 1){
            this.status = "Novato";
            return;
        } else if (pontos > 1000){
            this.status = "Júnior";
            return;
        }
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    //Getters:


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public int getPontos() {
        return pontos;
    }

    public String getStatus() {
        return status;
    }

    public int getSalario() {
        return salario;
    }
}

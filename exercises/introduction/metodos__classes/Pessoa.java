package introduction.metodos__classes;

public class Pessoa {
    private String nome;
    private int idade;
    private char sexo;
    private int pontos;
    private String status;
    private double salario;

    //Setters:

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
            return;
        }
        System.out.println("O nome está vazio ou em branco.");
    }

    public void setIdade(int idade) {
        if (idade < 18) {
            System.out.println("Idade Inválida! Motivo: Menor de Idade.");
            return;
        } else if (idade < 0){
            System.out.println("Idade Inválida! Motivo: Idade negativa.");
        }
        this.idade = idade;
    }

    public void setSexo(char sexo) {
        if (sexo != 'M' && sexo != 'F') {
            System.out.println("Sexo inválido!");
            return;
        }

        this.sexo = sexo;
    }

    public void setPontos(int pontos) {
        if (pontos < 0) {
            System.out.println("Quantidade de pontos inválida! (Pontos Negativos)");
            return;
        }

        this.pontos = pontos;
    }

    public void setStatus(int pontos) {
        if (pontos < 0) {
            System.out.println("Pontos Inválidos! (Pontos negativos)");
            return;
        }

        if (pontos == 0) {
            this.status = "Desempregado";
        } else if (pontos >= 100000) {
            this.status = "CEO";
        } else if (pontos >= 10000) {
            this.status = "Sênior";
        } else if (pontos >= 5000) {
            this.status = "Pleno";
        } else if (pontos >= 1000) {
            this.status = "Júnior";
        } else {
            this.status = "Novato";
        }
    }

    public void setSalario(String status, double porcentagemBonus){
        if (status == null || status.trim().isEmpty()){
            System.out.println("Erro! Status do funcionário é nulo ou está em branco.");
            return;
        }

        double salarioBase = 0;

        switch (status) {
            case "Desempregado":
                salarioBase = 0;
                break;
            case "Novato":
                salarioBase = 1512;
                break;
            case "Júnior":
                salarioBase = 2500;
                break;
            case "Pleno":
                salarioBase = 5670;
                break;
            case "Sênior":
                salarioBase = 10500;
                break;
            case "CEO":
                salarioBase = 33550;
                break;
            default:
                System.out.println("Erro! Salario Desconhecido: " + status);
                return;
        }

        double valorBonus = salarioBase * (porcentagemBonus / 100);
        this.salario = salarioBase + valorBonus;
    }

    public void setSalario(String status){
        setSalario(status, 0.0);
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

    public double getSalario() {
        return salario;
    }
}

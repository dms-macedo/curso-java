package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    public static void main(String[] args) {
        // Operadores Aritméticos
        // + - / *
        // % resto da divisão
        int numero1 = 10;
        int numero2 = 20;
        int resultado = numero1 + numero2;
        System.out.println(resultado);

        int resto = 20 % 2;
        System.out.println(resto);

        // Operadores Relacionais
        // < > <= >= == != (Sempre retornam true ou false)
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualVinte = 10 == 20;
        boolean isDezIgualDez = 10 == 10;
        boolean isDezDiferenteDez = 10 != 10;
        System.out.println("isDezMaiorQueVinte: " + isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte: " + isDezMenorQueVinte);
        System.out.println("isDezIgualVinte: " + isDezIgualVinte);
        System.out.println("isDezIgualDez: " + isDezIgualDez);
        System.out.println("isDezDiferenteDez: " + isDezDiferenteDez);

        //Operadores Lógicos
        // && (AND) || (or) ! (negação) (Retornam true ou false)
        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;
        System.out.println("isDentroDaLeiMaiorQueTrinta " + isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta " + isDentroDaLeiMenorQueTrinta);
    }

}
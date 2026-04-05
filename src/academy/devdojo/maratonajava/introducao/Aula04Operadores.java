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

        System.out.println("isDentroDaLeiMaiorQueTrinta: " + isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta: " + isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPlaystation = 5000F;
        boolean isPlaystationCincoCompravel = valorTotalContaCorrente > valorPlaystation || valorTotalContaPoupanca > valorPlaystation;

        System.out.println("isPlaystationCincoCompravel: " + isPlaystationCincoCompravel);

        // Operadores de Atribuição
        // = += -= *= /= %=

        double bonus = 1800;
        bonus += 1000;
        bonus -= 1000;
        bonus *= 2;
        bonus /= 2;
        bonus %= 2;
        System.out.println("bonus: " + bonus);

        int contador = 0;
        contador += 1; // Mesma coisa que contador = contador + 1 // contador = 1
        contador++; // Mesma coisa que contador += 1 e contador = contador + 1 // contador = 2
        contador--; // Mesma coisa que contador -= 1 e contador = contador - 1 // contador = 1
        ++contador; // contador = 2
        --contador; // contador = 1
        System.out.println(contador);

        // Diferença de ++ e -- antes e depois de "contador":
            // Quando colocado antes, ele vai somar ou subtrair 1 a variável e depois executar o que tiver que ser executado com ela (no caso println)
            // Quando colocado depois, a variavel será executada e depois somado 1
            // Exemplo:
                int contador2 = 0;
                System.out.println(contador2++); //retorna 0, pois foi executaod o println antes de somar 1 a variável
                System.out.println(contador2); //retorna 1, pois foi adicionado 1 na linha de cima após a execução do print da variável
                System.out.println(++contador2); //retorna 2, pois foi adicionado 1 a variavel e depois ela foi executada
    }

}
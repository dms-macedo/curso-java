package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais03 {
    public static void main(String[] args) {

        double salario = 3000;
        String mensagemDoar = "Eu vou dar 500 reais pro DevDojo";
        String mensagemNaoDoar = "Sem condições para doação.";
        String resultado;

        if (salario > 5000) {
            resultado = mensagemDoar;
        } else {
            resultado = mensagemNaoDoar;
        } // Jeito padrão, o caso é simples pode ser feito usando operador ternário, veja abaixo:

        System.out.println(resultado);

        double salario2 = 3000;
        String mensagemDoar2 = "Eu vou dar 500 reais pro DevDojo - Ternário";
        String mensagemNaoDoar2 = "Sem condições para doação - Ternário";
        // Sintaxe: (condicao) ? verdadeiro : falso
        String resultado2 = salario2 > 5000 ? mensagemDoar2 : mensagemNaoDoar2;

        System.out.println(resultado2);
    }
}

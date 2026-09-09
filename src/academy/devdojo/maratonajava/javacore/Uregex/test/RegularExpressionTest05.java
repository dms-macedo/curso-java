package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest05 {
    public static void main(String[] args) {
        /*
            \d = todos os dígitos
            \D = tudo o que não for digito
            \s = todos os espaços em branco \t \n \f \r
            \S = todos os caracteres excluindo os brancos
            \w = a-Z, A-Z, dígitos, _
            \W = tudo que não for incluído no \w
            [] = os caracteres que estiverem dentro de colchetes serão procurados.
            ? = zero ou uma ocorrência
            * = zero, ou mais ocorrências
            + = uma, ou mais ocorrências
            {n, m} = de n até m ocorrências
            () = agrupamento
            | = OU
            $ = fim da linha
            . = Coringa
            ^ = pega tudo que está dentro do que for passado no começo da linha, termina quando algo fora do conjunto é a próxima letra. Pode ser de negação quando usado em [].
         */
        String regex = "^\\w+";
        String texto1 = "Davi joao maria jose pedro";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto1);

        System.out.println("Email: davimacedo@icddd.coq é válido? " + "davimacedo@icddd.coq".matches(regex));

        System.out.println("texto:                                      " + texto1);
        System.out.println("índice:                                     0123456789");
        System.out.println("regex:                                      " + regex);
        System.out.print("Posições Encontradas:                       ");
        while (matcher.find()){
            System.out.print("< " + matcher.start() + " | " + matcher.group() + " > ");
        }

        int numeroHexaDecimal = 0x44AA200;
    }
}
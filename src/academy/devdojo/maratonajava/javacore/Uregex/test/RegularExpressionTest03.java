package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest03 {
    public static void main(String[] args) {
        /*
            \d = todos os dígitos
            \D = tudo o que não for digito
            \s = todos os espaços em branco \t \n \f \r
            \S = todos os caracteres excluindo os brancos
            \w = a-Z, A-Z, dígitos, _
            \W = tudo que não for incluído no \w
            [] = os caracteres que estiverem dentro de colchetes serão procurados.
         */
        String regex = "0[xX][0-9a-fA-F]";
        String texto1 = "0xFFABC 0x 0X 0X119 0X1 0x22";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto1);

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
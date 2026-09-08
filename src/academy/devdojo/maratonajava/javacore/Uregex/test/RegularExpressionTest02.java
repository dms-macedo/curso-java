package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest02 {
    public static void main(String[] args) {
        /*
            \d = todos os dígitos
            \D = tudo o que não for digito
            \s = todos os espaços em branco \t \n \f \r
            \S = todos os caracteres excluindo os brancos
            \w = a-Z, A-Z, dígitos, _
            \W = tudo que não for incluido no \w
         */
        String regex = "\\W";
        String texto1 = "a@d jwyh 7 8 2__ q187 523617*3_ 4c";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto1);

        System.out.println("texto:                                      " + texto1);
        System.out.println("indice:                                     0123456789");
        System.out.println("regex:                                      " + regex);
        System.out.print("Posicões Encontradas:                       ");
        while (matcher.find()){
            System.out.print("< " + matcher.start() + " | " + matcher.group() + " > ");
        }
    }
}

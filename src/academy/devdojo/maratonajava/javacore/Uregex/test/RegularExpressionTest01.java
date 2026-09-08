package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest01 {
    public static void main(String[] args) {
        String regex = "ab";
        String texto1 = "abababab";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto1);

        System.out.println("texto:                                      " + texto1);
        System.out.println("indice:                                     0123456789");
        System.out.println("regex:                                      " + regex);
        System.out.print("Posicões Encontradas:                       ");
        while (matcher.find()){
            System.out.print(matcher.start() + " | ");
        }
    }
}

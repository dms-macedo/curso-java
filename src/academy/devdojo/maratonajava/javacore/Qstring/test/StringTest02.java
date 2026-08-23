package academy.devdojo.maratonajava.javacore.Qstring.test;

import java.util.Locale;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "                                Luffy";
        String nums = "0123456";

        System.out.println(nome.charAt(0));
        System.out.println(nome.length());
        System.out.println(nome.replace('f', 'l'));
        System.out.println(nome.toLowerCase());
        System.out.println(nome.toUpperCase());
        System.out.println(nome.trim());

        System.out.println(nums.length());
        System.out.println(nums.substring(0, 3)); //1 parâmetro: onde começa, 2 parâmetro: onde termina (index de onde termina tem que ser um a mais ao própio index).
    }
}

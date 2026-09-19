package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.SmartPhone;

public class EqualsTest01 {
    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone("1k1k1k1", "Iphone");
        SmartPhone s2 = s1;

        System.out.println(s1.equals(s2));
    }
}

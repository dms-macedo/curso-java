package academy.devdojo.maratonajava.javacore.Uregex.test;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Davi João 200 true";
        String[] valores = texto.split(" ");
        for (String valor : valores) {
            System.out.println(valor);
        }

    }
}

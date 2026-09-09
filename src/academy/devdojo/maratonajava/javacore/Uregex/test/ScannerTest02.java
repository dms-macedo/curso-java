package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        String texto = "Davi João 200 true";

        Scanner sc = new Scanner(texto);
        while (sc.hasNext()){
            if (sc.hasNextInt()){
                System.out.println("int: " + sc.nextInt());
            } else if (sc.hasNextBoolean()){
                System.out.println("Boolean: " + sc.nextBoolean());
            } else {
                System.out.println(sc.next());
            }
        }
    }
}

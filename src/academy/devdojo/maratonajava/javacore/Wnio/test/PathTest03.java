package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest03 {
    public static void main(String[] args) {
        Path dir = Paths.get("home/davi");
        Path arquivo = Paths.get("dev/arquivo.txt");

//        System.out.println(dir.resolve(arquivo));

        Path absoluto = Paths.get("/home/davi");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("arquivo.txt");

        System.out.println("1 " + absoluto.resolve(relativo));
        System.out.println("2 " + absoluto.resolve(file));
        System.out.println("3 " + absoluto.resolve(relativo).resolve(file));
        System.out.println("4 " + relativo.resolve(absoluto));
        System.out.println("5 " + relativo.resolve(file));
        System.out.println("6 " + relativo.resolve(absoluto).resolve(file));
        System.out.println("7 " + file.resolve(absoluto));
        System.out.println("8 " + file.resolve(relativo));
        System.out.println("9 " + file.resolve(relativo).resolve(file));
        System.out.println("10 " + file.resolve(absoluto).resolve(file));
    }
}

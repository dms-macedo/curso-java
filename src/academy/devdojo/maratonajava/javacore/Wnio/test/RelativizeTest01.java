package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) {
        Path path = Paths.get("/home/davi");
        Path classFile = Paths.get("/home/davi/joaozao/OlaMundo.java");
        System.out.println(path.relativize(classFile));

        Path absoluto1 = Paths.get("/home/davi");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/davi/joaozao/OlaMundo.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/temp.2202103");

        System.out.println("1 " + absoluto1.relativize(absoluto3));
        System.out.println("2 " + absoluto3.relativize(absoluto1));
        System.out.println("3 " + absoluto3.relativize(absoluto2));
        System.out.println("4 " + relativo1.relativize(relativo2));

    }
}

package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        Path p1 = Paths.get("/home/dms_macedo/IdeaProjects/curso-java/pasta2");
        Path p2 = Paths.get("home", "dms_macedo/IdeaProjects/curso-java/pasta2");
        Path p3 = Paths.get("/home/dms_macedo/IdeaProjects/curso-java/", "pasta2");
        Path p4 = Paths.get("home","dms_macedo", "IdeaProjects", "curso-java", "pasta2");

        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());

    }
}

package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path p1 = Paths.get("pasta/file.txt");
        Path p2 = Paths.get("pasta/file.java");
        Path p3 = Paths.get("pasta/file2.py");

        String glob = "glob:**/*.java";
        String glob2 = "glob:**/*.{txt,java,py}";
        String glob3 = "glob:**/file.{txt,java,py}";
        String glob4 = "glob:**/file.???";

        matches(p1, glob);
        matches(p2, glob);
        matches(p3, glob);

        matches(p1, glob2);
        matches(p2, glob2);
        matches(p3, glob2);

        matches(p1, glob3);
        matches(p2, glob3);
        matches(p3, glob3);

        matches(p1, glob4);
        matches(p2, glob4);
        matches(p3, glob4);
    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}

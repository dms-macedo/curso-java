package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path subpasta = Paths.get("pasta/subpasta/subsubpasta");
        Path subpastaCreated = Files.createDirectories(subpasta);

    }
}

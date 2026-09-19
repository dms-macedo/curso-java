package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllTestFiles extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String glob = "glob:**/*.{java,class}";
        if(file.getFileName().toString().contains("Test") && matches(file, glob)){
            System.out.println("    | " + file.getFileName());
        }

        return FileVisitResult.CONTINUE;
    }

    private static boolean matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        return matcher.matches(path);
    }
}

public class PathMatcherTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        System.out.println("Todos os Arquivos que contém Test no nome e terminam em .java ou .class:");
        Files.walkFileTree(path, new ListAllTestFiles());
    }
}

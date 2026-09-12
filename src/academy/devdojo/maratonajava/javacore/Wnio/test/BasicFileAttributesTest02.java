package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("home/davi/dev/new.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime modifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println("creationTime " + creationTime);
        System.out.println("modifiedTime " + modifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);

        System.out.println("-------------------");

        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        FileTime newAcessTime = FileTime.fromMillis(System.currentTimeMillis());
        basicFileAttributeView.setTimes(creationTime, newAcessTime, modifiedTime);

        creationTime = basicFileAttributeView.readAttributes().creationTime();
        modifiedTime = basicFileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = basicFileAttributeView.readAttributes().lastAccessTime();

        System.out.println("creationTime " + creationTime);
        System.out.println("modifiedTime " + modifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);
    }
}

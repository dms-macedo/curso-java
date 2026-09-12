package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        File file = new File("home/davi/dev/novo_arquivo.txt");
        boolean isCreated = file.createNewFile();
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        Path path = Paths.get("home/davi/dev/novo_path.txt");
        date = LocalDateTime.now().plusDays(30);
        Files.createFile(path);
        FileTime time = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, time);
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isHidden(path));
        System.out.println(Files.isExecutable(path));
    }
}

package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFIleAttributesTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("home/davi/dev/teste.txt");
        if (Files.notExists(path)) Files.createFile(path);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        boolean hidden = dosFileAttributes.isHidden();
        boolean readOnly = dosFileAttributes.isReadOnly();

        System.out.println("É oculto? " + hidden);
        System.out.println("É apenas para leitura? " + readOnly);

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(true);
        fileAttributeView.setReadOnly(true);

        hidden = fileAttributeView.readAttributes().isHidden();
        readOnly = fileAttributeView.readAttributes().isReadOnly();

        System.out.println("É oculto? " + hidden);
        System.out.println("É apenas para leitura? " + readOnly);
    }
}

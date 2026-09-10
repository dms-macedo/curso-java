package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File folder = new File("folder");
        boolean isFolderCreated = folder.mkdir();
        System.out.println("A pasta foi criada? " + isFolderCreated);

        File file = new File(folder, "arquivo.txt");
        boolean isFileCreated = file.createNewFile();
        System.out.println("O arquivo foi criado? " + isFileCreated);

        File fileRenamed = new File(folder, "arquivo_renomeado.txt");
        boolean isFileRenamed = file.renameTo(fileRenamed);
        System.out.println("arquivo.txt foi renomeado? " + isFileRenamed);

        File folderRenamed = new File("pasta2");
        boolean isFolderRenamed = folder.renameTo(folderRenamed);
        System.out.println("A pasta foi renomeada? " + isFolderRenamed);
    }
}

package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.html");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Arquivo Criado: " + isCreated);
            System.out.println("Caminho: " + file.getPath());
            System.out.println("Caminho Absoluto: " + file.getAbsolutePath());
            System.out.println("É um diretório? " + file.isDirectory());
            System.out.println("É um arquivo? " + file.isFile());
            System.out.println("Está escondido? " + file.isHidden());

            DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime lastModified = Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            String dateFormat = lastModified.format(formatterBR);
            System.out.println("Última modificação: " + dateFormat);

            boolean exists = file.exists();
            if(exists){
                boolean isDeleted = file.delete();
                System.out.println("Arquivo Deletado: " + isDeleted);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("texto.txt");

        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("oyo ooyo parabéns para o arroyo");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

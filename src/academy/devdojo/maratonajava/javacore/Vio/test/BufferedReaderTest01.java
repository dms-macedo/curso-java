package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.*;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
        File file = new File("texto.txt");

        try (FileReader fr = new FileReader(file); BufferedReader bf = new BufferedReader(fr)){

            String linha;
            while ((linha = bf.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

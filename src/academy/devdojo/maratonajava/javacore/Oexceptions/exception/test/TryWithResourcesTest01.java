package academy.devdojo.maratonajava.javacore.Oexceptions.exception.test;

import academy.devdojo.maratonajava.javacore.Oexceptions.exception.dominio.Leitor1;
import academy.devdojo.maratonajava.javacore.Oexceptions.exception.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo();
    }

    private static void lerArquivo() {
        try(Leitor1 leitor1 = new Leitor1();
            Leitor2 leitor2 = new Leitor2()){

        } catch (IOException e){

        }
    }
}

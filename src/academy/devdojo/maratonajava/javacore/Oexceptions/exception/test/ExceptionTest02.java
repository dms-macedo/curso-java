package academy.devdojo.maratonajava.javacore.Oexceptions.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest02 {
    public static void main(String[] args){
        criarNovoArquivo();
    }

    public static void criarNovoArquivo(){
        File file = new File("arquivos\\teste.txt");
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo Criado.");
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar o arquivo.");
        }
    }

}

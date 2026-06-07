package academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.dominio;

import java.io.Closeable;
import java.io.IOException;

public class ConexaoLog implements AutoCloseable {
    @Override
    public void close() throws IOException {
        System.out.println("Fechando conexão com os logs do sistema.");
    }
}
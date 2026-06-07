package academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.test;

import academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.dominio.ConexaoLog;
import academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.dominio.ServidorJogo;
import academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.exceptions.NickInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.exceptions.ServidorLotadoException;

import java.io.IOException;

public class ServidorMain {
    static ServidorJogo servidor = new ServidorJogo();

    public static void main(String[] args) {
        conectarTratado("Davi");
        conectarTratado("Maria");
        conectarTratado("João");
    }

    private static void conectarTratado(String nome) {
        try (ConexaoLog conexaoLog = new ConexaoLog()) {
            servidor.conectar(nome);
        } catch (ServidorLotadoException | NickInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Tentativa de conexão finalizada. Jogadores logados: " + servidor.getJogadoresConectados() + " players.");
        }
    }
}

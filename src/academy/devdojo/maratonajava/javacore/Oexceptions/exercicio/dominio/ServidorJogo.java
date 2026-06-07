package academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.dominio;

import academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.exceptions.NickInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexceptions.exercicio.exceptions.ServidorLotadoException;

public class ServidorJogo {
    private int limiteJogadores = 2;
    private int jogadoresConectados = 0;

    public void conectar(String nick) throws ServidorLotadoException {
        if (nick == null || nick.length() <= 3){
            throw new NickInvalidoException("ERRO: O Nick deve ter mais de 3 caracteres e não pode ser nulo.");
        } else if (jogadoresConectados >=  limiteJogadores){
            throw new ServidorLotadoException("ERRO: Servidor lotado, tente novamente mais tarde.");
        }

        jogadoresConectados++;
        System.out.println("Sucesso! Jogador '" + nick + "' conectado.");
    }

    public int getLimiteJogadores() {
        return limiteJogadores;
    }

    public int getJogadoresConectados() {
        return jogadoresConectados;
    }
}

package academy.devdojo.maratonajava.javacore.Oexceptions.exception.dominio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Funcionario extends Pessoa{

    public void salvar() throws LoginInvalidoException{
        System.out.println("Salvando funcionario");
    }
}

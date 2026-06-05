package academy.devdojo.maratonajava.javacore.Oexceptions.exception.test;

import academy.devdojo.maratonajava.javacore.Oexceptions.exception.dominio.LoginInvalidoException;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException {
        Scanner sc = new Scanner(System.in);
        String usernameDB = "Goku";
        String senhaDB = "ssj";
        System.out.print("Digite seu nome: ");
        String usernameDigitado = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senhaDigitado = sc.nextLine();

        if(!usernameDB.equals(usernameDigitado) || !senhaDB.equals(senhaDigitado)){
            throw new LoginInvalidoException("Usuário ou senha inválido.");
        }

        System.out.println("Bem Vindo! Usuário logado.");
    }
}

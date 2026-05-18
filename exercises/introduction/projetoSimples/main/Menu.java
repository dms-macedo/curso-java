package introduction.projetoSimples.main;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0){
            System.out.println("============================[ SPACE GAME CENTER ]============================\n");
            System.out.println("=> Selecione uma opção abaixo:");
            System.out.println("    | 1 - Cadastrar nova Desenvolvedora;");
            System.out.println("    | 2 - Cadastrar novo Jogo;");
            System.out.println("    | 3 - Cadastrar Cliente;");
            System.out.println("    | 4 - Adicionar saldo ao Cliente;");
            System.out.println("    | 5 - Comprar jogo para Cliente;");
            System.out.println("    | 6 - Listar todos os Jogos do Sistema;");
            System.out.println("    | 7 - Ver perfil de um Cliente;");
            System.out.println("    | 8 - Sair.");
            
        }
    }
}

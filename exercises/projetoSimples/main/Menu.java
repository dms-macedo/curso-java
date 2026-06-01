package projetoSimples.main;

import projetoSimples.dominios.*;
import projetoSimples.dominios.MenuController;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        System.out.println("\n============================[ SPACE GAME CENTER ]============================");
        System.out.println("=> Selecione uma opção abaixo:");
        System.out.println("    | 1 - Cadastrar nova Desenvolvedora;");
        System.out.println("    | 2 - Cadastrar novo Jogo;");
        System.out.println("    | 3 - Cadastrar Cliente;");
        System.out.println("    | 4 - Adicionar saldo ao Cliente;");
        System.out.println("    | 5 - Comprar jogo para Cliente;");
        System.out.println("    | 6 - Listar todos os Jogos do sistema;");
        System.out.println("    | 7 - Ver perfil de um Cliente;");
        System.out.println("    | 8 - Sair.");

        while (opcao != 8) {
            System.out.print("=> Digite sua opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Opção Inválida. Digite apenas números.");
                MenuController.esperar(2);
                continue;
            }

            if (opcao == 1) {
                MenuController.cadastrarDesenvolvedora(sc);
            } else if (opcao == 2) {
                MenuController.cadastrarJogo(sc);
            } else if (opcao == 3) {
                MenuController.cadastrarCliente(sc);
            } else if (opcao == 4) {
                MenuController.adicionarSaldoCliente(sc);
            } else if (opcao == 5) {
                MenuController.comprarJogo(sc);
            } else if (opcao == 6) {
                MenuController.listarJogos();
            } else if (opcao == 7){
                MenuController.PerfilCliente(sc);
            } else if (opcao == 8){
                System.out.println("\nEncerrando conexão com o Banco de Dados...");
                MenuController.esperar(1.5);
                System.out.println("Servidores do Space Game Center desligados. Até logo!");
                MenuController.esperar(1);
                break;
            } else {
                System.out.println("ERRO: Opção inválida.");
                MenuController.esperar(2);
            }
        }

        sc.close();
    }
}
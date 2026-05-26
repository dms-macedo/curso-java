package introduction.projetoSimples.main;

import introduction.projetoSimples.dominios.*;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 8) {
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
            System.out.print("=> Digite sua opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Opção Inválida. Digite apenas números.");
                MenuController.esperar(2);
                continue;
            }

            if (opcao == 8) {
                System.out.println("\nEncerrando conexão com o Banco de Dados...");
                MenuController.esperar(1.5);
                System.out.println("Servidores do Space Game Center desligados. Até logo!");
                MenuController.esperar(1);
                break;
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
                System.out.println("\n=> Clientes Disponíveis:\n");
                Cliente[] clientes = BancoDeDados.getClientes();
                for (int i = 0; i < clientes.length; i++) {
                    if (clientes[i] != null) {
                        System.out.println("| " + (i + 1) + " - " + clientes[i].getNickname());
                    }
                }

                System.out.print("\n=> Digite o nome do Cliente que deseja fazer a compra: ");
                String nomeCliente = sc.nextLine();

                System.out.println("\nVerificando credenciais do cliente...");
                esperar(1.5);

                Cliente cliente = BancoDeDados.buscarClientePorNome(nomeCliente);

                if (cliente == null) {
                    System.out.println("ERRO: '" + nomeCliente + "' não encontrado no sistema. Cadastre um cliente primeiro (Opção 3).");
                    esperar(3);
                continue;
            }

            System.out.println("\n=> Jogos disponíveis para compra:\n");
            Jogo[] jogos = BancoDeDados.getJogos();
            for (Jogo jogo : jogos) {
                if (jogo != null) {
                    System.out.println("=> Nome: " + jogo.getNome() + " | ID: " + jogo.getId() + " | Desenvolvedora: " + jogo.getDesenvolvedora().getNome());
                }
            }

            System.out.print("\n=> Digite o NOME ou ID do jogo desejado: ");
            String jogoNomeID = sc.nextLine();

            System.out.println("\nConsultando catálogo de jogos...");
                esperar(1.5);

                Jogo jogo;
                try {
                    int jogoID = Integer.parseInt(jogoNomeID);
                    jogo = BancoDeDados.buscarJogoPorID(jogoID);
                } catch (NumberFormatException e) {
                    jogo = BancoDeDados.buscarJogoPorNome(jogoNomeID);
                }

                if (jogo == null) {
                    System.out.println("ERRO: '" + jogoNomeID + "' não encontrado no sistema. Registre um novo jogo primeiro (Opção 2).");
                    esperar(3);
                    continue;
                }

                System.out.println("Conectando ao gateway de pagamento...");
                esperar(2);
                cliente.comprarJogo(jogo);
                System.out.println("Retornando ao menu principal...");
                esperar(2.5);
            } else if (opcao == 6) {
                System.out.println("\nSincronizando com o Banco de Dados...\n");
                esperar(1.5);

                System.out.println("=> Jogos no sistema:\n");
                Jogo[] jogos = BancoDeDados.getJogos();

                System.out.println("+---------------------------+--------+---------------+---------------------------+");
                System.out.printf("| %-25s | %-6s | %-13s | %-25s |\n", "NOME DO JOGO", "ID", "PREÇO", "DESENVOLVEDORA");
                System.out.println("+---------------------------+--------+---------------+---------------------------+");

                for (Jogo jogo : jogos) {
                    if (jogo != null) {
                        System.out.printf("| %-25s | %-6d | R$ %-10.2f | %-25s |\n",
                                jogo.getNome(),
                                jogo.getId(),
                                jogo.getPreco(),
                                jogo.getDesenvolvedora().getNome());
                    }
                }
                System.out.println("+---------------------------+--------+---------------+---------------------------+");
                esperar(5);
            } else if (opcao == 7) {
                // Seu terreno para brilhar e terminar o código!
                System.out.println("\nImplementação em progresso...");
                esperar(2);
            } else {
                System.out.println("\nERRO: Opção inválida ou ainda não implementada.");
                esperar(2);
            }
        }

        sc.close();
    }
}
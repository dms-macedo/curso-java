package introduction.projetoSimples.main;

import introduction.projetoSimples.dominios.BancoDeDados;
import introduction.projetoSimples.dominios.Cliente;
import introduction.projetoSimples.dominios.Desenvolvedora;
import introduction.projetoSimples.dominios.Jogo;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void esperar(double segundos) {
        try {
            Thread.sleep((long) (segundos * 1000D));
        } catch (InterruptedException e) {
            System.out.println("Ocorreu um erro na espera do sistema.");
        }
    }

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
            System.out.print("=> Digite sua opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Opção Inválida. Digite apenas números.");
                opcao = -1;
                esperar(2);
                continue;
            }

            System.out.println();

            if (opcao == 1){
                System.out.print("Digite o nome da Desenvolvedora: ");
                String nome = sc.nextLine();
                System.out.print("Deseja atribuir uma nacionalidade á Desenvolvedora? [S/N]: ");
                String opcaoNacao = sc.nextLine().trim();
                if (opcaoNacao.equalsIgnoreCase("S") || opcaoNacao.equalsIgnoreCase("SIM") || opcaoNacao.equalsIgnoreCase("SS")){
                    System.out.print("Digite a nacionalidade: ");
                    String nacao = sc.nextLine();

                    Desenvolvedora desenvolvedora = new Desenvolvedora(nome, nacao);
                    esperar(1);
                    BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                    esperar(1);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else if (opcaoNacao.equalsIgnoreCase("N") || opcaoNacao.equalsIgnoreCase("NN") || opcaoNacao.equalsIgnoreCase("NAO") || opcaoNacao.equalsIgnoreCase("NÃO")) {
                    System.out.println("Cadastrando Desenvolvedora sem Nacionalidade...");

                    Desenvolvedora desenvolvedora = new Desenvolvedora(nome);
                    esperar(1);
                    BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                    esperar(1);
                    System.out.println("Retornando ao menu principal.");
                    esperar(2);
                } else {
                    System.out.println("ERRO: Digite apenas S para SIM ou N para NÃO.");
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                }
            } else if (opcao == 2){
                System.out.print("Digite o nome do Jogo: ");
                esperar(1);
                String nome = sc.nextLine();

                double preco = 0;
                while(true){
                    System.out.print("Digite o preço do Jogo: ");
                    String precoTexto = sc.nextLine();
                    precoTexto = precoTexto.replace(",", ".");

                    try {
                        preco = Double.parseDouble(precoTexto);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Digite apenas números.");
                    }
                }

                System.out.print("Digite a Desenvolvedora do Jogo: ");
                esperar(1);
                String nomeDev = sc.nextLine();
                Desenvolvedora desenvolvedora = BancoDeDados.buscarDesenvolvedoraPorNome(nomeDev);

                if (desenvolvedora == null){
                    System.out.println("ERRO: A Desenvolvedora: " + nomeDev + " não existe. Cadastre uma nova Desenvolvedora na opção 1. ");
                    esperar(1);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                    continue;
                }

                Jogo jogo = new Jogo(nome, preco, desenvolvedora);
                esperar(1);
                BancoDeDados.salvarJogo(jogo);
                esperar(1);
                System.out.println("Retornando ao menu principal....");
                esperar(2);
            } else if (opcao == 3){
                System.out.print("Digite o nome do Cliente: ");
                String nome = sc.nextLine();

                Cliente cliente = new Cliente(nome);
                esperar(1);
                BancoDeDados.salvarCliente(cliente);
                esperar(1);
                System.out.println("Retornando ao menu principal...");
                esperar(2);
            } else if (opcao == 4){
                System.out.println("=> Clientes disponíveis para adicionar saldo: ");
                Cliente[] clientes = BancoDeDados.getClientes();

                for (int i = 0; i < clientes.length; i++) {
                    int posicao = i + 1;

                    if(clientes[i] != null){
                        System.out.println(posicao + " - " + clientes[i].getNickname());
                    }
                }

                System.out.print("\n=> Digite o nome do cliente para depósito: ");
                String nome = sc.nextLine();

                Cliente cliente = BancoDeDados.buscarClientePorNome(nome);
                if(cliente == null) {
                    System.out.println("ERRO: Cliente: " + nome + " não existe. Cadastre um cliente primeiro (Opção 3).");
                    esperar(1);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                    continue;
                }

                double valor = 0;
                while (true){
                    System.out.print("Digite o valor a ser adicionado: ");
                    String valorTexto = sc.nextLine().replace(",", ".");

                    try {
                        valor = Double.parseDouble(valorTexto);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Digite apenas números.");
                    }

                }

                System.out.println("Deseja adicionar um código promocional? [S/N]");
                String opcaoCode = sc.nextLine().trim();

                if(opcaoCode.equalsIgnoreCase("S") || opcaoCode.equalsIgnoreCase("SIM") || opcaoCode.equalsIgnoreCase("SS")){
                    System.out.println("Digite o código promocional: ");
                    String codigo = sc.nextLine();

                    esperar(1);
                    cliente.adicionarSaldo(valor, codigo);
                    esperar(1);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else if (opcaoCode.equalsIgnoreCase("N") || opcaoCode.equalsIgnoreCase("NN") || opcaoCode.equalsIgnoreCase("NAO") || opcaoCode.equalsIgnoreCase("NÃO")){
                    cliente.adicionarSaldo(valor);
                    esperar(1);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else {
                    System.out.println("ERRO: Digite apenas sim ou não.");
                    esperar(1);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                }
            } else if (opcao == 5){
                Jogo[] jogos = BancoDeDados.getJogos();

                System.out.println("=> Jogos disponíveis para compra: ");
                for (int i = 0; i < jogos.length; i++) {
                    if (jogos[i] != null){
                        System.out.println(">>> - Nome: " + jogos[i].getNome() + " | ID: " + jogos[i].getId() + " | Desenvolvedora: " + jogos[i].getDesenvolvedora().getNome());
                    }
                }

                esperar(1);
                System.out.print("\n=> Digite o nome ou ID do jogo desejado: ");
                String jogoNomeID = sc.nextLine();

                 Jogo jogo = null;
                 try {
                     int jogoID = Integer.parseInt(jogoNomeID);
                     jogo = BancoDeDados.buscarJogoPorID(jogoID);
                 } catch (NumberFormatException e){
                     jogo = BancoDeDados.buscarJogoPorNome(jogoNomeID);
                 }

                 if (jogo == null){
                     System.out.println("ERRO: " + jogoNomeID + " não encontrado no sistema, registree um novo jogo primeiro. (Opção 2)");
                     esperar(2);
                     continue;
                 }

                Cliente[] clientes = BancoDeDados.getClientes();
                System.out.println("=> Clientes Disponíveis:");
                for (int i = 0; i < clientes.length; i++) {
                    if (clientes[i] != null){
                        int posicao = i + 1;
                        System.out.println("| " + posicao + " - " + jogos[i].getNome());
                    }
                }
            }
        }
    }
}

package introduction.projetoSimples.main;

import introduction.projetoSimples.dominios.BancoDeDados;
import introduction.projetoSimples.dominios.Cliente;
import introduction.projetoSimples.dominios.Desenvolvedora;
import introduction.projetoSimples.dominios.Jogo;

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
                esperar(2);
                continue;
            }

            if (opcao == 8) {
                System.out.println("\nEncerrando conexão com o Banco de Dados...");
                esperar(1.5);
                System.out.println("Servidores do Space Game Center desligados. Até logo!");
                esperar(1);
                break;
            }

            if (opcao == 1) {
                System.out.print("\nDigite o nome da Desenvolvedora: ");
                String nome = sc.nextLine();

                System.out.print("Deseja atribuir uma nacionalidade à Desenvolvedora? [SIM/NÃO]: ");
                String opcaoNacao = sc.nextLine().trim();

                if (opcaoNacao.equalsIgnoreCase("S") || opcaoNacao.equalsIgnoreCase("SIM") || opcaoNacao.equalsIgnoreCase("SS")) {
                    System.out.print("Digite a nacionalidade: ");
                    String nacao = sc.nextLine();

                    System.out.println("\nConectando à API para salvar dados...");
                    esperar(1.5);

                    Desenvolvedora desenvolvedora = new Desenvolvedora(nome, nacao);
                    BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else if (opcaoNacao.equalsIgnoreCase("N") || opcaoNacao.equalsIgnoreCase("NN") || opcaoNacao.equalsIgnoreCase("NAO") || opcaoNacao.equalsIgnoreCase("NÃO")) {
                    System.out.println("\nConectando à API para salvar dados sem Nacionalidade...");
                    esperar(1.5);

                    Desenvolvedora desenvolvedora = new Desenvolvedora(nome);
                    BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else {
                    System.out.println("\nERRO: Digite apenas SIM ou NÃO.");
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                }
            } else if (opcao == 2) {
                System.out.print("\nDigite o nome do Jogo: ");
                String nome = sc.nextLine();

                double preco = 0;
                while (true) {
                    System.out.print("Digite o preço do Jogo: ");
                    String precoTexto = sc.nextLine().replace(",", ".");

                    try {
                        preco = Double.parseDouble(precoTexto);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Digite apenas números.");
                    }
                }

                System.out.print("Digite a Desenvolvedora do Jogo: ");
                String nomeDev = sc.nextLine();

                System.out.println("\nBuscando Desenvolvedora no sistema...");
                esperar(1.5); // Simula o tempo de busca no banco

                Desenvolvedora desenvolvedora = BancoDeDados.buscarDesenvolvedoraPorNome(nomeDev);

                if (desenvolvedora == null) {
                    System.out.println("ERRO: A Desenvolvedora '" + nomeDev + "' não existe. Cadastre uma nova Desenvolvedora na opção 1.");
                    esperar(3);
                    continue;
                }

                System.out.println("Desenvolvedora encontrada! Salvando novo jogo...");
                esperar(1);

                Jogo jogo = new Jogo(nome, preco, desenvolvedora);
                BancoDeDados.salvarJogo(jogo);
                System.out.println("Retornando ao menu principal...");
                esperar(2);
            } else if (opcao == 3) {
                System.out.print("\nDigite o nome do Cliente: ");
                String nome = sc.nextLine();

                System.out.println("\nRegistrando novo cliente na base de dados...");
                esperar(1.5); // Simula o tempo de salvamento

                Cliente cliente = new Cliente(nome);
                BancoDeDados.salvarCliente(cliente);
                System.out.println("Retornando ao menu principal...");
                esperar(2);
            } else if (opcao == 4) {
                System.out.println("\n=> Clientes disponíveis para adicionar saldo:\n");
                Cliente[] clientes = BancoDeDados.getClientes();

                for (int i = 0; i < clientes.length; i++) {
                    if (clientes[i] != null) {
                        System.out.println((i + 1) + " - " + clientes[i].getNickname());
                    }
                }

                System.out.print("\n=> Digite o nome do cliente para depósito: ");
                String nome = sc.nextLine();

                System.out.println("\nBuscando registro do cliente...");
                esperar(1.5);

                Cliente cliente = BancoDeDados.buscarClientePorNome(nome);
                if (cliente == null) {
                    System.out.println("ERRO: Cliente '" + nome + "' não existe. Cadastre um cliente primeiro (Opção 3).");
                    esperar(3);
                    continue;
                }

                double valor = 0;
                while (true) {
                    System.out.print("Digite o valor a ser adicionado: ");
                    String valorTexto = sc.nextLine().replace(",", ".");

                    try {
                        valor = Double.parseDouble(valorTexto);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Digite apenas números.");
                    }
                }

                System.out.print("Deseja adicionar um código promocional? [SIM/NÃO]: ");
                String opcaoCode = sc.nextLine().trim();

                System.out.println("\nValidando transação com a operadora...");
                esperar(1.5);

                if (opcaoCode.equalsIgnoreCase("S") || opcaoCode.equalsIgnoreCase("SIM") || opcaoCode.equalsIgnoreCase("SS")) {
                    System.out.print("Digite o código promocional: ");
                    String codigo = sc.nextLine();

                    System.out.println("\nAplicando código...");
                    esperar(1);

                    cliente.adicionarSaldo(valor, codigo);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else if (opcaoCode.equalsIgnoreCase("N") || opcaoCode.equalsIgnoreCase("NN") || opcaoCode.equalsIgnoreCase("NAO") || opcaoCode.equalsIgnoreCase("NÃO")) {
                    cliente.adicionarSaldo(valor);
                    System.out.println("Retornando ao menu principal...");
                    esperar(2);
                } else {
                    System.out.println("ERRO: Digite apenas SIM ou NÃO.");
                    esperar(2);
                }
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
                System.out.println("\nSincronizando com o Banco de Dados...");
                esperar(1.5); // Pausa dramática para parecer que está puxando uma lista pesada

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
    }
}
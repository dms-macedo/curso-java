package introduction.projetoSimples.dominios;

import java.util.Scanner;

public class MenuController {
    public static void esperar(double segundos) {
        try {
            Thread.sleep((long) (segundos * 1000D));
        } catch (InterruptedException e) {
            System.out.println("Ocorreu um erro na espera do sistema.");
        }
    }

    public static void cadastrarDesenvolvedora(Scanner sc) {
        System.out.print("\nDigite o nome da Desenvolvedora: ");
        String nome = sc.nextLine();

        while (true) {
            System.out.print("Deseja atribuir uma nacionalidade à Desenvolvedora? [SIM/NÃO]: ");
            String opcaoNacao = sc.nextLine().trim();

            if (opcaoNacao.equalsIgnoreCase("S") || opcaoNacao.equalsIgnoreCase("SIM") || opcaoNacao.equalsIgnoreCase("SS")) {
                System.out.print("Digite a nacionalidade: ");
                String nacao = sc.nextLine();

                System.out.println("\nConectando à API para salvar dados...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nome, nacao);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(2);
                break;
            } else if (opcaoNacao.equalsIgnoreCase("N") || opcaoNacao.equalsIgnoreCase("NN") || opcaoNacao.equalsIgnoreCase("NAO") || opcaoNacao.equalsIgnoreCase("NÃO")) {
                System.out.println("\nConectando à API para salvar dados sem Nacionalidade...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nome);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(2);
                break;
            } else {
                System.out.println("\nERRO: Digite apenas SIM ou NÃO.");
                esperar(2);
            }
        }
    }

    public static void cadastrarDesenvolvedora(Scanner sc, String nomeDevPreDefinido) {
        System.out.println("\nContinuando cadastro da Desenvolvedora '" + nomeDevPreDefinido + "'...");

        while (true) {
            System.out.print("Deseja atribuir uma nacionalidade à Desenvolvedora? [SIM/NÃO]: ");
            String opcaoNacao = sc.nextLine().trim();

            if (opcaoNacao.equalsIgnoreCase("S") || opcaoNacao.equalsIgnoreCase("SIM") || opcaoNacao.equalsIgnoreCase("SS")) {
                System.out.print("Digite a nacionalidade: ");
                String nacao = sc.nextLine();

                System.out.println("\nConectando à API para salvar dados...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nomeDevPreDefinido, nacao);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(2);
                break;

            } else if (opcaoNacao.equalsIgnoreCase("N") || opcaoNacao.equalsIgnoreCase("NN") || opcaoNacao.equalsIgnoreCase("NAO") || opcaoNacao.equalsIgnoreCase("NÃO")) {
                System.out.println("\nConectando à API para salvar dados sem Nacionalidade...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nomeDevPreDefinido);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(2);
                break;

            } else {
                System.out.println("\nERRO: Digite apenas SIM ou NÃO.");
                esperar(2);
            }
        }
    }

    public static void cadastrarJogo(Scanner sc) {
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

        while (true) {
            System.out.print("Digite a Desenvolvedora do Jogo: ");
            String nomeDev = sc.nextLine();

            System.out.println("\nBuscando Desenvolvedora no sistema...");
            esperar(1.5); // Simula o tempo de busca no banco

            Desenvolvedora desenvolvedora = BancoDeDados.buscarDesenvolvedoraPorNome(nomeDev);

            if (desenvolvedora != null) {
                System.out.println("Desenvolvedora encontrada! Salvando novo jogo...");
                esperar(1);

                Jogo jogo = new Jogo(nome, preco, desenvolvedora);
                BancoDeDados.salvarJogo(jogo);
                esperar(2);
            }

            while (true) {
                int opcao = -1;
                System.out.println("ERRO: A Desenvolvedora '" + nomeDev + "' não existe.\n  | 1 - Cadastrar nova Desenvolvedora (" + nomeDev + ");\n    | 2 - Tentar Novamente;\n   | 3 - Cancelar e Sair.");
                System.out.print("=> Escolha uma opção: ");

                try {
                    opcao = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção Inválida. Digite apenas números.");
                    esperar(2);
                    continue;
                }

                if (opcao == 1) {
                    cadastrarDesenvolvedora(sc, nomeDev);
                    desenvolvedora = BancoDeDados.buscarDesenvolvedoraPorNome(nomeDev);

                    if (desenvolvedora == null) {
                        System.out.println("ERRO CRÍTICO: Falha ao carregar a Desenvolvedora. O Banco pode estar cheio.");
                        esperar(2);
                        return;
                    }

                    System.out.println("Desenvolvedora criada e encontrada! Salvando novo jogo...");
                    esperar(1);

                    Jogo jogo = new Jogo(nome, preco, desenvolvedora);
                    BancoDeDados.salvarJogo(jogo);
                    return;
                } else if (opcao == 2) {
                    esperar(1);
                    break;
                } else if (opcao == 3){
                    System.out.println("Operação Cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção Inválida.");
                    esperar(2);
                }
            }
        }
    }

    public static void cadastrarCliente(Scanner sc) {
        System.out.print("\nDigite o nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.println("\nRegistrando novo cliente na base de dados...");
        esperar(1.5);
\
        Cliente cliente = new Cliente(nome);
        BancoDeDados.salvarCliente(cliente);
        esperar(2);
    }

    public static void cadastrarCliente(String nomePreDefinido) {

        System.out.println("\nRegistrando novo cliente na base de dados...");
        esperar(1.5);
\
        Cliente cliente = new Cliente(nomePreDefinido);
        BancoDeDados.salvarCliente(cliente);
        esperar(2);
    }

    public static void adicionarSaldoCliente(Scanner sc) {
        Cliente[] clientes = BancoDeDados.getClientes();

        boolean ifCliente = false;
        for (Cliente value : clientes) {
            if (value != null) {
                ifCliente = true;
                break;
            }
        }

        if (!ifCliente) {
            while (true) {
                System.out.println("ERRO: Nenhum cliente registrado. Deseja cadastrar um cliente? [SIM/NÃO]: ");
                String opcaoCliente = sc.nextLine().trim();

                if (opcaoCliente.equalsIgnoreCase("S") || opcaoCliente.equalsIgnoreCase("SIM") || opcaoCliente.equalsIgnoreCase("SS")) {
                    cadastrarCliente(sc);
                    System.out.println("Cliente cadastrado!\n");
                    clientes = BancoDeDados.getClientes();
                    break;
                } else if (opcaoCliente.equalsIgnoreCase("N") || opcaoCliente.equalsIgnoreCase("NN") || opcaoCliente.equalsIgnoreCase("NAO") || opcaoCliente.equalsIgnoreCase("NÃO")) {
                    System.out.println("Operação cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Digite apenas SIM ou NÃO.");
                    esperar(2);
                }
            }
        }

        System.out.println("\n=> Clientes disponíveis para adicionar saldo:\n");

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println((i + 1) + " - " + clientes[i].getNickname());
            }
        }

        while (true){
            System.out.print("\n=> Digite o nome do cliente para depósito: ");
            String nome = sc.nextLine();

            System.out.println("\nBuscando registro do cliente...");
            esperar(1.5);

            Cliente cliente = BancoDeDados.buscarClientePorNome(nome);

            if (cliente != null){
                System.out.println("Cliente Encontrado.");
                break;
            }

            while (true) {
                int opcao = -1;
                System.out.println("ERRO: Cliente '" + nome + "' não encontrado.\n  | 1 - Cadastrar novo Cliente (" + nome + ");\n    | 2 - Tentar Novamente;\n   | 3 - Cancelar e Sair.");
                System.out.print("=> Escolha uma opção: ");

                try {
                    opcao = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção Inválida. Digite apenas números.");
                    esperar(2);
                    continue;
                }

                if (opcao == 1) {
                    cadastrarCliente(nome);
                    cliente = BancoDeDados.buscarClientePorNome(nome);

                    if (cliente == null) {
                        System.out.println("ERRO: Falha ao carregar cliente. O Banco pode estar cheio, retornando ao menu principal...");
                        esperar(2);
                        return;
                    }
                } else if (opcao == 2) {
                    esperar(1);
                    break;
                } else if (opcao == 3){
                    System.out.println("Operação Cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção Inválida.");
                    esperar(2);
                }
            }
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

        while (true) {
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
                break;
            } else if (opcaoCode.equalsIgnoreCase("N") || opcaoCode.equalsIgnoreCase("NN") || opcaoCode.equalsIgnoreCase("NAO") || opcaoCode.equalsIgnoreCase("NÃO")) {
                cliente.adicionarSaldo(valor);
                System.out.println("Retornando ao menu principal...");
                esperar(2);
                break;
            } else {
                System.out.println("ERRO: Digite apenas SIM ou NÃO.");
                esperar(2);
            }
        }
    }
}

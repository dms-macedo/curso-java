package projetoSimples.dominios;

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
        String nome;

        while (true) {
            System.out.print("\n=> Digite o nome da Desenvolvedora: ");
            nome = sc.nextLine();

            if (BancoDeDados.buscarDesenvolvedoraPorNome(nome) != null) {
                int opcao;

                System.out.println("ERRO: Já existe uma desenvolvedora com o nome '" + nome + "' no sistema.");
                System.out.println("  | 1 - Tentar novamente.");
                System.out.println("  | 2 - Cancelar e Sair.");

                while (true) {
                    System.out.print("=> Selecione uma opção: ");

                    try {
                        opcao = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Opção inválida. Digite apenas números.");
                        esperar(1);
                        continue;
                    }

                    if (opcao == 1) {
                        break;
                    } else if (opcao == 2) {
                        System.out.println("Operação cancelada. Retornando ao menu principal...");
                        esperar(2);
                        return;
                    } else {
                        System.out.println("ERRO: Opção inválida.");
                        esperar(1);
                    }
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("=> Deseja atribuir uma nacionalidade à Desenvolvedora? [SIM/NÃO]: ");
            String opcaoNacao = sc.nextLine().trim();

            if (opcaoNacao.equalsIgnoreCase("S") || opcaoNacao.equalsIgnoreCase("SIM") || opcaoNacao.equalsIgnoreCase("SS")) {
                System.out.print("=> Digite a nacionalidade: ");
                String nacao = sc.nextLine();

                System.out.println("\nConectando à API para salvar dados...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nome, nacao);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(1.5);
                break;
            } else if (opcaoNacao.equalsIgnoreCase("N") || opcaoNacao.equalsIgnoreCase("NN") || opcaoNacao.equalsIgnoreCase("NAO") || opcaoNacao.equalsIgnoreCase("NÃO")) {
                System.out.println("\nConectando à API para salvar dados sem Nacionalidade...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nome);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(1.5);
                break;
            } else {
                System.out.println("ERRO: Digite apenas SIM ou NÃO.");
                esperar(1);
            }
        }
    }

    public static void cadastrarDesenvolvedora(Scanner sc, String nomeDevPreDefinido) {
        System.out.println("\nContinuando cadastro da Desenvolvedora '" + nomeDevPreDefinido + "'...");

        while (true) {
            System.out.print("=> Deseja atribuir uma nacionalidade à Desenvolvedora? [SIM/NÃO]: ");
            String opcaoNacao = sc.nextLine().trim();

            if (opcaoNacao.equalsIgnoreCase("S") || opcaoNacao.equalsIgnoreCase("SIM") || opcaoNacao.equalsIgnoreCase("SS")) {
                System.out.print("=> Digite a nacionalidade: ");
                String nacao = sc.nextLine();

                System.out.println("\nConectando à API para salvar dados...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nomeDevPreDefinido, nacao);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(1.5);
                break;

            } else if (opcaoNacao.equalsIgnoreCase("N") || opcaoNacao.equalsIgnoreCase("NN") || opcaoNacao.equalsIgnoreCase("NAO") || opcaoNacao.equalsIgnoreCase("NÃO")) {
                System.out.println("\nConectando à API para salvar dados sem Nacionalidade...");
                esperar(1.5);

                Desenvolvedora desenvolvedora = new Desenvolvedora(nomeDevPreDefinido);
                BancoDeDados.salvarDesenvolvedora(desenvolvedora);
                esperar(1.5);
                break;

            } else {
                System.out.println("ERRO: Digite apenas SIM ou NÃO.");
                esperar(1);
            }
        }
    }

    public static void cadastrarJogo(Scanner sc) {
        String nome;

        while (true) {
            System.out.print("\n=> Digite o nome do Jogo: ");
            nome = sc.nextLine();

            if (BancoDeDados.buscarJogoPorNome(nome) != null) {
                int opcao;
                System.out.println("ERRO: Já existe um jogo com o nome '" + nome + "' no sistema.");
                System.out.println("  | 1 - Tentar novamente.");
                System.out.println("  | 2 - Cancelar e Sair.");

                while (true) {
                    System.out.print("=> Selecione uma opção: ");
                    try {
                        opcao = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Opção inválida. Digite apenas números.");
                        esperar(1);
                        continue;
                    }

                    if (opcao == 1) {
                        break;
                    } else if (opcao == 2) {
                        System.out.println("Operação cancelada. Retornando ao menu principal...");
                        esperar(2);
                        return;
                    } else {
                        System.out.println("ERRO: Opção inválida.");
                        esperar(1);
                    }
                }
            } else {
                break;
            }
        }

        double preco;
        while (true) {
            System.out.print("=> Digite o preço do Jogo: ");
            String precoTexto = sc.nextLine().replace(",", ".");

            try {
                preco = Double.parseDouble(precoTexto);

                if (preco < 0) {
                    System.out.println("ERRO: O preço do jogo não pode ser negativo.");
                    esperar(1);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números.");
                esperar(1);
            }
        }

        while (true) {
            System.out.print("=> Digite a Desenvolvedora do Jogo: ");
            String nomeDev = sc.nextLine();

            System.out.println("\nBuscando Desenvolvedora no sistema...");
            esperar(1);

            Desenvolvedora desenvolvedora = BancoDeDados.buscarDesenvolvedoraPorNome(nomeDev);

            if (desenvolvedora != null) {
                System.out.println("Desenvolvedora encontrada! Salvando novo jogo...");
                esperar(1.5);

                Jogo jogo = new Jogo(nome, preco, desenvolvedora);
                BancoDeDados.salvarJogo(jogo);
                esperar(1.5);
                return;
            }

            while (true) {
                int opcao;
                System.out.println("ERRO: A Desenvolvedora '" + nomeDev + "' não existe.");
                System.out.println("  | 1 - Cadastrar nova Desenvolvedora (" + nomeDev + ");");
                System.out.println("  | 2 - Tentar Novamente;");
                System.out.println("  | 3 - Salvar jogo sem desenvolvedora;");
                System.out.println("  | 4 - Cancelar e Sair.");
                System.out.print("=> Selecione uma opção: ");

                try {
                    opcao = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção inválida. Digite apenas números.");
                    esperar(1);
                    continue;
                }

                if (opcao == 1) {
                    cadastrarDesenvolvedora(sc, nomeDev);
                    desenvolvedora = BancoDeDados.buscarDesenvolvedoraPorNome(nomeDev);

                    if (desenvolvedora == null) {
                        System.out.println("ERRO CRÍTICO: Falha ao carregar a Desenvolvedora. O Banco de Dados pode estar cheio.");
                        esperar(2);
                        return;
                    }

                    System.out.println("Desenvolvedora criada e encontrada! Salvando novo jogo...");
                    esperar(1.5);

                    Jogo jogo = new Jogo(nome, preco, desenvolvedora);
                    BancoDeDados.salvarJogo(jogo);
                    esperar(1.5);
                    return;
                } else if (opcao == 2) {
                    esperar(1);
                    break;
                } else if (opcao == 3) {
                    System.out.println("Salvando jogo como Desenvolvedor Independente...");
                    esperar(1.5);
                    Jogo jogo = new Jogo(nome, preco);
                    BancoDeDados.salvarJogo(jogo);
                    esperar(1.5);
                    return;
                } else if (opcao == 4) {
                    System.out.println("Operação cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção inválida.");
                    esperar(1);
                }
            }
        }
    }

    public static void cadastrarCliente(Scanner sc) {
        String nome;

        while (true) {
            System.out.print("\n=> Digite o nome do Cliente: ");
            nome = sc.nextLine();

            if (BancoDeDados.buscarClientePorNome(nome) != null) {
                int opcao;

                System.out.println("ERRO: Já existe um cliente com o nome '" + nome + "' no sistema.");
                System.out.println("  | 1 - Tentar novamente.");
                System.out.println("  | 2 - Cancelar e Sair.");

                while (true) {
                    System.out.print("=> Selecione uma opção: ");
                    try {
                        opcao = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Opção inválida. Digite apenas números.");
                        esperar(1);
                        continue;
                    }

                    if (opcao == 1) {
                        break;
                    } else if (opcao == 2) {
                        System.out.println("Operação cancelada. Retornando ao menu principal...");
                        esperar(2);
                        return;
                    } else {
                        System.out.println("ERRO: Opção inválida.");
                        esperar(1);
                    }
                }
            } else {
                break;
            }
        }

        System.out.println("\nRegistrando novo cliente na base de dados...");
        esperar(1.5);

        Cliente cliente = new Cliente(nome);
        BancoDeDados.salvarCliente(cliente);
        esperar(1.5);
    }

    public static void cadastrarCliente(String nomePreDefinido) {
        System.out.println("\nRegistrando novo cliente na base de dados...");
        esperar(1.5);

        Cliente cliente = new Cliente(nomePreDefinido);
        BancoDeDados.salvarCliente(cliente);
        esperar(1.5);
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
                System.out.println("ERRO: Nenhum cliente registrado no sistema.");
                System.out.println("  | 1 - Cadastrar novo cliente;");
                System.out.println("  | 2 - Cancelar e Sair.");
                System.out.print("=> Selecione uma opção: ");

                int opcaoCliente;
                try {
                    opcaoCliente = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção inválida. Digite apenas números.");
                    esperar(1);
                    continue;
                }

                if (opcaoCliente == 1) {
                    cadastrarCliente(sc);
                    System.out.println("Cliente cadastrado com sucesso!\n");
                    clientes = BancoDeDados.getClientes();
                    break;
                } else if (opcaoCliente == 2) {
                    System.out.println("Operação cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção inválida.");
                    esperar(1);
                }
            }
        }

        System.out.println("\n=> Clientes disponíveis para adicionar saldo:\n");
        System.out.println("+------+--------------------------------+");
        System.out.printf("| %-4s | %-30s |\n", "ID", "NOME DO CLIENTE");
        System.out.println("+------+--------------------------------+");
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.printf("| %-4d | %-30s |\n", (i + 1), clientes[i].getNickname());
            }
        }
        System.out.println("+------+--------------------------------+\n");

        Cliente cliente;
        while (true) {
            System.out.print("=> Digite o NOME ou ID do cliente para depósito: ");
            String inputBusca = sc.nextLine();

            System.out.println("\nBuscando registro do cliente...");
            esperar(1);

            cliente = null;
            try {
                int numero = Integer.parseInt(inputBusca);
                int index = numero - 1;
                if (index >= 0 && index < clientes.length && clientes[index] != null) {
                    cliente = clientes[index];
                }
            } catch (NumberFormatException e) {
                cliente = BancoDeDados.buscarClientePorNome(inputBusca);
            }

            if (cliente != null) {
                System.out.println("Cliente encontrado.");
                break;
            }

            boolean breakPointExterno = false;
            while (true) {
                int opcao;
                System.out.println("ERRO: Cliente '" + inputBusca + "' não encontrado.");
                System.out.println("  | 1 - Cadastrar novo Cliente (" + inputBusca + ");");
                System.out.println("  | 2 - Tentar Novamente;");
                System.out.println("  | 3 - Cancelar e Sair.");
                System.out.print("=> Selecione uma opção: ");

                try {
                    opcao = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção inválida. Digite apenas números.");
                    esperar(1);
                    continue;
                }

                if (opcao == 1) {
                    cadastrarCliente(inputBusca);
                    cliente = BancoDeDados.buscarClientePorNome(inputBusca);

                    if (cliente == null) {
                        System.out.println("ERRO CRÍTICO: Falha ao carregar cliente. O Banco de Dados pode estar cheio.");
                        esperar(2);
                        return;
                    }

                    breakPointExterno = true;
                    break;
                } else if (opcao == 2) {
                    esperar(1);
                    break;
                } else if (opcao == 3) {
                    System.out.println("Operação cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção inválida.");
                    esperar(1);
                }
            }

            if (breakPointExterno) {
                break;
            }
        }

        double valor;
        while (true) {
            System.out.print("=> Digite o valor a ser adicionado: ");
            String valorTexto = sc.nextLine().replace(",", ".");

            try {
                valor = Double.parseDouble(valorTexto);

                if (valor < 0) {
                    System.out.println("ERRO: O valor não pode ser negativo.");
                    esperar(1);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números.");
                esperar(1);
            }
        }

        while (true) {
            System.out.print("=> Deseja adicionar um código promocional? [SIM/NÃO]: ");
            String opcaoCode = sc.nextLine().trim();

            if (opcaoCode.equalsIgnoreCase("S") || opcaoCode.equalsIgnoreCase("SIM") || opcaoCode.equalsIgnoreCase("SS")) {
                System.out.print("=> Digite o código promocional: ");
                String codigo = sc.nextLine();

                System.out.println("\nValidando transação com a operadora...");
                esperar(1.5);
                System.out.println("Aplicando código...");
                esperar(1);

                cliente.adicionarSaldo(valor, codigo);
                System.out.println("Retornando ao menu principal...");
                esperar(2);
                break;
            } else if (opcaoCode.equalsIgnoreCase("N") || opcaoCode.equalsIgnoreCase("NN") || opcaoCode.equalsIgnoreCase("NAO") || opcaoCode.equalsIgnoreCase("NÃO")) {
                System.out.println("\nValidando transação com a operadora...");
                esperar(1.5);

                cliente.adicionarSaldo(valor);
                System.out.println("Retornando ao menu principal...");
                esperar(2);
                break;
            } else {
                System.out.println("ERRO: Digite apenas SIM ou NÃO.");
                esperar(1);
            }
        }
    }

    public static void comprarJogo(Scanner sc) {
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
                System.out.println("ERRO: Nenhum cliente registrado no sistema.");
                System.out.println("  | 1 - Cadastrar novo cliente;");
                System.out.println("  | 2 - Cancelar e Sair.");
                System.out.print("=> Selecione uma opção: ");

                int opcaoCliente;
                try {
                    opcaoCliente = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção inválida. Digite apenas números.");
                    esperar(1);
                    continue;
                }

                if (opcaoCliente == 1) {
                    cadastrarCliente(sc);
                    clientes = BancoDeDados.getClientes();
                    System.out.println("Cliente cadastrado com sucesso!\n");
                    System.out.println("Aviso: O novo cliente não tem fundos para comprar jogos.");
                    System.out.println("  | 1 - Adicionar saldo ao Cliente.");
                    System.out.println("  | 2 - Cancelar compra e sair.");

                    while (true) {
                        System.out.print("=> Selecione uma opção: ");

                        int opcaoSaldo;
                        try {
                            opcaoSaldo = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("ERRO: Digite apenas números.");
                            esperar(1);
                            continue;
                        }

                        if (opcaoSaldo == 1) {
                            adicionarSaldoCliente(sc);
                            break;
                        } else if (opcaoSaldo == 2) {
                            System.out.println("Operação cancelada. Retornando ao menu principal...");
                            esperar(2);
                            return;
                        } else {
                            System.out.println("ERRO: Opção inválida.");
                            esperar(1);
                        }
                    }
                    break;
                } else if (opcaoCliente == 2) {
                    System.out.println("Operação cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção inválida.");
                    esperar(1);
                }
            }
        }

        System.out.println("\n=> Clientes Disponíveis:\n");
        System.out.println("+------+--------------------------------+");
        System.out.printf("| %-4s | %-30s |\n", "ID", "NOME DO CLIENTE");
        System.out.println("+------+--------------------------------+");
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.printf("| %-4d | %-30s |\n", (i + 1), clientes[i].getNickname());
            }
        }
        System.out.println("+------+--------------------------------+\n");

        Cliente cliente;
        while (true) {
            System.out.print("=> Digite o NOME ou ID do Cliente que deseja realizar a compra: ");
            String inputBusca = sc.nextLine();

            System.out.println("\nVerificando credenciais do cliente...");
            esperar(1);

            cliente = null;
            try {
                int numero = Integer.parseInt(inputBusca);
                int index = numero - 1;
                if (index >= 0 && index < clientes.length && clientes[index] != null) {
                    cliente = clientes[index];
                }
            } catch (NumberFormatException e) {
                cliente = BancoDeDados.buscarClientePorNome(inputBusca);
            }

            if (cliente != null) {
                System.out.println("Cliente encontrado.");
                break;
            }

            boolean breakPoint = false;
            System.out.println("ERRO: '" + inputBusca + "' não encontrado no sistema.");
            System.out.println("  | 1 - Cadastrar Cliente (" + inputBusca + ");");
            System.out.println("  | 2 - Tentar novamente;");
            System.out.println("  | 3 - Cancelar e Sair.");

            while (true) {
                System.out.print("=> Selecione uma opção: ");

                int opcaoCliente;
                try {
                    opcaoCliente = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Opção inválida. Digite apenas números.");
                    esperar(1);
                    continue;
                }

                if (opcaoCliente == 1) {
                    cadastrarCliente(inputBusca);
                    cliente = BancoDeDados.buscarClientePorNome(inputBusca);

                    if (cliente == null) {
                        System.out.println("ERRO CRÍTICO: Falha ao carregar cliente. O Banco de Dados pode estar cheio.");
                        esperar(2);
                        return;
                    }

                    System.out.println("Cliente cadastrado com sucesso!\n");
                    System.out.println("Aviso: O novo cliente não tem fundos para comprar jogos.");
                    System.out.println("  | 1 - Adicionar saldo ao Cliente.");
                    System.out.println("  | 2 - Cancelar compra e sair.");

                    while (true) {
                        System.out.print("=> Selecione uma opção: ");

                        int opcaoSaldo;
                        try {
                            opcaoSaldo = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("ERRO: Digite apenas números.");
                            esperar(1);
                            continue;
                        }

                        if (opcaoSaldo == 1) {
                            adicionarSaldoCliente(sc);
                            break;
                        } else if (opcaoSaldo == 2) {
                            System.out.println("Operação cancelada. Retornando ao menu principal...");
                            esperar(2);
                            return;
                        } else {
                            System.out.println("ERRO: Opção inválida.");
                            esperar(1);
                        }
                    }

                    breakPoint = true;
                    break;
                } else if (opcaoCliente == 2) {
                    esperar(1);
                    break;
                } else if (opcaoCliente == 3) {
                    System.out.println("Operação cancelada. Retornando ao menu principal...");
                    esperar(2);
                    return;
                } else {
                    System.out.println("ERRO: Opção inválida.");
                    esperar(1);
                }
            }

            if (breakPoint) {
                break;
            }
        }

        Jogo[] jogos = BancoDeDados.getJogos();
        boolean ifJogos = false;

        for (Jogo j : jogos) {
            if (j != null) {
                ifJogos = true;
                break;
            }
        }

        if (!ifJogos) {
            System.out.println("ERRO: Nenhum jogo cadastrado no sistema. Retornando ao menu...");
            esperar(2);
            return;
        }

        System.out.println("\n=> Jogos disponíveis para compra:\n");
        System.out.println("+---------------------------+--------+---------------+---------------------------+");
        System.out.printf("| %-25s | %-6s | %-13s | %-25s |\n", "NOME DO JOGO", "ID", "PREÇO", "DESENVOLVEDORA");
        System.out.println("+---------------------------+--------+---------------+---------------------------+");

        for (Jogo j : jogos) {
            if (j != null) {
                System.out.printf("| %-25s | %-6d | R$ %-10.2f | %-25s |\n",
                        j.getNome(),
                        j.getId(),
                        j.getPreco(),
                        j.getDesenvolvedora().getNome());
            }
        }
        System.out.println("+---------------------------+--------+---------------+---------------------------+\n");

        Jogo jogo;
        while (true) {
            System.out.print("=> Digite o NOME ou ID do jogo desejado: ");
            String jogoNomeID = sc.nextLine();

            System.out.println("\nConsultando catálogo de jogos...");
            esperar(1);

            try {
                int jogoID = Integer.parseInt(jogoNomeID);
                jogo = BancoDeDados.buscarJogoPorID(jogoID);
            } catch (NumberFormatException e) {
                jogo = BancoDeDados.buscarJogoPorNome(jogoNomeID);
            }

            if (jogo == null) {
                while (true) {
                    System.out.println("ERRO: '" + jogoNomeID + "' não encontrado no sistema.");
                    System.out.println("  | 1 - Tentar Novamente;");
                    System.out.println("  | 2 - Cancelar e Sair.");
                    System.out.print("=> Selecione uma opção: ");

                    int opcaoBuscaJogo;
                    try {
                        opcaoBuscaJogo = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Digite apenas números.");
                        esperar(1);
                        continue;
                    }

                    if (opcaoBuscaJogo == 1) {
                        esperar(1);
                        break;
                    } else if (opcaoBuscaJogo == 2) {
                        System.out.println("Operação cancelada. Retornando ao menu principal...");
                        esperar(2);
                        return;
                    } else {
                        System.out.println("ERRO: Opção inválida.");
                        esperar(1);
                    }
                }
            } else {
                break;
            }
        }

        System.out.println("Conectando ao gateway de pagamento...");
        esperar(2);
        cliente.comprarJogo(jogo);
        System.out.println("Retornando ao menu principal...");
        esperar(2);
    }

    public static void listarJogos() {
        System.out.println("\nSincronizando com o Banco de Dados...\n");
        Jogo[] jogos = BancoDeDados.getJogos();
        esperar(1.5);

        boolean ifJogos = false;

        for (Jogo jogo : jogos) {
            if (jogo != null) {
                ifJogos = true;
                break;
            }
        }

        if (!ifJogos) {
            System.out.println("Nenhum jogo encontrado no sistema. Se for desenvolvedor, registre um novo jogo (Opção 2), caso contrário espere até o Banco de Dados ser atualizado.");
            esperar(2);
            return;
        }

        System.out.println("=> Jogos no sistema:\n");

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
        System.out.println("Pressione ENTER para voltar ao Menu Principal...");
        new Scanner(System.in).nextLine();
    }

    public static void PerfilCliente(Scanner sc) {
        Cliente[] clientes = BancoDeDados.getClientes();

        boolean ifCliente = false;
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                ifCliente = true;
                break;
            }
        }

        if (!ifCliente) {
            System.out.println("ERRO: Não há clientes no sistema. Por motivos de segurança, cadastre um novo cliente na Opção 3.");
            esperar(2);
            return;
        }

        System.out.println("\n=> Clientes Disponíveis:\n");
        System.out.println("+------+--------------------------------+");
        System.out.printf("| %-4s | %-30s |\n", "ID", "NOME DO CLIENTE");
        System.out.println("+------+--------------------------------+");
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.printf("| %-4d | %-30s |\n", (i + 1), clientes[i].getNickname());
            }
        }
        System.out.println("+------+--------------------------------+\n");

        Cliente cliente = null;
        while (true) {
            System.out.print("=> Digite o NOME ou ID do Cliente que deseja ver o perfil: ");
            String inputBusca = sc.nextLine();

            System.out.println("\nBuscando registro do cliente...");
            esperar(1);

            try {
                int numero = Integer.parseInt(inputBusca);
                int index = numero - 1;
                if (index >= 0 && index < clientes.length && clientes[index] != null) {
                    cliente = clientes[index];
                }
            } catch (NumberFormatException e) {
                cliente = BancoDeDados.buscarClientePorNome(inputBusca);
            }

            if (cliente != null) {
                System.out.println("Cliente encontrado.");
                break;
            }

            System.out.println("ERRO: Cliente não encontrado no sistema.\n  | 1 - Tentar novamente;\n  | 2 - Cancelar e sair");

            int opcaoBusca;
            try{
                opcaoBusca = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("ERRO: Digite apenas números.");
                esperar(1);
                continue;
            }

            if (opcaoBusca == 1){
                esperar(1);
            } else if (opcaoBusca == 2){
                System.out.println("Operação cancelada. Retornando ao menu principal...");
                esperar(2);
                return;
            } else {
                System.out.println("ERRO: Opção inválida.");
                esperar(1);
            }
        }

        System.out.println();
        cliente.imprimirPerfil();
        System.out.println("\nPressione ENTER para voltar ao Menu Principal...");
        sc.nextLine();
    }
}

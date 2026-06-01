package projetoSimples.dominios;

public class BancoDeDados {
    private static Desenvolvedora[] desenvolvedoras = new Desenvolvedora[10];
    private static Jogo[] jogos = new Jogo[50];
    private static Cliente[] clientes = new Cliente[10];

    public static void salvarDesenvolvedora(Desenvolvedora desenvolvedora){
        if (desenvolvedora == null){
            System.out.println("ERRO: Desenvolvedora inválida.");
            return;
        }

        boolean adicionado = false;
        for (int i = 0; i < BancoDeDados.desenvolvedoras.length; i++) {
            if(BancoDeDados.desenvolvedoras[i] == desenvolvedora){
                System.out.println("ERRO: Esta desenvolvedora já está salva.");
                return;
            }

            if (BancoDeDados.desenvolvedoras[i] == null){
                BancoDeDados.desenvolvedoras[i] = desenvolvedora;
                adicionado = true;
                System.out.println("Sucesso! Desenvolvedora salva no banco de Dados.");
                break;
            }
        }

        if (!adicionado){
            System.out.println("ERRO: O limite de Desenvolvedoras no Banco de Dados foi atingido. (10)");
        }
    }

    public static void salvarJogo(Jogo jogo){
        if (jogo == null){
            System.out.println("ERRO: Jogo inválido.");
            return;
        }

        boolean adicionado = false;
        for (int i = 0; i < BancoDeDados.jogos.length; i++) {
            if (BancoDeDados.jogos[i] == jogo){
                System.out.println("ERRO: Esse jogo já está salvo.");
                return;
            }

            if (BancoDeDados.jogos[i] == null){
                BancoDeDados.jogos[i] = jogo;
                adicionado = true;
                System.out.println("Sucesso! Jogo salvo no Banco de Dados.");
                break;
            }
        }

        if(!adicionado){
            System.out.println("ERRO: O limite de Jogos no Banco de Dados foi atingido. (50)");
        }
    }

    public static void salvarCliente(Cliente cliente){
        if (cliente == null){
            System.out.println("ERRO: Cliente inválido.");
            return;
        }

        boolean adicionado = false;
        for (int i = 0; i < BancoDeDados.clientes.length; i++) {
            if (BancoDeDados.clientes[i] == cliente){
                System.out.println("ERRO: Este cliente já está salvo.");
                return;
            }

            if(BancoDeDados.clientes[i] == null){
                BancoDeDados.clientes[i] = cliente;
                adicionado = true;
                System.out.println("Sucesso! Cliente salvo no Banco de Dados.");
                break;
            }

        }

        if (!adicionado){
            System.out.println("ERRO: O limite de Clientes no Banco de Dados foi atingido. (10)");
        }
    }

    public static Desenvolvedora buscarDesenvolvedoraPorNome(String nome){
        for (int i = 0; i < BancoDeDados.desenvolvedoras.length; i++) {
            if (BancoDeDados.desenvolvedoras[i] != null && BancoDeDados.desenvolvedoras[i].getNome().equals(nome)){
                return BancoDeDados.desenvolvedoras[i];
            }
        }

        return null;
    }

    public static Jogo buscarJogoPorNome(String nome){
        for (int i = 0; i < BancoDeDados.jogos.length; i++) {
            if (BancoDeDados.jogos[i] != null && BancoDeDados.jogos[i].getNome().equals(nome)){
                return BancoDeDados.jogos[i];
            }
        }

        return null;
    }

    public static Jogo buscarJogoPorID(int id){
        for (int i = 0; i < BancoDeDados.jogos.length; i++) {
            if (BancoDeDados.jogos[i] != null && BancoDeDados.jogos[i].getId() == id){
                return BancoDeDados.jogos[i];
            }
        }

        return null;
    }
    public static Cliente buscarClientePorNome(String nome){
        for (int i = 0; i < BancoDeDados.clientes.length; i++) {
            if (BancoDeDados.clientes[i] != null && BancoDeDados.clientes[i].getNickname().equals(nome)){
                return BancoDeDados.clientes[i];
            }
        }

        return null;
    }

    public static Desenvolvedora[] getDesenvolvedoras() {
        return BancoDeDados.desenvolvedoras.clone();
    }

    public static Jogo[] getJogos() {
        return BancoDeDados.jogos.clone();
    }

    public static Cliente[] getClientes() {
        return BancoDeDados.clientes.clone();
    }
}

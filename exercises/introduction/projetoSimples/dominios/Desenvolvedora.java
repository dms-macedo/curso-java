package introduction.projetoSimples.dominios;

public class Desenvolvedora {
    private String nome;
    private String nacionalidade;
    private Jogo[] jogosProduzidos = new Jogo[50];

    public Desenvolvedora(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Nome Desconhecido";
            System.out.println("ERRO: Nome Inválido. Valor padrão atribuído.");
        } else {
            this.nome = nome;
        }
    }

    public Desenvolvedora(String nome, String nacionalidade) {
        this(nome);
        if (nacionalidade == null || nacionalidade.trim().isEmpty()) {
            System.out.println("ERRO: Nacionalidade inválida. Valor padrão atribuído.");
            this.nacionalidade = "Nacionalidade Desconhecida.";
        } else {
            this.nacionalidade = nacionalidade;
        }
    }

    //Métodos:

    public void adicionarJogo(Jogo jogo){
        if (jogo == null){
            System.out.println("ERRO: O jogo atribuído é nulo.");
            return;
        }

        boolean adicionado = false;
        for (int i = 0; i < this.jogosProduzidos.length; i++) {
            if (jogosProduzidos[i] == null) {
                jogosProduzidos[i] = jogo;
                adicionado = true;
                break;
            }
        }

        if (!adicionado) {
            System.out.println("ERRO: a capacidade de jogos produzidos da desenvolvedora está cheio (50).");
        }
    }

    public void imprimirInfos(){
        System.out.println("=========================================================");

        System.out.println("=> Nome: " + this.nome);
        System.out.println("=> Nacionalidade: " + this.nacionalidade);
        System.out.println("=> Jogos:");

        for (int i = 0; i < this.jogosProduzidos.length; i++) {
            if (jogosProduzidos[i] == null){
                continue;
            }

            int posicao = i + 1;
            System.out.println("    | Jogo " + posicao + ": " + this.jogosProduzidos[i].getNome());
        }

        System.out.println("=========================================================");
    }

    // Getters e Setters:


    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Jogo[] getJogosProduzidos() {
        return this.jogosProduzidos.clone();
    }
}

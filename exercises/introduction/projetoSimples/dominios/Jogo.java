package introduction.projetoSimples.dominios;

import java.text.NumberFormat;
import java.util.Locale;

public class Jogo {
    private static int posID = 1000;

    private String nome;
    private double preco;
    private Desenvolvedora desenvolvedora;
    private int id;

    {
        this.id = posID;
        posID++;
    }

    public Jogo(String nome, double preco){
        if (nome == null || nome.trim().isEmpty()){
            System.out.println("ERRO: O nome não pode ser nulo ou estar vazio. Atribuindo valor padrão.");
            this.nome = "Jogo Desconhecido";
        } else {
            this.nome = nome;
        }

        if (preco < 0){
            System.out.println("ERRO: O preço não pode ser negativo. Atribuindo valor padrão.");
            this.preco = 0;
        } else {
            this.preco = preco;
        }
    }

    public Jogo(String nome, double preco, Desenvolvedora desenvolvedora) {
        this(nome, preco);
        if (desenvolvedora == null){
            System.out.println("ERRO: A desenvolvedora não pode ser nula. Desenvolvedora padrão atribuída.");
            this.desenvolvedora = new Desenvolvedora("", "");
        } else {
            this.desenvolvedora = desenvolvedora;
        }

        this.desenvolvedora.adicionarJogo(this);
    }

    public void imprimirJogo(){
        System.out.println("=========================================================");

        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);

        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);

        String precoFormatado = dinheiroBR.format(this.preco);
        System.out.println("Preço: " + precoFormatado);

        System.out.println("Desenvolvedora: " + this.desenvolvedora.getNome());
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

    public int getId() {
        return id;
    }
}

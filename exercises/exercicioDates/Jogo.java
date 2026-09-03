package exercicioDates;

import java.util.Date;

public class Jogo {
    private String nome;
    private double preco;
    private Date dataLancamento;

    public Jogo(String nome, double preco, Date dataLancamento) {
        this.nome = nome;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }
}

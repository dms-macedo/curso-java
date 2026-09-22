package exercicioClassesUtilitarias;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Produto implements Serializable, Comparable<Produto>{
    private Long id;
    private String nome;
    private Double preco;
    private LocalDate dataValidade;

    public Produto(Long id, String nome, Double preco, LocalDate dataValidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", dataValidade=" + dataValidade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public String getDataValidadeFormatadaBR() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.dataValidade.format(pattern);
    }

    public boolean isVencido(){
        return this.dataValidade.isBefore(LocalDate.now());
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return this.id.compareTo(outroProduto.getId());
    }
}

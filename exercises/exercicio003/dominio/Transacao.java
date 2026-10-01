package exercicio003.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transacao<T> {
    private T id;
    private String conta;
    private LocalDateTime dataHora;
    private double valor;
    private String categoria;

    public Transacao(T id, String conta, LocalDateTime dataHora, double valor, String categoria) {
        this.id = id;
        this.conta = conta;
        this.dataHora = dataHora;
        this.valor = valor;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", conta='" + conta + '\'' +
                ", dataHora=" + dataHora +
                ", valor=" + valor +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transacao<?> transacao = (Transacao<?>) o;
        return Objects.equals(id, transacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public T getId() {
        return id;
    }

    public String getConta() {
        return conta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }
}

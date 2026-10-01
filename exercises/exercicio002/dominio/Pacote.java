package exercicio002.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pacote<T>{
    private T codigo;
    private String regiao;
    private LocalDateTime dataDespacho;
    private String status;

    public Pacote(T codigo, String regiao, LocalDateTime dataDespacho, String status) {
        this.codigo = codigo;
        this.regiao = regiao;
        this.dataDespacho = dataDespacho;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "codigo=" + codigo +
                ", regiao='" + regiao + '\'' +
                ", dataDespacho=" + dataDespacho +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pacote<?> pacote = (Pacote<?>) o;
        return Objects.equals(codigo, pacote.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public T getCodigo() {
        return codigo;
    }

    public String getRegiao() {
        return regiao;
    }

    public LocalDateTime getDataDespacho() {
        return dataDespacho;
    }

    public String getStatus() {
        return status;
    }
}

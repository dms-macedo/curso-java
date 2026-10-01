package exercicio001.service;

import java.time.LocalDateTime;
import java.util.Objects;

public class RegistroAcesso<T> {
    private T id;
    private LocalDateTime data_hora;
    private String tipoAcesso;

    public RegistroAcesso(T id, LocalDateTime data_hora, String tipoAcesso) {
        this.id = id;
        this.data_hora = data_hora;
        this.tipoAcesso = tipoAcesso;
    }

    @Override
    public String toString() {
        return "RegistroAcesso{" +
                "id=" + id +
                ", data_hora=" + data_hora +
                ", tipoAcesso='" + tipoAcesso + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistroAcesso<?> that = (RegistroAcesso<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public T getId() {
        return id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }
}

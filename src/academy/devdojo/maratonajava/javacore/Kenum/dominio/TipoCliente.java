package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    public final int VALOR;
    public final String NOME;

    TipoCliente(int valor, String nome) {
        this.VALOR = valor;
        this.NOME = nome;
    }
}

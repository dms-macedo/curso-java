package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga>{
    private String nome;
    private Long id;
    private double preco;

    public Manga(String nome, Long id, double preco) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(id);
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(preco, manga.preco) == 0 && Objects.equals(nome, manga.nome) && Objects.equals(id, manga.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, id, preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Manga outroManga) {
        // retorna -1 se this < outroManga
        // retorna 0 se this == outroManga
        // retorna 1 se this > outroManga

        // return this.id.compareTo(outroManga.getId()); < - forma automatizada

        // forma manual
//        if (this.id < outroManga.getId()){
//            return -1;
//        } else if (this.id.equals(outroManga.getId())){
//            return 0;
//        } else {
//            return 1;
//        }

        //por ordem alfabética = String
        return this.nome.compareTo(outroManga.getNome());
    }
}

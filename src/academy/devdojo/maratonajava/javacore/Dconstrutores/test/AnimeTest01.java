package academy.devdojo.maratonajava.javacore.Dconstrutores.test;

import academy.devdojo.maratonajava.javacore.Dconstrutores.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("Akudama Drive", "TV", 12, "Ação", "Production IG");

//        anime.init("Akudama Drive", "TV", 12);
//        anime.init("Akudama Drive", "TV", 12, "Ação");
        anime.imprime();
    }
}

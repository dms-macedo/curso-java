package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();

        Manga m1 = new Manga("Dragon Ball Z", 4L, 19.90);
        Manga m2 = new Manga("Naruto", 2L, 20.0);
        Manga m3 = new Manga("Pokemon", 1L, 100.0);
        Manga m4 = new Manga("Hellsinger", 3L, 1000D);
        Manga m5 = new Manga("Spy X Family", 5L, 2D);

        mangas.add(m1);
        mangas.add(m2);
        mangas.add(m3);
        mangas.add(m4);
        mangas.add(m5);

        for (Manga manga : mangas){
            System.out.println(manga);
        }

        System.out.println("-------------------");

        Collections.sort(mangas);

        for (Manga manga : mangas){
            System.out.println(manga);
        }
    }
}

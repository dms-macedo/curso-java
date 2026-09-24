package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {
        Consumidor c1 = new Consumidor("Davi");
        Consumidor c2 = new Consumidor("João");

        Manga m1 = new Manga("Dragon Ball Z", 4L, 19.90);
        Manga m2 = new Manga("Naruto", 2L, 20.0);
        Manga m3 = new Manga("Pokemon", 1L, 100.0);
        Manga m4 = new Manga("Hellsinger", 3L, 1000D);
        Manga m5 = new Manga("Spy X Family", 5L, 2D);

        List<Manga> mangaList = List.of(m1, m2, m3);
        List<Manga> mangaList2 = List.of(m2, m5, m1);
        Map<Consumidor, List<Manga>> consumidorListMangaMap = new HashMap<>();

        consumidorListMangaMap.put(c1, mangaList);
        consumidorListMangaMap.put(c2, mangaList2);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorListMangaMap.entrySet()){
            System.out.print("Consumidor: " + entry.getKey().getNome() + " - Mangas: ");

            for (Manga manga : entry.getValue()) {
                System.out.print("| " + manga.getNome() + " |");
            }
            System.out.println();
        }
    }
}

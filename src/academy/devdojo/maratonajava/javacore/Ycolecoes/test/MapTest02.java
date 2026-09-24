package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor c1 = new Consumidor("Davi");
        Consumidor c2 = new Consumidor("João");

        Manga m1 = new Manga("Dragon Ball Z", 4L, 19.90);
        Manga m2 = new Manga("Naruto", 2L, 20.0);
        Manga m3 = new Manga("Pokemon", 1L, 100.0);
        Manga m4 = new Manga("Hellsinger", 3L, 1000D);
        Manga m5 = new Manga("Spy X Family", 5L, 2D);

        Map<Consumidor, Manga> consumidorMangaMap = new HashMap<>();

        consumidorMangaMap.put(c1, m3);
        consumidorMangaMap.put(c2, m5);

        for(Map.Entry<Consumidor, Manga> entry : consumidorMangaMap.entrySet()){
            System.out.println("Consumidor: " + entry.getKey().getNome() + " | " + "Manga: " + entry.getValue().getNome());
        }

    }
}

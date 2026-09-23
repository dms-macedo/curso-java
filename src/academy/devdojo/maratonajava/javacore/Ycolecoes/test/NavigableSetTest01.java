package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.SmartPhone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneCompareMarca implements Comparator<SmartPhone>{
    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<SmartPhone> set = new TreeSet<>(new SmartphoneCompareMarca()); // O TreeSet organiza a lista com base em um Comparable (A comparação nativa do objeto/classe), ou Comparator(chamado dentro dos parênteses de new TreeSet()).
        SmartPhone smartPhone = new SmartPhone("123", "Nokia");
        SmartPhone smartPhone2 = new SmartPhone("1", "N");
        set.add(smartPhone);
        set.add(smartPhone2);

        System.out.println(set);

        System.out.println("---------------");

        NavigableSet<Manga> mangas = new TreeSet<>(); // Chama o compareTo da classe (No caso ordena em ordem alfabética).
        Manga m1 = new Manga("Dragon Ball Z", 4L, 19.90, 5);
        Manga m2 = new Manga("Naruto", 2L, 20.0, 0);
        Manga m3 = new Manga("Pokemon", 1L, 100.0, 3);
        Manga m4 = new Manga("Hellsinger", 3L, 1000D, 9);
        Manga m5 = new Manga("Spy X Family", 5L, 2D, 0);

        mangas.add(m1);
        mangas.add(m2);
        mangas.add(m3);
        mangas.add(m4);
        mangas.add(m5);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}

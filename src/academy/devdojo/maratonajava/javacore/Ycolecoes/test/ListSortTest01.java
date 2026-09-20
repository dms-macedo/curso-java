package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>();
        mangas.add("Berserk");
        mangas.add("Naruto");
        mangas.add("Dragon Ball Z");
        mangas.add("Pokemon");
        mangas.add("Hellsing");
        mangas.add("Attack on Titan");

        Collections.sort(mangas); // Collections = Classe Utilitária para trabalhar com as coleções;

        for (String manga : mangas){
            System.out.println(manga);
        }

        List<Double> dinheiros = new ArrayList<>();

        dinheiros.add(21.2);
        dinheiros.add(100000.1);
        dinheiros.add(1D);
        dinheiros.add(22.92);
        dinheiros.add(90.11);

        System.out.println(dinheiros);
        Collections.sort(dinheiros); // organiza double, int e etc do menor ao maior
        System.out.println(dinheiros);

        new Manga(null, null, 0);
    }
}

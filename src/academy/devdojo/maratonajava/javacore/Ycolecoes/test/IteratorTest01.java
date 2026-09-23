package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(); // Use LinkedList() quando necessário a remoção de itens de uma lista várias vezes, pois os itens da lista com linkedList() sabem um do outro. o remove() de linkedList tem O(1). A programação orientada a interface tem sua vantagem nisso, passe new LinkedList() no lugar de ArrayList(), que não há erros apenas implementações novas ou funcionamento diferente.

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

        /*for (Manga manga : mangas) {
            if (manga.getQuantidade() == 0){  // Não use for para remover itens, lança exceção.
                mangas.remove(manga);
            }
        }*/

        // use Iterator (Forma Manual e Antiga antes do Java 8)
//        Iterator<Manga> mangasIterator = mangas.iterator();
//
//        while (mangasIterator.hasNext()){ enquanto tiver manga na lista
//            Manga manga = mangasIterator.next(); pega o objeto
//            if (manga.getQuantidade() == 0){
//                mangasIterator.remove(); remove ele da lista original pelo mangasIterator
//            }
//        }

        //Forma com Programação Funcional pós java 8:

        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);
    }
}

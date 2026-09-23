package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>(); // A vantagem do Set, é que ele não permite elementos duplicados dentro da coleção. O HashSet faz com que os elementos daquela coleção sejam organizados pelo hash.

        // NÃO EXISTE SELECIONAR ELEMENTOS DO SET COM BASE EM INDEX. Se quiser um Set com ordem de indexação, use new LinkedHashSet().

        Manga m1 = new Manga("Dragon Ball Z", 4L, 19.90, 5);
        Manga m2 = new Manga("Naruto", 2L, 20.0, 0);
        Manga m3 = new Manga("Pokemon", 1L, 100.0, 3);
        Manga m4 = new Manga("Hellsinger", 3L, 1000D, 9);
        Manga m5 = new Manga("Spy X Family", 5L, 2D, 0);
        Manga m6 = new Manga("Spy X Family", 5L, 2D, 0); // O Set chama o equals para cada elemento que for adicionado na coleção e compara todos os elementos já existentes na coleção com o que vai ser adicionado, se o objeto comparado for igual a algum da seleção, ele é barrado. Por isso é necessário um equals sobrecarregado uniforme para sua classe neste caso.

        mangas.add(m1);
        mangas.add(m2);
        mangas.add(m3);
        mangas.add(m4);
        mangas.add(m5);
        mangas.add(m6);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}

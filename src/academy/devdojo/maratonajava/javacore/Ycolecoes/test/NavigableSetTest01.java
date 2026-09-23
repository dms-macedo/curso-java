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

class MangaComparePreco implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
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

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaComparePreco()); // Chama o compareTo da classe (No caso ordena em ordem alfabética).

        /*
        MUITA ATENÇÃO: o TreeSet falha em obedecer um dos contratos da Interface Set, pois, enquanto Set usa equals para comparar 2 objetos e adicionar o comparado a coleção se ele for diferente do comparativo, o TreeSet usa o Comparator ou o Comparable, o que é um ponto de atenção.

         -> Exemplo: se você tem um equals que retorna true se o ID e Nome dos objetos forem iguais, e um compareTo que compara apenas o nome. Se você adicionar:

                Set<ObjetoDeExemplo> setNormal = new HashSet<>();
                NavigableSet<ObjetoDeExemplo> setTree = new TreeSet<>();

                setNormal.add(new ObjetoDeExemplo("Davi", 1L)); <- primeiro parametro nome e segundo ID.
                setNormal.add(new ObjetoDeExemplo("Davi", 2L));
                //O Set Normal adiciona os dois objetos á coleção, pois segundo o equals, eles são objetos diferentes e o Set chama o equals.

                setTree.add(new ObjetoDeExemplo("Davi", 1L)); <- primeiro parametro nome e segundo ID.
                setTree.add(new ObjetoDeExemplo("Davi", 2L));
                //O TreeSet não adiciona os dois elementos, pois ele chama o compareTo que compara apenas o nome, e o nome dos objetos são iguais. Mesmo que o ID seja diferente.
        */
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

        for (Manga manga : mangas) { // Método .descendingSet() inverte a ordem dos elementos.
            System.out.println(manga);
        }

        // Métodos utéis:

        /*
        (<) lower -> pega o elemento imediatamente menor do que o elemento passado. Ex: set.lower(obj) <- retorna o maior objeto menor que obj dentro do set.

        (<=) floor -> pega o elemento imediatamente menor do que o elemento passado ou IGUAL a ele. Ex: set.floor(obj) <- retorna o maior objeto menor que obj ou o objeto igual a obj dentro do set.

        (>) higher -> pega o elemento imediatamente maior do que o elemento passado. Ex: set.higher(obj) <- retorna o menor objeto maior que obj dentro do set.

        (>=) ceiling -> pega o elemento imediatamente maior do que o elemento passado. Ex: set.ceiling(obj) <- retorna o menor objeto maior que obj ou o objeto igual a obj dentro do set

        >>>>>>>>>>> ALERTA: todos esses métodos são comparados com base no Comparator passado na criação do TreeSet ou com base no Comparable da Classe do TreeSet.
         .*/

        //Exemplão:

        System.out.println("--------------");
        Manga manga = new Manga("yu Yu yu", 21L, 21.99);

        //REPARE: Passei um Comparator no TreeSet mangas em sua declaração, onde agora o TreeSet é comparado via preço.
        System.out.println(mangas.lower(manga));
        System.out.println(mangas.floor(manga));
        System.out.println(mangas.higher(manga));
        System.out.println(mangas.ceiling(manga));
        //Métodos de Remoção:

        /*

            .pollFirst -> retorna e REMOVE o primeiro elemento do set.
            .pollLast -> retorna e REMOVE o ultimo elemento do set.

        */

        // Exemplão:
        System.out.println("--------------");

        System.out.println(mangas.size()); // size: 5 antes da remoção.
        System.out.println(mangas.pollFirst()); // retornou o objeto e o removeu do set.
        System.out.println(mangas.size()); // size: 4 depois da remoção
    }
}

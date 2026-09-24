package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
        Consumidor c1 = new Consumidor("Davi");
        Consumidor c2 = new Consumidor("João");

        NavigableMap<String, String> map = new TreeMap<>(); // Ordena pelo Comparator ou Comparable do tipo da Chave. Não conta o valor para ordenação.

        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("E", "Letra E");
        map.put("B", "Letra B");
        map.put("C", "Letra C");

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("------------");
        System.out.println(map.headMap("C")); // retorna todos os valores que vem antes da chave passada, no caso C, vai retornar A e B e seu valores, pois o map está organizado em ordem alfabética, o headMap tem conexão com o map original, se vc remove um valor do map pelo headMap, ele é removido no map original.
        map.headMap("C").remove("A");
        System.out.println(map);

        //passe true no headMap para incluir a chave passada na lista do headMap sendo retornado: a chave passada mais os valores antes dele.

        System.out.println(map.headMap("D", true));

        // Métodos úteis:

        /*
        (<) lower -> pega o elemento imediatamente menor do que o elemento passado. Ex: set.lower(obj) <- retorna o maior objeto menor que obj dentro do set.

        (<=) floor -> pega o elemento imediatamente menor do que o elemento passado ou IGUAL a ele. Ex: set.floor(obj) <- retorna o maior objeto menor que obj ou o objeto igual a obj dentro do set.

        (>) higher -> pega o elemento imediatamente maior do que o elemento passado. Ex: set.higher(obj) <- retorna o menor objeto maior que obj dentro do set.

        (>=) ceiling -> pega o elemento imediatamente maior do que o elemento passado. Ex: set.ceiling(obj) <- retorna o menor objeto maior que obj ou o objeto igual a obj dentro do set

        esses métodos vem acompanhado ou de Entry ou de Key, eles fazem a mesma coisa apenas mudando o retorno, enquanto Entry retorna um Entry o key retorna apenas a chave-valor passada.

        >>>>>>>>>>> ALERTA: todos esses métodos são comparados com base no Comparator passado na criação do TreeSet ou com base no Comparable da Classe do TreeSet.
         .*/

        System.out.println("------------");

        System.out.println(map.ceilingKey("D"));
        System.out.println(map.higherKey("D"));
        System.out.println(map.floorKey("D"));
        System.out.println(map.lowerKey("D"));

        //Métodos de Remoção:

        /*

            .pollFirst -> retorna e REMOVE o primeiro elemento do set.
            .pollLast -> retorna e REMOVE o ultimo elemento do set.

        */
        System.out.println("------------");

        System.out.println(map.pollFirstEntry());
        System.out.println(map);
        System.out.println(map.pollLastEntry());
        System.out.println(map);
    }
}

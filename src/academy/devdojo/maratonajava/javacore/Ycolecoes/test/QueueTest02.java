package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        /*
         * QUEUE (FILA) E PRIORITYQUEUE - RESUMO PRÁTICO
         *
         * 1. MÉTODOS PRINCIPAIS (No dia a dia, prefira a coluna SEGURO):
         * - Inserir: offer()  (retorna false se cheia) | add()     (lança exceção)
         * - Remover: poll()   (retorna null se vazia)  | remove()  (lança exceção)
         * - Espiar:  peek()   (retorna null se vazia)  | element() (lança exceção)
         *
         * 2. COMPORTAMENTO DA PRIORITYQUEUE NO HEAP (MEMÓRIA):
         * - Internamente ela usa uma estrutura de Heap (Árvore binária).
         * - Ela NÃO mantém todos os elementos ordenados em sequência na memória.
         *   A única garantia é que o item de MAIOR PRIORIDADE fica na PRIMEIRA posição.
         * - Por isso, usar 'for-each' imprime o array interno sem ordem definida.
         * - Ao chamar .poll(), o Java remove o item do topo e REORGANIZA o Heap,
         *   promovendo o novo elemento de maior prioridade para a primeira posição.
         *
         * 3. COMO CONSUMIR A FILA CORRETAMENTE:
         * while (!queue.isEmpty()) {
         *     System.out.println(queue.poll()); // Remove o maior da fila e reorganiza o Heap
         * }
         */

        Queue<Manga> mangas = new PriorityQueue<>(); // Customize a prioridade passando um Comparator como parâmetro

        Manga m1 = new Manga("Naruto", 2L, 20.0, 0);
        Manga m2 = new Manga("Pokemon", 1L, 100.0, 3);
        Manga m3 = new Manga("Dragon Ball Z", 4L, 19.90, 5);
        Manga m4 = new Manga("Hellsinger", 3L, 1000D, 9);
        Manga m5 = new Manga("Spy X Family", 5L, 2D, 0);

//        mangas.add(m1);
//        mangas.add(m2);
//        mangas.add(m3); -> não use .add, use .offer(), ele adiciona ja no final da fila
//        mangas.add(m4);
//        mangas.add(m5);

        mangas.offer(m1);
        mangas.offer(m2);
        mangas.offer(m3);
        mangas.offer(m4);
        mangas.offer(m5);

        System.out.println(mangas);

        while(!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }
    }
}

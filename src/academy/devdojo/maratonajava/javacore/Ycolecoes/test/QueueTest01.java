package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        // A Queue é uma coleção que segue por padrão o conceito FIFO -> First In, First Out (Primeiro a entrar, Primeiro a sair). Funciona como uma fila de banco: a primeira pessoa a chegar é a primeira a ser atendida. Na PriorityQueue (Fila de Prioridade), os itens são atendidos por ordem de prioridade. Por isso, os objetos passados no Generics <> precisam implementar a interface Comparable ou receber um Comparator.

        // OBSERVAÇÃO IMPORTANTE: A PriorityQueue garante apenas quem é o PRIMEIRO da fila, sem ordenar tudo na memória. Por isso, percorrer com um 'for' pode mostrar os itens fora de ordem (ex: A, C, B). Porém, na hora de REMOVER os elementos (usando .poll()), eles SEMPRE sairão na ordem exata de prioridade!

        Queue<String> queue = new PriorityQueue<>();
        queue.add("C");
        queue.add("A");
        queue.add("B");

//        for (String q : queue) {
//            System.out.println(q);
//        } -> Forma errada

        while(!queue.isEmpty()){ // Enquanto a queue não estiver vazia
            System.out.println(queue.poll());
        }
    }
}

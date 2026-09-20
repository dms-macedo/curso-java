package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
/*        List lista = new ArrayList(); // Até o java 1.4
        lista.add("Davi");
        lista.add("João");
        lista.add(12222);
        lista.add(true);

        for (Object nome : lista){ // tinha que passar object pq n sabia qual era a classe do objeto
            System.out.println(nome);
        }
*/

        List<String> lista = new ArrayList(); // Até o java 1.5 (Força em compilação o list aceitar apenas String ou o objeto que passar)
        lista.add("Davi");
        lista.add("João");
//        lista.add(11111); <- Erro

        for (String nome : lista){ // agora como a lista é obrigada a ter apenas String, podemos passar String como variavel de referencia.
            System.out.println(nome);
        }

        System.out.println("----------");

        // for indexado (i), usa-se .size em List, invés de .length, dos arrays normais.

        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }

        // List não aceita tipos primitivos, pois puxa equals e hashCode internamente. Aceita apenas objetos.
        System.out.println();
        System.out.println("------ Usando .remove() ------");
        System.out.println();

        List<String> lista2 = new ArrayList<>();
        lista2.add("William");
        lista2.add("Suane");
        lista2.add("Davi");

        for (String nome : lista2){
            System.out.println(nome);
        }

        //aplicando .remove():
        System.out.println("---------");
        lista2.remove(1); // por index, remove o Suane
        for (String nome : lista2){
            System.out.println(nome);
        }

        System.out.println("---------");
        lista2.remove("Davi"); // por objeto, remove o Exato "Davi" que tiver na list (a list usa o equals para ver o exato objeto pedido para remover).
        for (String nome : lista2){
            System.out.println(nome);
        }

        // adicionar um list no outro:

        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();

        nomes.add("Davi");
        nomes.add("Macedo");
        nomes2.add("William");
        nomes2.add("Suane");

        //adicionar todos os valores String de nomes2 á nomes, com .addAll();

        nomes.addAll(nomes2);

        System.out.println(nomes);
    }
}

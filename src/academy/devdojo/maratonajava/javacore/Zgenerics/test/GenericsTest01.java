package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        //Generics obriga o compilador a em tempo de compilação não aceitar elementos fora do tipo passado entre <> a sintaxe oficial fica por exemplo em um List: List<String> lista = new ArrayList<>();

        //Type Erasure = apaga o tipo após o código ser compilado

        List<String> lista = new ArrayList<>(); // na JVM vai estar sem o tipo passado no Generics após compilado, ficando mais ou menos assim: List lista = new ArrayList();

        lista.add("Davi");
        lista.add("João");

        //tome cuidado: se em um método que pedimos uma lista List, e um objeto Consumidor por exemplo, e o metodo adiciona o Consumidor a lista passada, se não for passado o Generics da Lista na criação do parâmetro, o Java pode adicionar um objeto consumidor em uma lista de generic String, veja:

        add(lista, "Maria");

        for (String nomes : lista){ // como adicionamos um objeto Consumidor em uma Lista de Generics String, o java não consegue fazer este for onde nomes aceita apenas String, é preciso passar Object. Para resolver isso, e em um método add por exemplo não ser passado um objeto diferente, obriga-se na criação do parâmetro colocar o Generics <String>
            System.out.println(nomes);
        }
    }

//    private static void add(List lista, Consumidor consumidor){ sem generics no parâmetro lista, aceita qlq tipo de objeto.
//        lista.add(consumidor);
//    }

    private static void add(List<String> lista, String string){ // Agora com Generics no parâmetro, o método aceita apenas valores String para ser adicionado na lista.
        lista.add(string);
    }
}
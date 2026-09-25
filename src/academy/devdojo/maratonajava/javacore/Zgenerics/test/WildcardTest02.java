package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        //O polimorfismo muda para quando usamos Listas, pois como já dito, Listas<> que tenham um tipo passado no Generics, quando compilado é passado para a JVM como List (sem os <>), assim em tempo de compilação o java não deixa você executar o código de classes filhas da classe passada com generics da List, ainda que sejam extendidas.

        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato(), new Gato());

        // printConsulta(cachorros) <- dá erro, pois não é um List<Animal>
        // printConsulta(gatos) <- dá erro, pois não é um List<Animal>

        //Por isso o Wildcard (O coringa é importante).
        // o Wildcard é representado pelo ?.
        //Para por exemplo passarmos que uma Lista Animal pode aceitar qualquer tipo que extenda Animal usamos <? extends Animal>, veja:
        //Mas usando esta sintaxe, você perde a possibilidade de adicionar coisas a Lista. pois o java não consegue garantir o tipo exato que a Lista possui em tempo de execução.

        printConsulta(cachorros);
        printConsulta(gatos); // agora fica tudo certo, pois como passado no parâmetro do método, a lista aceita qualquer tipo que extenda animal.x

        //Para adicionar dados, use o super (<? super Animal>), o super garante que o tipo passado é o tipo ou um tipo maior (Object no caso), para um <? super Cachorro>, ele aceita Animal e Object. Isso permite adicionar valores.


    }

    private static void printConsulta(List<? extends Animal> animais){ // Só aceita List<Animal>, não aceita filhas.
        for (Animal animal : animais){
            animal.consultar();
        }

        // animais[1] = new Gato(); <- Isso da uma exceção ArrayStoreException, pois quando este código é executado pra um array de cachorros por exemplo, não é possivel colocar na posição 1, um gato. Isso seria possivel se criasse um array de Animais (Animal[] animais) e adicona-se cachorros e gatos, já que eles extendem de Animal. (Vá para WildcardTest02).
    }

    private static void printConsultaAnimal(List<? super Animal> animais){ // Passa pois Animal aceita seus filhos.
        animais.add(new Cachorro());
    }
}

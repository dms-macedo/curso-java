package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros.add(3);
        numeros.add(2);
        numeros.add(0);
        numeros.add(5);
        numeros.add(4);

        Collections.sort(numeros);
        // binarySearch vai procurar na list, qual a posição do elemento passado na list, se não tiver o elemento, ele retorna (-(ponto de inserção) -1).

        //index 0,1,2,3,4
        //value 0,2,3,4,5

        int posicao = Collections.binarySearch(numeros, 2);
        int pontoDeInsercao = 0;
        if (posicao < 0){
            pontoDeInsercao = (posicao + 1) * -1;
            System.out.println(pontoDeInsercao);
        } else {
            System.out.println(posicao);
        }
    }
}

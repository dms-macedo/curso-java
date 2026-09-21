package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numerosIntegerList = new ArrayList<>();

        numerosIntegerList.add(1);
        numerosIntegerList.add(2);
        numerosIntegerList.add(3);

        Integer[] listToArray = numerosIntegerList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listToArray));

        System.out.println("------------");
        Integer[] numerosIntegerArray = new Integer[3];
        numerosIntegerArray[0] = 1;
        numerosIntegerArray[1] = 2;
        numerosIntegerArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosIntegerArray); // não pode fazer operações quando é asList().

        arrayToList.set(0, 12);
//        arrayToList.add(19); não pode

        System.out.println(Arrays.toString(numerosIntegerArray));
        System.out.println(arrayToList);

        System.out.println("------------");

        List<Integer> numerosIntegerListChecked = new ArrayList<>(Arrays.asList(numerosIntegerArray)); // Cria um novo list passando como parâmetro o asList do array original, quebrando o link com o array original.
        numerosIntegerListChecked.add(15);
        System.out.println(numerosIntegerListChecked);

        //da pra criar uma lista e adicionar itens em uma unica linha usando o propio asList():

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(nums);
    }
}

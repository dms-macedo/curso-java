package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(); // Map trabalha com chave e valor. Para cada chave, você tem um valor associado. Tecnicamente, Map não faz parte das Collections. new HashMap() é semelhante ao HashSet, ele organiza os elementos com base no hash. Para ter o map por ordem de inserção use new LinkedHashMap<>()

        //Diferente de List e Set, para adicionar valores em um Map, se usa .put passando chave e valor.
        map.put("teklado", "teclado");
        map.put("mause", "mouse");
        map.put("vc", "você"); // Ex: para a chave "vc", temos o valor "você".
        map.put("vc2", "você"); // Valor duplicado mas chave diferente.
        map.putIfAbsent("vc", "você2"); // O map não deixa você ter chaves duplicadas. Se você da .put em um novo valor em uma chave já existente, ele sobrescreve o valor novo sobre o antigo. o método semelhante .putIfAbsent faz o map adicionar o valor passado á chave se não existir um valor ja inserido naquela chave.

        System.out.println(map);

        //UMA CHAVE É UM SET. Por isso não dá pra duplicar chaves. Se usarmos map.keySet(), ele retorna um Set contendo as chaves do map.
        //O VALOR DA CHAVE é o tipo mais genérico da Collections (O Collection), por tanto se usarmos map.values() ele retorna uma Collection com os valores das chaves, ele pode ser duplicado por ser um tipo mais genérico.

        // use map.get() passando uma key nos parênteses para retornar o valor da key.

        //iterando um map pela chave
        for(String key : map.keySet()){
            System.out.println("Chave: " + key + " | " + "Valor: " + map.get(key));
        }
        System.out.println("----------------");

        //iterando os valores
        for (String value : map.values()){
            System.out.println("Valor: " + value);
        }

        System.out.println("----------------");

        //pode-se iterar chave e valor ao mesmo tempo usando o Entry, com a sintaxe: Map.Entry<Tipo Chave (do map), Tipo Valor (do map)>.
        // usa-se map.entrySet() para retornar o entry que será usado para iterar sobre chave valor.

        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("Chave: " + entry.getKey() +  " | " + "Valor: " + entry.getValue());
        }
    }
}

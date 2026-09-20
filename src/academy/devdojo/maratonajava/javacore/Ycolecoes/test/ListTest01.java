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
    }
}

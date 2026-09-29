package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> list = criarListDeObjeto(new Barco("Lancha"));
        list.add(new Barco("Cruzeiro"));
        System.out.println(list);
    }

    private static <T> List<T> criarListDeObjeto(T t){
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

}

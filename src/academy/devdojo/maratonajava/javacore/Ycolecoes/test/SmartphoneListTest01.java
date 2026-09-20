package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.SmartPhone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone("11111", "Iphone");
        SmartPhone s2 = new SmartPhone("22222", "Samsung");
        SmartPhone s3 = new SmartPhone("33333", "Pixel");

        List<SmartPhone> smartPhones = new ArrayList<>(6);

        smartPhones.add(s1);
        smartPhones.add(s2);
        smartPhones.add(0, s3);

//        smartPhones.clear(); <- tira todo mundo do list.

        for (SmartPhone smartPhone : smartPhones){
            System.out.println(smartPhone);
        }

        SmartPhone s4 = new SmartPhone("33333", "Pixel");
        System.out.println(smartPhones.contains(s4));

        int indexSmartPhone4 = smartPhones.indexOf(s4);// retorna o indice do s4 no list, se n econtrar retorna -1
        System.out.println(indexSmartPhone4);
        System.out.println(smartPhones.get(indexSmartPhone4));
    }
}

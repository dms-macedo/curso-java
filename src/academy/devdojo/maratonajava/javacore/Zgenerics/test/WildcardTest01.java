package academy.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal{
    abstract void consultar();
}

class Cachorro extends Animal{
    @Override
    void consultar() {
        System.out.println("Consultando doguinho");

    }
}

class Gato extends Animal{
    @Override
    void consultar() {
        System.out.println("Consultando gatinho");
    }
}
public class WildcardTest01 {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};

        printConsulta(cachorros);
        printConsulta(gatos); // para entender o wildcard e sua necessidade, é preciso ver que em um array normal com polimorfismo, este método printConsulta() aceita e executa o código criado para qualque array de animal que tenha, desde que o objeto passado extenda de Animal (Herança)
    }

    private static void printConsulta(Animal[] animais){
        for (Animal animal : animais){
            animal.consultar();
        }

        // animais[1] = new Gato(); <- Isso da uma exceção ArrayStoreException, pois quando este código é executado pra um array de cachorros por exemplo, não é possivel colocar na posição 1, um gato. Isso seria possivel se criasse um array de Animais (Animal[] animais) e adicona-se cachorros e gatos, já que eles extendem de Animal. (Vá para WildcardTest02).
    }
}

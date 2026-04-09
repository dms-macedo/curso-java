package introduciton.exercises;

public class ex003 {
    public static void main(String[] args) {
        String[] hotbar = new String[]{"Picareta de Diamante", "Machado de Diamante", "Espada de Diamante", "Maçã Dourada Encantada"};

        System.out.println("=========== Items na Hotbar ===========");
        System.out.println("---------------------------------");

        for (String item : hotbar) {
            System.out.println("|  " + item);
        }

        System.out.println("---------------------------------");
    }
}

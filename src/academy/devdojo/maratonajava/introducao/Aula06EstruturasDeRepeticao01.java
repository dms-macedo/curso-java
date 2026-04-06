package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao01 {
    public static void main(String[] args) {
        //while, do while e for

        int count = 0;

        while(count < 10){
            count++;
            System.out.println("Treinando While: " + count);
        } // Repete o bloco de código até que a condição for false

        int count2 = 0;

        do {
            System.out.println("Treinando Do While: " + count2);
            ++count2;
        } while (count2 < 10); // Executa pelo menos 1 vez independente se a condição é true ou false

        for (int i=0; i<10; i++) {
            System.out.println("For: " + i);
        }
    }
}

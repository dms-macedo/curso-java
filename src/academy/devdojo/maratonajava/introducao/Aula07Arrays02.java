package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays02 {
    public static void main(String[] args) {
        // Padrões de inicialização:
            // byte, short, int, long, float e double => 0
            // char => '\u0000'
            // boolean => false
            // String => null

        String[] nomes = new String[4];
        nomes[0] = "Goku";
        nomes[1] = "Naruto";
        nomes[2] = "Luffy";
        nomes[3] = "Sasuke";

        // Usando loop para printar os valores
        for (int i = 0; i < nomes.length; i++) { // Usamos length para dizer seu tamanho
            System.out.println(nomes[i]);
        }
    }
}

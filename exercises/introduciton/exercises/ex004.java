package introduciton.exercises;

public class ex004 {
    public static void main(String[] args) {
        int quantidadeEspeciaria = 0;
        String alertas = "";
        int [][] mapa = {{1, 2, 1},{2, 0, 1},{0, 2, 1}};

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length;  j++) {
                System.out.print(mapa[i][j] + " ");
                if (mapa[i][j] == 1) {
                    quantidadeEspeciaria += mapa[i][j];
                } else if (mapa[i][j] == 2) {
                    alertas += "Verme Detectado! Posição Atual do animal: " + "[" + i + "]" + " [" + j + "]\n";
                }
            }
            System.out.println();
        }

        System.out.println(alertas);
        System.out.println("Varredura Finalizada! Quantidade de especiaria encontrada: " + quantidadeEspeciaria);

    }
}

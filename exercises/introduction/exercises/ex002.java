package introduction.exercises;

public class ex002 {
    public static void main(String[] args) {
        String ataque = "Kratos atacou: ";
        String relatorio;
        int dano = 5;
        int vida = 25;

        for (int i = 0; i < 5; i++) {
            System.out.println(ataque + "-" + dano + " de dano!");
            vida -= dano;
        }

        if (vida > 0) {
            relatorio = "Você sobreviveu aos ataques de kratos!";
        } else {
            relatorio = "Você morreu.";
        }

        System.out.println(relatorio);
    }
}

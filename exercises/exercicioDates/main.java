package exercicioDates;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=========== [ SPACE GAME CENTER ] ===========");
            System.out.println("===========    Registro de Jogo   ===========");
            System.out.println(">>> Escolha uma opção:\n1 - Registrar Jogo no catálogo;\n2 - Sair.");
            int opcao = 0;
            while (true){
                System.out.print("Digite uma opção: ");
                String option = sc.nextLine();

                try{
                    int number = Integer.parseInt(option);
                    opcao = number;
                    break;
                } catch (NumberFormatException e){
                    System.out.println("ERRO: Digite um número.");
                }

                if (opcao == 1){
                    System.out.print("| Digite o nome do jogo: ");
                    String nome = sc.nextLine();
                    System.out.print("| Digite o preço do jogo: ");
                    String preco = sc.nextLine();
                    System.out.println("| Digite a data de lançamento do jogo (dd/mm/yyyy): ");
                }
            }

        }
    }
}

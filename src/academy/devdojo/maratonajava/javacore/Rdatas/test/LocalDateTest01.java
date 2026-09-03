package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.util.Scanner;

public class LocalDateTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("O GRANDE IMPRIMIDOR DE DATASKKKKKKKKKKKKKKKK");
        System.out.println("1 - Imprimir data manualmente.\n2 - Imprimir data atual.\n 3 - Sair.");

        int opcao = -1;
        while (true){
            System.out.print("> Digite uma opção: ");
            String result = sc.nextLine();

            try{
                opcao = Integer.parseInt(result);
            } catch (NumberFormatException e){
                System.out.println("ERRO: Digite apenas números.");
                continue;
            }

            while (true){
                if (opcao == 1){
                    System.out.print("> Digite o dia: ");
                    int dia = sc.nextInt();
                    System.out.print("> Digite o mês (Número): ");
                    int mes = sc.nextInt();
                    System.out.println("> Digite o ano: ");
                    int ano = sc.nextInt();

                    LocalDate data = LocalDate.of(ano, mes, dia);

                    System.out.println("O IMPRIMIDOR DE DATAS (KKKKKKKKKKKKKKKKKKKK) IMPRIMIU: " + data.getDayOfMonth() + " de " + data.getMonth() + " de " + data.getYear());
                }
            }
        }
    }
}

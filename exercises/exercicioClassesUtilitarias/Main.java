package exercicioClassesUtilitarias;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=============== [ CRIADOR DE PRODUTOS ] ===============");

        int opcao = -1;
        while (true){
            System.out.println("| 1 - Registrar Produto;");
            System.out.println("| 2 - Listar Produtos;");
            System.out.println("| 3 - Sair.");
            opcao = sc.nextInt();
        }
    }
}

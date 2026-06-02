package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Televisao;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.servico.CalculadoraImposto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Computador computador = new Computador("ASUS x11", 2000);
        Tomate tomate = new Tomate("SISISI", 10);
        Televisao tv = new Televisao("Samsung 50\" ", 7000);
        CalculadoraImposto.calcularImposto(computador);
        System.out.println("-----------------------------------------------------");
        CalculadoraImposto.calcularImposto(tomate);
        System.out.println("-----------------------------------------------------");
        CalculadoraImposto.calcularImposto(tv);
    }
}

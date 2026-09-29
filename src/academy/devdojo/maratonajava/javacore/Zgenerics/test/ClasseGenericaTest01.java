package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentave;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        BarcoRentave carroRentavelService = new BarcoRentave();
        Carro carro = carroRentavelService.buscarCarroDisponivel();
        System.out.println("Usando carro por 1 mês");
        carroRentavelService.retornarCarroALugado(carro);
    }
}

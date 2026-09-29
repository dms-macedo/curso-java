package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentavelService;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentavelService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca"), new Carro("Mercedez")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Iate"), new Barco("Lancha"), new Barco("Cruzeiro")));

        RentavelService<Barco> rentavelService = new RentavelService<>(barcosDisponiveis);
        Barco objeto = rentavelService.buscarObjetoDisponivel();
        System.out.println("Usando barco por 1 mês.");
        rentavelService.retornarObjetoAlugado(objeto);
    }
}

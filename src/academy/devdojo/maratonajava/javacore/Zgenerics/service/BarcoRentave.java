package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentave {
    private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca"), new Carro("Mercedez")));

    public Carro buscarCarroDisponivel() {
        System.out.println("Buscando carro disponivel...");
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando carro: " + c);
        System.out.println("Carros Disponíveis: ");
        System.out.println(carrosDisponiveis);
        return c;
    }

    public void retornarCarroALugado(Carro carro){
        System.out.println("Devolvendo carro: " + carro);
        carrosDisponiveis.add(carro);
        System.out.println("Carros disponíveis ṕara alugar: ");
        System.out.println(carrosDisponiveis);
    }
}

